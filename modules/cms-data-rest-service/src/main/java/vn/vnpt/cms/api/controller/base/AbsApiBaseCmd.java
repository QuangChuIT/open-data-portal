package vn.vnpt.cms.api.controller.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;
import vn.vnpt.cms.api.config.CoreConfig;
import vn.vnpt.cms.api.kernel.db.cmd.DbCommand;
import vn.vnpt.cms.api.kernel.db.spi.DBLogicImpl;
import vn.vnpt.cms.api.kernel.textbase.TimeUtils;
import vn.vnpt.cms.api.kernel.util.StringUtil;
import vn.vnpt.cms.api.listener.response.BaseResp;
import vn.vnpt.cms.api.listener.response.ResultCode;
import vn.vnpt.cms.api.kernel.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

public abstract class AbsApiBaseCmd {
    protected static Gson gson;

    static {
        gson = (new GsonBuilder()).setDateFormat(CoreConfig.API_DATE_TIME_OUTPUT_FORMAT).serializeNulls().create();
    }

    protected final Log logger = LogFactoryUtil.getLog(this.getClass());
    protected HttpServletRequest httpServletRequest;
    protected String transId;
    protected String channel;
    protected String token;
    protected User loginCmsInfo;
    protected String jsonRequest;
    protected Class<?> classRequest;
    protected Object objRequest;
    protected String strResponse = null;
    protected BaseResp objResponse;
    protected Response response;
    protected long begin_time;
    protected long end_date;
    protected String action;

    public AbsApiBaseCmd(HttpServletRequest httpServletRequest, String channel, String transId) {
        this.begin_time = System.currentTimeMillis();
        this.httpServletRequest = httpServletRequest;
        this.channel = channel;
        this.transId = transId;
    }

    public AbsApiBaseCmd(HttpServletRequest httpServletRequest, String jsonRequest, Class<?> classRequest) {
        this.begin_time = System.currentTimeMillis();
        this.httpServletRequest = httpServletRequest;
        this.jsonRequest = jsonRequest;
        this.classRequest = classRequest;
    }

    public AbsApiBaseCmd(HttpServletRequest httpServletRequest, String jsonRequest) {
        this.begin_time = System.currentTimeMillis();
        this.httpServletRequest = httpServletRequest;
        this.token = this.getToken();
        this.jsonRequest = jsonRequest;
    }

    public AbsApiBaseCmd() {
    }

    protected String getToken() {
        String token = null;
        if (this.httpServletRequest == null) {
            return null;
        } else {
            try {
                if (!Validator.isNull(this.httpServletRequest.getHeader("Authorization"))) {
                    token = this.httpServletRequest.getHeader("Authorization");
                }

                token = token.replace("Bearer ", "");
                token = token.trim();
                return token;
            } catch (Exception var3) {
                return null;
            }
        }
    }

    protected boolean validateToken() {
        return true;
    }

    public long getAccountIdCmsLoginInfo() {
        return this.loginCmsInfo != null ? this.loginCmsInfo.getUserId() : 0L;
    }

    public void execute() {

    }

    protected boolean validateData() {
        return true;
    }

    protected abstract void executeCmd() throws Exception;

    protected void executeDbCmd(DbCommand dbCmd) {
        try {
            DBLogicImpl.getInstance().executeCommand(dbCmd);
        } catch (Exception e) {
            this.logger.warn(e.getMessage(), e);
        }

    }

    protected void createResponse() {
        ResponseBuilder builder;
        if (this.strResponse == null) {
            if (this.objResponse == null) {
                this.objResponse = new BaseResp(ResultCode.UNKNOWN_ERROR);
            }
            this.strResponse = gson.toJson(this.objResponse);
        }

        try {
            builder = Response.ok();
            builder.entity(this.strResponse);
        } catch (Exception e) {
            this.logger.warn(String.format("END_CMD transId: %s, channel: %s, request: %s, jsonRequest: %s," +
                            " classRequest: %s, cmd: %s, time: %s, response: %s, Exception: %s", this.transId, this.channel,
                    this.logRequest(), this.jsonRequest,
                    this.classRequest, this.toString(), this.logTimeExecute(), this.logResponse(), e.getMessage()), e);
            builder = Response.status(Status.SERVICE_UNAVAILABLE.getStatusCode());
            builder.entity(e.toString());
        }

        this.response = builder.build();

        try {
            if (!StringUtils.isNullOrEmpty(this.action)) {
                this.logToDb();
            }
        } catch (Exception ex) {
            this.logger.info("Error when save log to Db ! " + ex);
        }

    }

    public Response getResponse() {
        return this.response;
    }

    public String logResponse() {
        return StringUtil.cutString(this.strResponse, CoreConfig.RESPONSE_LOG_MAX_LENGTH);
    }

    public String logRequest() {
        return this.httpServletRequest == null ? null : String.format("[from_addr: %s, method: %s, path: %s, param: %s, token: %s]",
                this.httpServletRequest.getRemoteAddr(), this.httpServletRequest.getMethod(),
                this.httpServletRequest.getPathInfo(),
                this.httpServletRequest.getQueryString(), StringUtil.cutString(this.token, CoreConfig.TOKEN_LOG_MAX_LENGTH));
    }

    public String logTimeExecute() {
        return TimeUtils.getDurations(System.currentTimeMillis(), this.begin_time);
    }

    public User getAccountCmsLoginInfo() {
        return this.loginCmsInfo;
    }

    public String toString() {
        return this.getClass().getName() + " [transId=" + this.transId + ", channel=" + this.channel + "]";
    }

    protected void setResponse(int code, String mess, Object data) {
        if (code == 0) {
            this.objResponse = new BaseResp(code, mess, data);
        } else {
            this.objResponse = new BaseResp(code, mess);
        }
    }

    protected void logToDb() throws Exception {
        /*String detail = String.format("Request: %s, Response: %s",
                this.jsonRequest == null ? "" : this.jsonRequest, this.objResponse == null ? "" : this.objResponse);
        DbInsertSystemLogCmd dbCmd = new DbInsertSystemLogCmd("SYSTEM_LOGGER", "SYSTEM_LOGGER",
                this.action, this.getRemoteAddrIp(), this.getAccountCmsLoginInfo() == null ? "" : this.getAccountCmsLoginInfo().getUser_name(),
                detail, this.objResponse.getError().getCode());
        MainApplication.cmsDb.getDbCtrl().executeCommand(dbCmd);
        if (dbCmd.getCode() != 0) {
            this.logger.warn("Cant not save log to Db !");
        }

        this.logger.warn("Save log to Db success !");*/
    }

    protected String getRemoteAddressIp() {
        String ip = "";
        if (StringUtils.isNullOrEmpty(ip) && this.httpServletRequest.getHeader("X-Forwarded-For") != null) {
            ip = this.httpServletRequest.getHeader("X-Forwarded-For").split(",")[0];
        }

        if (StringUtils.isNullOrEmpty(ip)) {
            ip = this.httpServletRequest.getRemoteAddr();
        }

        return ip;
    }
}
