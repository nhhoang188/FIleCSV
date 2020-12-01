import java.io.*;
import java.util.*;

public class CsvReader {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("C:\\Users\\Admin\\IdeaProjects\\TestFileCsv\\info.csv"));
            while ((line = br.readLine()) != null){
                print(parseCsvLine(line));
            }
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (br!=null) br.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<String>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    private static void print(List<String> info) {
        System.out.println(
                " [name= "
                        + info.get(0)
                        + ", age= " + info.get(1)
                        + " , street=" + info.get(2)
                        + " , district=" + info.get(3)
                        + " , city=" + info.get(4)
                        + "]");
    }
}
