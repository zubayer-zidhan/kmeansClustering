import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "iris.csv";
        String line = "";
        String cvsSplitBy = ",";
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] values = line.split(cvsSplitBy);
                data.add(values);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // print specific columns
        for (String[] row : data) {
            System.out.println("sepal length " + row[0] + " sepal width: " + row[1]);
        }
    }
}
