package pl.swies.interviewtask.service;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.swies.interviewtask.entity.RecordEntity;

import java.io.*;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class RecordReader {

    /** Get records from received file to be then persisted */
    public static List<RecordEntity> transformCsv(MultipartFile multipartFile) {

        List<RecordEntity> list = new ArrayList<>();

        File file = new File("src/main/resources/temp.csv");
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/temp.csv"))) {
            String line = reader.readLine();
            // Ommiting header row
            line = reader.readLine();
            while (StringUtils.hasLength(line)) {
                String[] attriutes = line.split(",");
                if (attriutes.length < 4)
                    throw new RuntimeException("Error paring csv file");
                RecordEntity entity = new RecordEntity();
                if (StringUtils.hasText(extractValue(attriutes[0])))
                    entity.setPrimaryKey(extractValue(attriutes[0]));
                else {
                    line = reader.readLine();
                    continue;
                }
                entity.setName(extractValue(attriutes[1]));
                entity.setDescription(extractValue(attriutes[2]));

                try {
                    String timestamp = extractValue(attriutes[3]);
                    OffsetDateTime.parse(timestamp);
                    entity.setUpdatedTimestamp(timestamp);
                } catch (DateTimeParseException exception) {

                    exception.printStackTrace();
                }
                list.add(entity);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static String extractValue(String val) {
        val = val.trim();
        val = val.substring(1, val.length() - 1);
        val = val.trim();
        return val;
    }

}
