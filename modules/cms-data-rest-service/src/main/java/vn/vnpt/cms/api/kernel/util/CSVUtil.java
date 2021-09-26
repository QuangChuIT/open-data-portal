package vn.vnpt.cms.api.kernel.util;

import vn.vnpt.cms.api.listener.entities.Column;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CSVUtil {
    private BufferedWriter fileWriter;

    public void export(String[] headers, String[][] body, String filePath) {
        

    }
    private String getFileName(String baseName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateTimeInfo = dateFormat.format(new Date());
        return baseName.concat(String.format("_%s.csv", dateTimeInfo));
    }

    private int writeHeaderLine(List<Column> columns) throws IOException {

        int numberOfColumns = columns.size();
        String headerLine = "";

        // exclude the first column which is the ID field
        for (int i = 2; i <= numberOfColumns; i++) {
            String columnName = "";
            headerLine = headerLine.concat(columnName).concat(",");
        }

        fileWriter.write(headerLine.substring(0, headerLine.length() - 1));

        return numberOfColumns;
    }

}
