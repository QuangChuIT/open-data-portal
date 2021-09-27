package vn.vnpt.cms.api.cmd;

import vn.vnpt.cms.api.kernel.db.cmd.DbPagingCmd;
import vn.vnpt.cms.api.kernel.db.entities.PagingEntity;
import vn.vnpt.cms.api.listener.entities.Column;
import vn.vnpt.cms.api.listener.entities.GetDataFromTable;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class DbCmsPageGetDataCmd extends DbPagingCmd {
    private final long catalogId;
    private final String name;
    private final int pageIndex;
    private final int pageSize;
    private final String orderBy;
    private final int status;
    private GetDataFromTable resp;
    private final List<Column> lsColumn = new ArrayList<>();
    private String xxx;

    public DbCmsPageGetDataCmd(String transId, String channel, long catalogId, String name, int pageIndex, int pageSize, String orderBy, int status) {
        super(transId, channel);
        this.catalogId = catalogId;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.orderBy = orderBy;
        this.name = name;
        this.status = status;
    }

    protected void getOutputResult() throws Exception {
        this.code = this.cst.getInt(1);
        this.message = this.cst.getString(2);
        this.totalRecord = this.cst.getInt(9);
        this.totalPage = this.cst.getInt(10);
        this.beginIdx = this.cst.getInt(11);
        this.endIdx = this.cst.getInt(12);
        this.pageInfo = new PagingEntity(this.pageIndex, this.pageSize, this.totalRecord, this.totalPage, this.beginIdx, this.endIdx);

        try (ResultSet rsColumn = this.cst.getResultSet()) {
            if (rsColumn != null) {
                while (rsColumn.next()) {
                    long entryId = rsColumn.getLong("entryId");
                    int catalogId = rsColumn.getInt("catalogId");
                    String fieldCode = rsColumn.getString("code_");
                    String fieldName = rsColumn.getString("name");
                    String dataType = rsColumn.getString("dataType");
                    String format = rsColumn.getString("format");
                    String defaultValue = rsColumn.getString("defaultValue");
                    boolean notNull = rsColumn.getBoolean("notNull");
                    boolean hiddenStatus = rsColumn.getBoolean("hiddenStatus");
                    boolean isSearch = rsColumn.getBoolean("isSearch");
                    Column obj = new Column();
                    obj.setEntryId(entryId);
                    obj.setCatalogId(catalogId);
                    obj.setName(fieldName);
                    obj.setCode(fieldCode);
                    obj.setDataType(dataType);
                    obj.setFormat(format);
                    obj.setDefaultValue(defaultValue);
                    obj.setNotNull(notNull);
                    obj.setHiddenStatus(hiddenStatus);
                    obj.setSearch(isSearch);
                    this.lsColumn.add(obj);
                }
            }
        }

        StringBuilder builderData = new StringBuilder();
        if (this.cst.getMoreResults()) {

            List<String> columnList = new ArrayList<>();
            try (ResultSet rsData = this.cst.getResultSet()) {
                if (rsData != null) {
                    ResultSetMetaData meta = rsData.getMetaData();
                    int columnCount = meta.getColumnCount();

                    int i;
                    for (i = 1; i < columnCount + 1; ++i) {
                        columnList.add(meta.getColumnName(i));
                    }

                    while (rsData.next()) {
                        builderData.append("{");

                        for (i = 0; i < columnList.size() - 1; ++i) {
                            builderData.append("\"").append(columnList.get(i) == null ? "" : (columnList.get(i)).trim())
                                    .append("\":\"").
                                    append(rsData.getString(columnList.get(i)) == null ? "" : rsData.getString(columnList.get(i)).trim())
                                    .append("\",");
                        }

                        builderData.append("\"")
                                .append(columnList.get(columnList.size() - 1) == null ? "" : (columnList.get(columnList.size() - 1)).trim()).append("\":\"")
                                .append(rsData.getString(columnList.get(columnList.size() - 1)) == null ? "" : rsData.
                                        getString(columnList.get(columnList.size() - 1)).trim())
                                .append("\"");
                        builderData.append("},");
                    }
                }
            }
        }

        String strData = builderData.toString();
        if (!strData.isEmpty()) {
            strData = strData.substring(0, strData.length() - 1);
        }

        this.xxx = strData;
        this.resp = new GetDataFromTable();
        this.resp.setHeaders(this.lsColumn);
    }

    protected void setSqlCommand() throws Exception {
        this.setProc("catalog_get_detail", 12);
    }

    protected void setSqlParameter() throws Exception {
        this.cst.registerOutParameter(this.idx++, 4);
        this.cst.registerOutParameter(this.idx++, 12);
        this.cst.setLong(this.idx++, this.catalogId);
        this.setString(this.name);
        this.cst.setInt(this.idx++, this.pageSize);
        this.cst.setInt(this.idx++, this.pageIndex);
        this.setString(this.orderBy);
        this.cst.setInt(this.idx++, this.status);
        this.cst.registerOutParameter(this.idx++, 4);
        this.cst.registerOutParameter(this.idx++, 4);
        this.cst.registerOutParameter(this.idx++, 4);
        this.cst.registerOutParameter(this.idx++, 4);
    }

    public GetDataFromTable getResp() {
        return this.resp;
    }

    public String getXxx() {
        return this.xxx;
    }
}
