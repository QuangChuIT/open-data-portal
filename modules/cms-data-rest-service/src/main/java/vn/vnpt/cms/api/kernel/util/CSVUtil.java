package vn.vnpt.cms.api.kernel.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CSVUtil {

    public static void export(String[] headers, List<List<String>> dataExport, String filePath) {
        Path path = Paths.get(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            StringBuilder headerBuilder = new StringBuilder();
            for (String header : headers) {
                headerBuilder.append(header).append(",");
            }
            String headerLine = headerBuilder.toString();
            writer.write(headerLine.substring(0, headerLine.length() - 1));

            for (List<String> data : dataExport) {
                writer.newLine();
                String collect = String.join(",", data);
                writer.write(collect);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
