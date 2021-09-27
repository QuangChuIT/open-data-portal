package vn.vnpt.cms.api.controller.channels;

import vn.vnpt.cms.api.cmd.DbCmsPageGetDataCmd;
import vn.vnpt.cms.api.config.CoreConfig;
import vn.vnpt.cms.api.controller.base.AbsApiBaseBodyReqTypeCmd;
import vn.vnpt.cms.api.listener.entities.CmsCatalogSearch;
import vn.vnpt.cms.api.listener.request.CmsCatalogGetDataReq;
import vn.vnpt.cms.api.listener.response.BaseResp;
import vn.vnpt.cms.api.listener.response.BasicPagingData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmsCatalogGetDataCmd extends AbsApiBaseBodyReqTypeCmd {
    private long catalogId;
    private int pageIndex;
    private String orderBy;
    private List<CmsCatalogSearch> searchColumns;
    private int status;

    public CmsCatalogGetDataCmd() {
        super();
    }

    public CmsCatalogGetDataCmd(HttpServletRequest httpServletRequest, String jsonRequest, Class<?> classRequest) {
        super(httpServletRequest, jsonRequest, classRequest);
    }

    protected void executeCmd() throws Exception {
        String textSearch = "";
        if (searchColumns.size() > 0) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < searchColumns.size(); ++i) {
                CmsCatalogSearch search = searchColumns.get(i);
                String name = search.getName();
                String value = search.getValue();
                String dataType = search.getDataType();
                if (dataType.equals("VARCHAR")) {
                    builder.append(name);
                    builder.append(" LIKE '%");
                    builder.append(value);
                    builder.append("%' ");
                } else if (dataType.equals("BIGINT")) {
                    builder.append(name);
                    builder.append("=");
                    builder.append(value);
                    builder.append(" ");
                } else {
                    builder.append(name);
                    builder.append("=");
                    builder.append(value);
                    builder.append(" ");
                }
                if (i != (searchColumns.size() -1)) {
                    builder.append("AND ");
                }
            }
            textSearch = builder.toString();
        }
        DbCmsPageGetDataCmd dbCmd = new DbCmsPageGetDataCmd(this.transId, this.channel, this.catalogId, textSearch
                , this.pageIndex, CoreConfig.PAGE_SIZE, this.orderBy, this.status);
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
        this.catalogId = ((CmsCatalogGetDataReq) this.objRequest).getCatalogId();
        this.pageIndex = ((CmsCatalogGetDataReq) this.objRequest).getPageIndex();
        this.status = ((CmsCatalogGetDataReq) this.objRequest).getStatus();
        this.searchColumns = ((CmsCatalogGetDataReq) this.objRequest).getSearchColumns();
        this.orderBy = ((CmsCatalogGetDataReq) this.objRequest).getOrderBy();
        return true;
    }

    protected boolean validateToken() {
        return true;
    }
}
