package vn.vnpt.cms.api.controller.base;

import vn.vnpt.cms.api.listener.response.BaseResp;
import vn.vnpt.cms.api.listener.response.ResultCode;

import javax.servlet.http.HttpServletRequest;

public abstract class AbsApiBaseParamReqTypeCmd extends AbsApiBaseCmd {
    public AbsApiBaseParamReqTypeCmd(HttpServletRequest httpServletRequest, String channel, String transId) {
        super(httpServletRequest, channel, transId);
    }

    public void execute() {
        this.logger.debug(String.format("BEGIN_CMD transId: %s, channel: %s, request: %s", this.transId, this.channel, this.logRequest()));
        if (!this.validateToken()) {
            this.createResponse();
        } else if (!this.validateData()) {
            this.objResponse = new BaseResp(ResultCode.REQUEST_INVALID);
            this.createResponse();
        } else {
            try {
                this.executeCmd();
            } catch (Exception e) {
                this.objResponse = new BaseResp(ResultCode.UNKNOWN_ERROR);
                this.logger.warn(String.format("transId: %s, channel: %s, request: %s, exception: %s",
                        this.transId, this.channel, this.logRequest(), e.getMessage()), e);
            }

            this.createResponse();
            this.logger.debug(String.format("END_CMD transId: %s, channel: %s, request: %s, cmd: %s, time: %s, " +
                    "response: %s", this.transId, this.channel, this.logRequest(),
                    this.toString(), this.logTimeExecute(), this.logResponse()));
        }
    }
}
