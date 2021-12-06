import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataFileReader {
  public static ArrayList<String[]> read(String filename) {
    ArrayList<String[]> dataList = new ArrayList<>();
    try {
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj);
      boolean first_line = true;
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if (first_line) {
          first_line = false;
          continue;
        }
        dataList.add(data.split(","));
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return dataList;
  }
}
