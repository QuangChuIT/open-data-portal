package vn.vnpt.cms.api.controller.channels;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vn.vnpt.cms.api.config.CoreConfig;
import vn.vnpt.cms.api.controller.base.AbsApiBaseParamReqTypeCmd;
import vn.vnpt.cms.api.kernel.util.DateTimeUtil;
import vn.vnpt.data.cms.model.Catalog;
import vn.vnpt.data.cms.model.CatalogFieldName;
import vn.vnpt.data.cms.service.CatalogFieldNameLocalServiceUtil;
import vn.vnpt.data.cms.service.CatalogLocalServiceUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CmsCatalogExportTmp extends AbsApiBaseParamReqTypeCmd {
    private String fileTemp;
    private final long catalogId;

    public CmsCatalogExportTmp(HttpServletRequest httpServletRequest, String channel, String transId, long catalogId) {
        super(httpServletRequest, channel, transId);
        this.catalogId = catalogId;
    }

    protected boolean validateData() {
        return true;
    }

    protected boolean validateToken() {
        return true;
    }

    @Override
    protected void executeCmd() throws Exception {
        Catalog catalog = CatalogLocalServiceUtil.getCatalog(catalogId);
        this.fileTemp = catalog.getTableName() + "_" + DateTimeUtil.formatDate(new Date(), CoreConfig.API_DATE_TIME_INPUT_FORMAT) + ".xlsx";
        ServiceContext serviceContext = ServiceContextFactory.getInstance(httpServletRequest);

        long groupId = serviceContext.getScopeGroupId();

        List<CatalogFieldName> catalogFieldNames = CatalogFieldNameLocalServiceUtil.getList(groupId, catalogId, false);

        if (catalogFieldNames.size() > 0) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            Map<String, CellStyle> styles = createStyles(workbook);
            XSSFCellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            XSSFFont headerFont = workbook.createFont();
            cellStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
            cellStyle.setFillPattern(FillPatternType.NO_FILL);
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 12);
            cellStyle.setFont(headerFont);
            XSSFSheet sheet = workbook.createSheet("IMPORT_DATA");
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell.setCellStyle(styles.get("header"));

            int index;
            for (index = 1; index < catalogFieldNames.size() + 1; ++index) {
                CatalogFieldName column = catalogFieldNames.get(index - 1);
                sheet.setColumnWidth(index, column.getName().length() * 256);
                Cell c = row.createCell(index, CellType.STRING);
                if(column.isNotNull()){
                    c.setCellValue(column.getName() + " (*)");
                } else {
                    c.setCellValue(column.getName());
                }
                c.setCellStyle(styles.get("header"));
            }

            File file = new File(CoreConfig.TEMP_DIR + this.fileTemp);
            file.getParentFile().mkdirs();
            FileOutputStream out = new FileOutputStream(file);
            workbook.write(out);
            this.fileTemp = CoreConfig.TEMP_DIR + this.fileTemp;
        }
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
        monthFont.setFontHeightInPoints((short) 11);
        monthFont.setFontName("Times New Roman");
        monthFont.setBold(true);
        monthFont.setColor(IndexedColors.BLACK.getIndex());
        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
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

    public String getFileTemp() {
        return fileTemp;
    }
}
