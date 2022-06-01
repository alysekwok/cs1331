
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author akwok6
 * @version 1.0
 */

public class SatelliteDataConverter {
    /**
     * Helper method that returns an array of Satellite objects.
     * @param myFile File object
     * @return array of Satellite objects
     */
    private static Satellite[] createSatelliteArray(File myFile) {
        File[] fileArr = myFile.listFiles();
        Satellite[] satArr =  new Satellite[fileArr.length];
        for (int i = 0; i < (fileArr.length); i++) {
            try {
                String data = "";
                File fileName = fileArr[i];
                System.out.println(fileName);
                Scanner scan = new Scanner(fileName);
                while (scan.hasNextLine()) {
                    data += (scan.nextLine() + "\n");
                }
                satArr[i] = SatelliteTLEParser.parseData(data);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return satArr;

    }

    /**
     * Main method.
     * @param args command line arguments
     */

    public static void main(String[] args) {
        File myFile = new File(args[0]);
        Satellite[] myArr = createSatelliteArray(myFile);
        try {
            FileWriter newFile = new FileWriter("satellite_output.csv");
            for (int i = 0; i < myArr.length; i++) {
                newFile.write(myArr[i].encodeCSV() + "\n"); }
            newFile.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
