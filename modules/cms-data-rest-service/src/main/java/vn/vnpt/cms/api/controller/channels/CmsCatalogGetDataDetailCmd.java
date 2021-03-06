package vn.vnpt.cms.api.controller.channels;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import vn.vnpt.cms.api.cmd.DbCmsCatalogGetDetailColumnCmd;
import vn.vnpt.cms.api.cmd.DbCmsPageGetDataCmd;
import vn.vnpt.cms.api.controller.base.AbsApiBaseParamReqTypeCmd;
import vn.vnpt.cms.api.listener.entities.CmsCatalogSearch;
import vn.vnpt.cms.api.listener.entities.Column;
import vn.vnpt.cms.api.listener.entities.datatable.DataTableResult;
import vn.vnpt.cms.api.listener.entities.datatable.DatatableRequest;
import vn.vnpt.cms.api.listener.entities.datatable.PaginationCriteria;
import vn.vnpt.cms.api.listener.response.BaseResp;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

public class CmsCatalogGetDataDetailCmd extends AbsApiBaseParamReqTypeCmd {
    private long catalogId;
    private int pageIndex;
    private int status;
    private String orderBy;
    private CmsCatalogSearch[] searchColumns;

    public CmsCatalogGetDataDetailCmd(HttpServletRequest httpServletRequest,
                                      String channel, String transId,
                                      long catalogId, int status, String columnSearch) {
        super(httpServletRequest, channel, transId);
        this.catalogId = catalogId;
        this.status = status;
        this.orderBy = "";
        if (!columnSearch.equals("")) {
            searchColumns = gson.fromJson(columnSearch, CmsCatalogSearch[].class);
        }
    }

    @Override
    protected void executeCmd() throws Exception {
        DatatableRequest datatableRequest = new DatatableRequest(this.httpServletRequest);
        PaginationCriteria pagination = datatableRequest.getPaginationRequest();
        String textSearch = "";
        _log.info("Search ..... " + datatableRequest.getSearch());
        if (searchColumns.length > 0) {
            textSearch = buildAdvSearchQuery();
        } else if(!datatableRequest.getSearch().equals("")){
            textSearch = buildSearchQuery(datatableRequest.getSearch());
        }

        DbCmsPageGetDataCmd dbCmd = new DbCmsPageGetDataCmd(this.transId, this.channel, this.catalogId, textSearch
                , pagination.getPageNumber(), pagination.getPageSize(), this.orderBy, this.status);
        this.executeDbCmd(dbCmd);
        if (dbCmd.getCode() == 0) {
            DataTableResult result = new DataTableResult();
            result.setDraw(datatableRequest.getDraw());
            result.setRecordsTotal(dbCmd.getPageInfo().getTotalRecord());
            result.setRecordsFiltered(dbCmd.getPageInfo().getTotalRecord());
            this.strResponse = gson.toJson(result);
            String s1 = this.strResponse.substring(0, this.strResponse.length() - 1);
            s1 = s1.substring(0, s1.length() - 4);
            s1 = s1 + "[" + dbCmd.getXxx() + "]}";
            this.strResponse = s1;
        } else {
            this.strResponse = null;
            this.objResponse = new BaseResp(dbCmd.getCode(), dbCmd.getMessage());
        }
    }

    public String buildAdvSearchQuery() {
        StringBuilder builder = new StringBuilder();
        if (searchColumns.length > 0) {
            for (int i = 0; i < searchColumns.length; ++i) {
                CmsCatalogSearch search = searchColumns[i];
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
                if (i != (searchColumns.length - 1)) {
                    builder.append("AND ");
                }
            }
        }
        return builder.toString();
    }

    public String buildSearchQuery(String searchValue) {
        StringBuilder builder = new StringBuilder();
        DbCmsCatalogGetDetailColumnCmd dbCmd = new DbCmsCatalogGetDetailColumnCmd(this.transId, this.channel, this.catalogId);
        this.executeDbCmd(dbCmd);
        List<Column> columnList = dbCmd.getLsColumn();
        List<Column> columnsSearch = columnList.stream().filter(Column::isSearch).collect(Collectors.toList());

        for (int i = 0; i < columnsSearch.size(); ++i) {
            Column column = columnList.get(i);
            String code = column.getCode();
            builder.append(code);
            builder.append(" LIKE '%");
            builder.append(searchValue);
            builder.append("%' ");
            if (i != (columnsSearch.size() - 1)) {
                builder.append("OR ");
            }
        }

        return builder.toString();
    }


    private final static Log _log = LogFactoryUtil.getLog(CmsCatalogGetDataDetailCmd.class);
}
