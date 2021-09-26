package vn.vnpt.cms.api.kernel.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import vn.vnpt.cms.api.config.CoreConfig;

import java.io.File;
import java.io.FileOutputStream;

public class ExportPDFUtils {
    public ExportPDFUtils() {
    }

    public static void createSamplePDF(String[] header, String[][] body, String filePath) throws Exception {
        String[] temp = new String[header.length + 1];
        temp[0] = "STT";

        for (int i = 0; i < header.length; ++i) {
            temp[i + 1] = header[i];
        }

        header = temp;
        if (body != null) {
            String[][] temp2 = new String[body.length][body[0].length + 1];

            for (int i = 0; i < body.length; ++i) {
                temp2[i][0] = String.valueOf(i + 1);

                for (int j = 0; j < body[i].length; ++j) {
                    temp2[i][j + 1] = body[i][j];
                }
            }

            body = temp2;
        }

        Document document = new Document();
        document.setPageSize(new Rectangle((float) (150 * (temp.length - 1) + 50), 1000.0F));
        File file = new File(filePath);
        boolean isCreate = file.createNewFile();
        FileOutputStream fop = new FileOutputStream(file);
        PdfWriter.getInstance(document, fop);
        document.open();
        BaseFont unicode = BaseFont.createFont("/fonts/arial.ttf", "Identity-H", true);
        Font fontHeader = new Font(unicode, 12.0F, 1);
        Font fontBody = new Font(unicode, 12.0F, 0);
        float[] relativeWidths = new float[temp.length];
        relativeWidths[0] = CoreConfig.STT_LENGTH;

        for (int i = 1; i < header.length; ++i) {
            relativeWidths[i] = CoreConfig.COLUMN_LENGTH;
        }

        PdfPTable pdfPTable = new PdfPTable(relativeWidths);

        for (int j = 0; j < header.length; ++j) {
            Phrase phrase = new Phrase(header[j], fontHeader);
            PdfPCell cell = new PdfPCell(phrase);
            cell.setBorderWidth(1.0F);
            cell.setPadding(2.0F);
            cell.setFixedHeight(16.0F);
            cell.setHorizontalAlignment(1);
            cell.setBackgroundColor(new BaseColor(255, 200, 0));
            pdfPTable.addCell(cell);
        }

        document.add(pdfPTable);
        if (body != null) {
            PdfPTable table = new PdfPTable(relativeWidths);

            for (int i = 0; i < body.length; ++i) {
                for (int j = 0; j < body[i].length; ++j) {
                    Phrase phrase = new Phrase(body[i][j], fontBody);
                    PdfPCell cell = new PdfPCell(phrase);
                    if (j == 0) {
                        cell.setHorizontalAlignment(1);
                    }

                    table.addCell(cell);
                }
            }

            document.add(table);
            document.close();
            fop.flush();
            fop.close();
        }

    }
}
