package vn.vnpt.cms.api.cmd;

import vn.vnpt.cms.api.kernel.db.cmd.DbCallableCmd;
import vn.vnpt.cms.api.listener.entities.Column;

import java.sql.ResultSet;
import java.util.*;

public class DbExportFileCmd extends DbCallableCmd {
    private List<Column> columnList;
    private Map<String, String> mapColumnNames;
    private List<List<String>> dataExport;
    private final long catalogId;

    public DbExportFileCmd(String transId, String channel, long catalogId) {
        super(transId, channel);
        this.catalogId = catalogId;
    }

    protected void setSqlCommand() throws Exception {
        this.setProc("catalog_export_data", 3);
    }

    protected void setSqlParameter() throws Exception {
        this.cst.registerOutParameter(this.idx++, 4);
        this.cst.registerOutParameter(this.idx++, 12);
        this.cst.setLong(this.idx++, this.catalogId);
    }

    protected void getOutputResult() throws Exception {
        this.code = this.cst.getInt(1);
        this.message = this.cst.getString(2);
        if (this.code == 0) {
            ResultSet rs = this.cst.getResultSet();
            if (rs != null) {
                this.columnList = new ArrayList<>();
                this.mapColumnNames = new HashMap<>();

                try {
                    while (rs.next()) {
                        this.mapColumnNames.put(rs.getString("name"), rs.getString("code_"));
                        Column column = new Column();
                        column.setEntryId(rs.getLong("entryId"));
                        column.setCatalogId(rs.getInt("catalogId"));
                        column.setCode(rs.getString("code_"));
                        column.setName(rs.getString("name"));
                        column.setDataType(rs.getString("dataType"));
                        column.setFormat(rs.getString("format"));
                        column.setDefaultValue(rs.getString("defaultValue"));
                        column.setNotNull(rs.getBoolean("notNull"));
                        column.setHiddenStatus(rs.getBoolean("hiddenStatus"));
                        this.columnList.add(column);
                    }
                } finally {
                    rs.close();
                }
            }

            if (this.cst.getMoreResults()) {
                ResultSet rs2 = this.cst.getResultSet();
                if (rs2 != null) {
                    this.dataExport = new ArrayList<>();

                    try {
                        while (rs2.next()) {
                            List<String> ls = new ArrayList<>();

                            String v;
                            for (Iterator<Column> iterator = this.columnList.iterator(); iterator.hasNext(); ls.add(rs2.getString(v))) {
                                Column cl = (Column) iterator.next();
                                v = cl.getCode();
                                if (v.equals("parent_id")) {
                                    v = "parent_name";
                                }
                            }

                            this.dataExport.add(ls);
                        }
                    } finally {
                        rs2.close();
                    }
                }
            }

            this.logger.info("mapColumnNames.values = " + this.mapColumnNames);
            this.logger.info("dataExport = " + this.dataExport);
        }
    }

    public List<Column> getColumnList() {
        return this.columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }

    public List<List<String>> getDataExport() {
        return this.dataExport;
    }

    public void setDataExport(List<List<String>> dataExport) {
        this.dataExport = dataExport;
    }

    public String toString() {
        return "DbExportFileCmd{columnNames.size=" +
                (this.columnList == null ? null : this.columnList.size()) + ", dataExport="
                + (this.dataExport == null ? null : this.dataExport.size()) + '}';
    }
}
