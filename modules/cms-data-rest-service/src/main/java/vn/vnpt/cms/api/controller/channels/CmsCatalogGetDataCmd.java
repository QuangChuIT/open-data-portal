package vn.vnpt.cms.api.controller.channels;

import vn.vnpt.cms.api.cmd.DbCmsPageGetDataCmd;
import vn.vnpt.cms.api.config.CoreConfig;
import vn.vnpt.cms.api.controller.base.AbsApiBaseParamReqTypeCmd;
import vn.vnpt.cms.api.listener.response.BaseResp;
import vn.vnpt.cms.api.listener.response.BasicPagingData;

import javax.servlet.http.HttpServletRequest;

public class CmsCatalogGetDataCmd extends AbsApiBaseParamReqTypeCmd {
    private final long catalogId;
    private final String name;
    private final int page_idx;
    private final String order_by;
    private final int status;

    public CmsCatalogGetDataCmd(HttpServletRequest httpServletRequest, String channel, String transId, long catalogId, String name, int page_idx, String order_by, int status) {
        super(httpServletRequest, channel, transId);
        this.catalogId = catalogId;
        this.page_idx = page_idx;
        this.order_by = order_by;
        this.name = name;
        this.status = status;
    }

    protected void executeCmd() throws Exception {
        DbCmsPageGetDataCmd dbCmd = new DbCmsPageGetDataCmd(this.transId, this.channel, this.catalogId,
                this.name, this.page_idx, CoreConfig.PAGE_SIZE, this.order_by, this.status);
        this.executeDbCmd(dbCmd);
        if (dbCmd.getCode() == 0) {
            this.objResponse = new BaseResp(dbCmd.getCode(), dbCmd.getMessage(), new BasicPagingData(dbCmd.getPageInfo(), dbCmd.getResp()));
            this.strResponse = gson.toJson(this.objResponse);
            String s1 = this.strResponse.substring(0, this.strResponse.length() - 3);
            s1 = s1.substring(0, s1.length() - 4);
            s1 = s1 + "[" + dbCmd.getXxx() + "]}}}";
            this.strResponse = s1;
        } else {
            this.strResponse = null;
            this.objResponse = new BaseResp(dbCmd.getCode(), dbCmd.getMessage());
        }
    }

    protected boolean validateData() {
        return true;
    }

    protected boolean validateToken() {
        return true;
    }
}
