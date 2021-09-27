package vn.vnpt.cms.api.controller.channels;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vn.vnpt.cms.api.cmd.DbGetNumberColumnCmd;
import vn.vnpt.cms.api.cmd.DbSourceDataImportCmd;
import vn.vnpt.cms.api.controller.base.AbsApiBaseParamReqTypeCmd;
import vn.vnpt.cms.api.kernel.util.DateTimeUtil;
import vn.vnpt.cms.api.kernel.util.DateUtils;
import vn.vnpt.cms.api.kernel.util.StringUtils;
import vn.vnpt.cms.api.listener.entities.CatalogFieldInfo;
import vn.vnpt.cms.api.listener.response.BaseResp;
import vn.vnpt.cms.api.listener.response.ResultCode;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.*;

public class SourceDataImportCmd extends AbsApiBaseParamReqTypeCmd {
    private final InputStream uploadedInputStream;
    private final long catalogId;

    public SourceDataImportCmd(HttpServletRequest httpServletRequest, String channel,
                               String transId, InputStream uploadedInputStream, long catalogId) {
        super(httpServletRequest, channel, transId);
        this.uploadedInputStream = uploadedInputStream;
        this.catalogId = catalogId;
    }

    protected boolean validateToken() {
        return true;
    }

    protected void executeCmd() throws Exception {
        Workbook workbook = new XSSFWorkbook(this.uploadedInputStream);
        DbGetNumberColumnCmd dbCmd = new DbGetNumberColumnCmd(this.transId, this.channel, this.catalogId);
        this.executeDbCmd(dbCmd);
        if (dbCmd.getCode() != 0) {
            this.objResponse = new BaseResp(dbCmd.getCode(), dbCmd.getMessage());
        } else {
            String tblName = dbCmd.getTblName();
            List<CatalogFieldInfo> categoryFieldInfoList = dbCmd.getCategoryFieldInfoList();
            List<String> columns = new ArrayList<>();
            Map<String, String> mapColumnName = new HashMap<>();
            for (CatalogFieldInfo categoryFieldInfo : categoryFieldInfoList) {
                String fileName = categoryFieldInfo.getName().trim().toLowerCase();
                columns.add(fileName);
                mapColumnName.put(categoryFieldInfo.getName(), categoryFieldInfo.getCode());
            }
            
            Sheet sheet = workbook.getSheetAt(0);
            Row headers = sheet.getRow(0);

            String importData;
            for (int i = 1; i < categoryFieldInfoList.size() + 1; ++i) {
                Cell cell = headers.getCell(i);
                importData = cell.getStringCellValue().trim().toLowerCase();
                if (!columns.contains(importData)) {
                    this.objResponse = new BaseResp(ResultCode.COLUNM_NAME_INVALID);
                    this.logger.info("Invalid column name !!!!!");
                    return;
                }
            }

            StringBuilder sqlArrayBuilder = new StringBuilder();
            Row row1 = sheet.getRow(1);
            if (row1 == null) {
                this.objResponse = new BaseResp(ResultCode.REQUEST_INVALID);
                this.logger.info("row 1 null");
            } else if (row1.getCell(0) == null) {
                this.objResponse = new BaseResp(ResultCode.REQUEST_INVALID);
                this.logger.info("row 1 cell 0 null");
            } else {
                if (row1.getCell(0).getCellType().equals(CellType.STRING)) {
                    if (StringUtils.isNullOrEmpty(row1.getCell(0).getStringCellValue())) {
                        this.objResponse = new BaseResp(ResultCode.REQUEST_INVALID);
                        this.logger.info("row 1 cell 0 value null");
                        return;
                    }
                } else if (StringUtils.isNullOrEmpty(String.valueOf(row1.getCell(0).getNumericCellValue()))) {
                    this.objResponse = new BaseResp(ResultCode.REQUEST_INVALID);
                    this.logger.info("row 1 cell 0 null");
                    return;
                }

                for (int i = 1; i < sheet.getPhysicalNumberOfRows(); ++i) {
                    Row row = sheet.getRow(i);
                    Cell firstCell = row.getCell(0);
                    if (firstCell.getCellType().equals(CellType.STRING) && StringUtils.isNullOrEmpty(row.getCell(0).getStringCellValue())) {
                        break;
                    }

                    HashMap<String, String> mapValues = new HashMap<>();

                    int j;
                    String format;
                    for (j = 1; j < categoryFieldInfoList.size() + 1; ++j) {
                        String dataType = categoryFieldInfoList.get(j - 1).getDataType();
                        format = categoryFieldInfoList.get(j - 1).getFormat();
                        Cell cell = row.getCell(j);
                        if (cell != null) {
                            CellType cellType = sheet.getRow(0).getCell(j).getCellType();
                            String key = "";
                            if (cellType.equals(CellType.STRING)) {
                                key = sheet.getRow(0).getCell(j).getStringCellValue();
                            } else if (cellType.equals(CellType.NUMERIC)) {
                                key = String.valueOf(sheet.getRow(0).getCell(j).getNumericCellValue());
                            } else {
                                key = this.getDateTimeValue(sheet.getRow(0).getCell(j).getDateCellValue());
                            }

                            String value = null;
                            if (cell.getCellType().equals(CellType.STRING) && dataType.equalsIgnoreCase("VARCHAR")) {
                                value = cell.getStringCellValue();
                                if (value.length() > Integer.parseInt(format)) {
                                    this.objResponse = new BaseResp(ResultCode.FORMAT_INVALID);
                                    return;
                                }
                            } else if (cell.getCellType().equals(CellType.NUMERIC)) {
                                value = String.valueOf(cell.getNumericCellValue());
                                if (StringUtils.isNullOrEmpty(value)) {
                                    try {
                                        value = cell.getStringCellValue();
                                        if (!StringUtils.isNullOrEmpty(value)) {
                                            Double.parseDouble(value);
                                        }
                                    } catch (Exception e) {
                                        this.objResponse = new BaseResp(ResultCode.FORMAT_INVALID);
                                        return;
                                    }
                                }
                            } else if (dataType.equalsIgnoreCase("DATETIME")) {
                                try {
                                    value = DateUtils.format(cell.getDateCellValue(), format);
                                } catch (Exception e) {
                                    this.logger.info(String.format("%s %s", this.transId, e));
                                    this.objResponse = new BaseResp(ResultCode.FORMAT_INVALID);
                                    return;
                                }
                            } else {
                                value = cell.getStringCellValue();
                            }

                            mapValues.put(key, value);
                        }
                    }

                    sqlArrayBuilder.append(this.buildSql(tblName, mapColumnName, mapValues));
                }

                importData = sqlArrayBuilder.toString();
                importData = importData.substring(0, importData.length() - 1);
                DbSourceDataImportCmd importCmd = new DbSourceDataImportCmd(this.transId, this.channel, importData);
                this.executeDbCmd(importCmd);
                this.objResponse = new BaseResp(importCmd.getCode(), importCmd.getMessage());
            }
        }
    }

