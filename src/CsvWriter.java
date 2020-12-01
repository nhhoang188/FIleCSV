import java.io.*;
import java.util.*;

public class CsvWriter {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "name, age, street, district, city";

    public static void main(String[] args) {
            String filename = "C:\\Users\\Admin\\IdeaProjects\\TestFileCsv\\info.csv";
            writeCsvFile(filename);
    }

    public static void writeCsvFile(String fileName) {
        Info person1 = new Info("hoang", "18", "thanh nhan", "hai ba trung", "hn");
        Info person2 = new Info("tuan", "22", "lac trung", "hai ba trung", "hn");
        Info person3 = new Info("dat", "23", "vinh tuy", "hai ba trung", "hn");
        List<Info> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Info i : list) {
                fileWriter.append(String.valueOf(i.getName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(i.getAge());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(i.getStreet());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(i.getDistrict());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(i.getCity());
                fileWriter.append(NEW_LINE_SEPARATOR);


            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
        finally {
            assert fileWriter != null;
            try {
//                fileWriter.flush();
//                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}
