

import java.util.Scanner;
/**
 * @author akwok6
 * @version 1.0
 */

public class ClassifiedSatellite extends Satellite {
    /**
     * Constructor that chains to the parent method.
     * @param name the name
     * @param catalogNumber the catalog number
     * @param launchYear the launch year
     * @param launchDay the launch day
     * @param inclination the inclination
     * @param meanMotion the mean motion
     */
    public ClassifiedSatellite(String name, int catalogNumber, int launchYear, int launchDay, double inclination,
                               double meanMotion) {
        super(name, catalogNumber, launchYear, launchDay, inclination, meanMotion);
    }

    /**
     * Helper method that checks whether or not the password entered in correct.
     * @return boolean if password is correct
     */

    public boolean passwordCheck() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Password: ");
        String entry = scan.nextLine();
        return entry.equals("f8ee89496da476b3849f4de45a4528b4");

    }

    /**
     * Overrides Object's toString() method.
     * @return a String describing the object
     */
    @Override
    public String toString() {
        boolean password = passwordCheck();
        if (password) {
            return super.toString();
        } else {
            return "INCORRECT PASSWORD";
        }
    }

    /**
     * Overrides the encodeCSV() in the parent method.
     * @return a string in CSV format
     */
    @Override
    public String encodeCSV() {
        boolean password = passwordCheck();
        if (password) {
            return super.encodeCSV();
        } else {
            return "INCORRECT PASSWORD";
        }
    }


}