    protected String buildSql(String tblName, Map<String, String> mapColumnName, Map<String, String> mapValues) {
        StringBuilder sql = new StringBuilder();

        sql.append(String.format("insert into `%s` (", tblName));
        Set<String> keySet = mapColumnName.keySet();
        List<String> columnNames = new ArrayList<>();
        List<String> values = new ArrayList<>();

        for (String key : keySet) {
            columnNames.add(mapColumnName.get(key));
            if (!key.equals("Đơn vị cha") && !key.equals("level")) {
                values.add("\"" + mapValues.get(key) + "\"");
            } else {
                String value = mapValues.get(key);
                if (StringUtils.isNullOrEmpty(value)) {
                    value = "0";
                }

                values.add(value);
            }
        }

        int i;
        for (i = 0; i < columnNames.size() - 1; ++i) {
            sql.append(columnNames.get(i)).append(",");
        }

        sql.append(columnNames.get(columnNames.size() - 1));
        sql.append(") values (");

        for (i = 0; i < values.size() - 1; ++i) {
            sql.append(values.get(i) != null && !values.get(i).equalsIgnoreCase("\"null\"") ? values.get(i)
                    .replaceAll(";", ".") : "\"\"").append(",");
        }

        sql.append(values.get(values.size() - 1) != null && !values.get(values.size() - 1)
                .equalsIgnoreCase("\"null\"") ? values.get(values.size() - 1)
                .replaceAll(";", ".") : "\"\"");
        sql.append(");");
        mapColumnName.remove("level");
        mapColumnName.remove("parent_id");
        return sql + " ";
    }

    protected String getParentId(int level, String[] parentName, String tblName) {
        int index = parentName.length - 2;
        int closeNumber = level;
        StringBuilder sql = new StringBuilder(String.format("select id into @parent_id from %s WHERE name = '%s' and level = '%s' ",
                tblName, parentName[index], level));

        while (level > 0 && index > 0) {
            --level;
            --index;
            sql.append(String.format(" and parent_id in (select id from %s where name = '%s' and level = '%s' ",
                    tblName, parentName[index], level));
        }

        for (int i = 0; i < closeNumber; ++i) {
            sql.append(")");
        }

        sql.append(";");
        return sql.toString();
    }

    protected String getDateTimeValue(Date date) {
        String datetime = null;
        String pattern1 = "yyyy";
        String pattern2 = "MM/yyyy";
        String pattern3 = "dd/MM/yyyy";

        try {
            datetime = DateTimeUtil.formatDate(date, pattern1);
        } catch (Exception e) {
            try {
                datetime = DateTimeUtil.formatDate(date, pattern2);
            } catch (Exception ex) {
                try {
                    datetime = DateTimeUtil.formatDate(date, pattern3);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        }

        return datetime;
    }
}
