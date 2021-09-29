package vn.vnpt.cms.api.controller.channels;

import vn.vnpt.cms.api.cmd.DbCmsCatalogGetDetailColumnCmd;
import vn.vnpt.cms.api.controller.base.AbsApiBaseParamReqTypeCmd;
import vn.vnpt.cms.api.listener.entities.CatalogGetDetailColumn;
import vn.vnpt.cms.api.listener.response.BaseResp;
import vn.vnpt.cms.api.listener.response.ResultCode;

import javax.servlet.http.HttpServletRequest;

public class CmsCatalogGetDetailColumnCmd extends AbsApiBaseParamReqTypeCmd {
    private final long catalogId;

    public CmsCatalogGetDetailColumnCmd(HttpServletRequest httpServletRequest, String channel, String transId, long catalogId) {
        super(httpServletRequest, channel, transId);
        this.catalogId = catalogId;
    }


    protected void executeCmd() throws Exception {
        DbCmsCatalogGetDetailColumnCmd dbCmd = new DbCmsCatalogGetDetailColumnCmd(this.transId, this.channel, this.catalogId);
        this.executeDbCmd(dbCmd);
        if (dbCmd.getCode() != ResultCode.SUCCESS.getCode()) {
            this.objResponse = new BaseResp(dbCmd.getCode(), dbCmd.getMessage());
        }

        this.objResponse = new BaseResp(dbCmd.getCode(), dbCmd.getMessage(), new CatalogGetDetailColumn(dbCmd.getCateInfo(), dbCmd.getLsColumn()));
    }
}
