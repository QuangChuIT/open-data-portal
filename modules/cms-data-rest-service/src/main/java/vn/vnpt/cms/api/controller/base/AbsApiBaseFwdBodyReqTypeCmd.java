package vn.vnpt.cms.api.controller.base;

import vn.vnpt.cms.api.kernel.util.StringUtils;
import vn.vnpt.cms.api.listener.response.BaseResp;
import vn.vnpt.cms.api.listener.response.ResultCode;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

public abstract class AbsApiBaseFwdBodyReqTypeCmd extends AbsApiBaseCmd {
    public AbsApiBaseFwdBodyReqTypeCmd(HttpServletRequest httpServletRequest, String jsonRequest) {
        super(httpServletRequest, jsonRequest);
    }

    public void execute() {
        this.logger.debug(String.format("BEGIN_CMD transId: %s, channel: %s, request: %s, jsonRequest: %s",
                this.transId, this.channel, this.logRequest(), this.jsonRequest));
        this.jsonRequest = StringUtils.null2Empty(this.jsonRequest);
        if (!this.validateToken()) {
            this.createResponse();
        } else if (!this.validateData()) {
            if (this.objResponse == null) {
                this.objResponse = new BaseResp(ResultCode.REQUEST_INVALID);
            }

            this.createResponse();
            this.logger.debug(String.format("END_CMD transId: %s, channel: %s, request: %s, jsonRequest: %s, classRequest: %s, cmd: %s, time: %s, response: %s",
                    this.transId, this.channel, this.logRequest(),
                    this.jsonRequest, this.classRequest, this.toString(), this.logTimeExecute(), this.logResponse()));
        } else {
            try {
                this.executeCmd();
            } catch (Exception e) {
                this.objResponse = new BaseResp(ResultCode.UNKNOWN_ERROR);
                this.logger.warn(String.format("transId: %s, channel: %s, request: %s, exception: %s",
                        this.transId, this.channel, this.logRequest(), e.getMessage()), e);
            }

            this.createResponse();
            this.logger.debug(String.format("END_CMD transId: %s, channel: %s, request: %s, jsonRequest: %s, classRequest: %s, cmd: %s, time: %s, response: %s",
                    this.transId, this.channel, this.logRequest(), this.jsonRequest,
                    this.classRequest, this.toString(), this.logTimeExecute(), this.logResponse()));
        }
    }

    protected void createResponse() {
        ResponseBuilder builder;
        if (StringUtils.isNullOrEmpty(this.strResponse)) {
            this.objResponse = new BaseResp(ResultCode.UNKNOWN_ERROR);
            this.strResponse = gson.toJson(this.objResponse);
        }

        try {
            builder = Response.ok();
            builder.entity(this.strResponse);
        } catch (Exception e) {
            this.logger.warn(String.format("END_CMD transId: %s, channel: %s, request: %s, jsonRequest: %s, classRequest: %s, " +
                            "cmd: %s, time: %s, response: %s, Exception: %s",
                    this.transId, this.channel, this.logRequest(), this.jsonRequest, this.classRequest, this.toString(),
                    this.logTimeExecute(), this.logResponse(), e.getMessage()), e);
            builder = Response.status(Status.SERVICE_UNAVAILABLE.getStatusCode());
            builder.entity(e.toString());
        }

        this.response = builder.build();
    }

    protected boolean validateToken() {
        return true;
    }
}
