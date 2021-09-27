package vn.vnpt.cms.api.controller.channels;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vn.vnpt.cms.api.cmd.DbExportFileCmd;
import vn.vnpt.cms.api.config.CoreConfig;
import vn.vnpt.cms.api.constants.ExportType;
import vn.vnpt.cms.api.controller.base.AbsApiBaseParamReqTypeCmd;
import vn.vnpt.cms.api.kernel.util.CSVUtil;
import vn.vnpt.cms.api.kernel.util.DateTimeUtil;
import vn.vnpt.cms.api.kernel.util.ExportPDFUtils;
import vn.vnpt.cms.api.listener.entities.Column;
import vn.vnpt.cms.api.listener.response.BaseResp;
import vn.vnpt.cms.api.listener.response.ResultCode;
import vn.vnpt.data.cms.model.Catalog;
import vn.vnpt.data.cms.service.CatalogLocalServiceUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

public class SourceDataExportCmd extends AbsApiBaseParamReqTypeCmd {
    private String fileTemp;
    private final long catalogId;
    private final int type;

    public SourceDataExportCmd(HttpServletRequest httpServletRequest, String channel, String transid, long catalogId, int type) {
        super(httpServletRequest, channel, transid);
        this.catalogId = catalogId;
        this.type = type;
    }

    private static Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<>();
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) 18);
        titleFont.setBold(true);
        CellStyle style = wb.createCellStyle();
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFont(titleFont);
        styles.put("title", style);
        Font monthFont = wb.createFont();
        monthFont.setFontHeightInPoints((short) 9);
        monthFont.setColor(IndexedColors.WHITE.getIndex());
        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(monthFont);
        style.setWrapText(true);
        styles.put("header", style);
        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setWrapText(true);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        styles.put("cell", style);
        return styles;
    }

    protected boolean validateData() {
        return true;
    }

    protected boolean validateToken() {
        return true;
    }

    protected void executeCmd() throws Exception {
        Catalog catalog = CatalogLocalServiceUtil.getCatalog(catalogId);
        String name = catalog.getTableName();
        this.fileTemp = name + "_" + DateTimeUtil.formatDate(new Date(), CoreConfig.API_DATE_TIME_INPUT_FORMAT) + ".csv";
        DbExportFileCmd dbCmd = new DbExportFileCmd(this.transId, this.channel, this.catalogId);
        this.executeDbCmd(dbCmd);
        if (dbCmd.getCode() != 0) {
            this.objResponse = new BaseResp(dbCmd.getCode(), dbCmd.getMessage());
        } else {
            List<Column> columnNames = dbCmd.getColumnList();
            List<List<String>> dataExport = dbCmd.getDataExport();
            if (this.type == ExportType.PDF.getValue()) {
                this.fileTemp = CoreConfig.TEMP_DIR + name + "_" + DateTimeUtil.formatDate(new Date(), CoreConfig.API_DATE_TIME_INPUT_FORMAT) + ".pdf";
                String[] headers = new String[columnNames.size()];

                for (int i = 0; i < columnNames.size(); ++i) {
                    headers[i] = columnNames.get(i).getName();
                }

                if (dataExport.isEmpty()) {
                    this.objResponse = new BaseResp(ResultCode.NO_DATA);
                } else {
                    String[][] body = new String[dataExport.size()][dataExport.get(0).size()];

                    for (int i = 0; i < dataExport.size(); ++i) {
                        for (int j = 0; j < dataExport.get(i).size(); ++j) {
                            body[i][j] = (String) ((List) dataExport.get(i)).get(j);
                        }
                    }

                    ExportPDFUtils.createSamplePDF(headers, body, this.fileTemp);
                }
            } else {
                this.fileTemp = CoreConfig.TEMP_DIR + name + "_" + DateTimeUtil.formatDate(new Date(), CoreConfig.API_DATE_TIME_INPUT_FORMAT) + ".csv";
                String[] headers = new String[columnNames.size()];

                for (int i = 0; i < columnNames.size(); ++i) {
                    headers[i] = columnNames.get(i).getName();
                }
                CSVUtil.export(headers, dataExport, this.fileTemp);
            }
        }
    }

    public String getFileTemp() {
        return this.fileTemp;
    }
}
