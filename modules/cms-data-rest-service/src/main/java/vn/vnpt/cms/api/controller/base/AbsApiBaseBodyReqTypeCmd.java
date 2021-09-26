package vn.vnpt.cms.api.controller.base;

import vn.vnpt.cms.api.listener.request.BaseReq;
import vn.vnpt.cms.api.listener.response.BaseResp;
import vn.vnpt.cms.api.listener.response.ResultCode;

import javax.servlet.http.HttpServletRequest;

public abstract class AbsApiBaseBodyReqTypeCmd extends AbsApiBaseCmd {

    public AbsApiBaseBodyReqTypeCmd(HttpServletRequest httpServletRequest,
                                    String jsonRequest, Class<?> classRequest) {
        super(httpServletRequest, jsonRequest, classRequest);
    }

    public AbsApiBaseBodyReqTypeCmd() {
    }

    public void execute() {
        this.logger.debug(String.format("transId: %s, channel: %s, request: %s, jsonRequest: %s, classRequest: %s",
                this.transId, this.channel, this.logRequest(), this.jsonRequest, this.classRequest));

        try {
            this.objRequest = gson.fromJson(this.jsonRequest, this.classRequest);
            if (this.objRequest == null) {
                this.objResponse = new BaseResp(ResultCode.REQUEST_INVALID);
                this.createResponse();
                return;
            }

            this.transId = ((BaseReq) this.objRequest).getTransId();
            this.channel = ((BaseReq) this.objRequest).getChannel();
        } catch (Exception e) {
            this.logger.warn(String.format("exception: %s", e.getMessage()), e);
            this.createResponse();
            return;
        }

        this.logger.debug(String.format("BEGIN_CMD transId: %s, channel: %s, request: %s, jsonRequest: %s, classRequest: %s",
                this.transId, this.channel, this.logRequest(), this.jsonRequest, this.classRequest));
        if (!this.validateToken()) {
            this.createResponse();
        } else if (!this.validateData()) {
            this.createResponse();
            this.logger.debug(String.format("END_CMD transId: %s, channel: %s, request: %s," +
                            " jsonRequest: %s, classRequest: %s, cmd: %s, time: %s, response: %s",
                    this.transId, this.channel, this.logRequest(), this.jsonRequest, this.classRequest,
                    this.toString(), this.logTimeExecute(), this.logResponse()));
        } else {
            try {
                this.executeCmd();
            } catch (Exception e) {
                this.objResponse = new BaseResp(ResultCode.UNKNOWN_ERROR);
                this.logger.warn(String.format("transId: %s, channel: %s, request: %s, exception: %s",
                        this.transId, this.channel, this.logRequest(), e.getMessage()), e);
            }

            this.createResponse();
            this.logger.debug(String.format("END_CMD transId: %s, channel: %s, request: %s," +
                            " jsonRequest: %s, classRequest: %s, cmd: %s, time: %s, response: %s",
                    this.transId, this.channel, this.logRequest(), this.jsonRequest,
                    this.classRequest, this.toString(), this.logTimeExecute(), this.logResponse()));
        }
    }
}
