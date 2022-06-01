/**
 * @author akwok6
 * @version 1.0
 */
public class Satellite {
    private String name;
    private int catalogNumber;
    private int launchYear;
    private int launchDay;
    private double inclination;
    private double meanMotion;

    /**
     * Accessor for name.
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * Mutator for name.
     * @param name the name of Satellite
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor for catalog number.
     * @return catalog number
     */

    public int getCatalogNumber() {
        return catalogNumber;
    }

    /**
     * Mutator for the catalog number.
     * @param catalogNumber the catalog number
     */

    public void setCatalogNumber(int catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    /**
     * Accessor for the launch year.
     * @return the launch year
     */

    public int getLaunchYear() {
        return launchYear;
    }

    /**
     * Mutator for the launch year.
     * @param launchYear the launch year
     */

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    /**
     * Accessor for the launch day.
     * @return the launch day
     */

    public int getLaunchDay() {
        return launchDay;
    }

    /**
     * Mutator for the launch day.
     * @param launchDay the launch day
     */

    public void setLaunchDay(int launchDay) {
        this.launchDay = launchDay;
    }

    /**
     * Accessor for inclination.
     * @return the inclination
     */
    public double getInclination() {
        return inclination;
    }

    /**
     * Mutator for inclination.
     * @param inclination the inclination
     */

    public void setInclination(double inclination) {
        this.inclination = inclination;
    }

    /**
     * Accessor for the mean motion.
     * @return the mean motion
     */

    public double getMeanMotion() {
        return meanMotion;
    }

    /**
     * Mutator for the mean  motion.
     * @param meanMotion the mean motion
     */

    public void setMeanMotion(double meanMotion) {
        this.meanMotion = meanMotion;
    }

    /**
     * Constructor for Satellite that takes in name, catalog number, launch year
     * and day, inclination, and mean motion.
     *
     * @param name the name
     * @param catalogNumber the catalog number
     * @param launchYear the launch year
     * @param launchDay the launch day
     * @param inclination the inclination
     * @param meanMotion the mean motion
     */

    public Satellite(String name, int catalogNumber, int launchYear, int launchDay, double inclination,
                     double meanMotion) {
        this.name = name;
        this.catalogNumber = catalogNumber;
        this.launchYear = launchYear;
        this.launchDay = launchDay;
        this.inclination = inclination;
        this.meanMotion = meanMotion;
    }

    /**
     * Method that calculates orbit time.
     * @return double representing orbit time
     */

    public double orbitTime() {
        double time = (24 * 60) / meanMotion;
        return time;
    }

    /**
     * Overrides Object's toString() method.
     * @return String describing object
     */
    @Override
    public String toString() {
        return name + ": #" + catalogNumber + ". Launched on day " + launchDay
                + " of " + launchYear + ". Inclination: " + inclination + " degrees. "
                + meanMotion + " orbits per day " + orbitTime() + " minutes per orbit.";
    }

    /**
     * Method that returns String CSV.
     * @return string representing CSV
     */

    public String encodeCSV() {
        return name + ", " + catalogNumber + ", " + launchYear + ", " + launchDay + ", " + inclination
                + ", " + meanMotion + ", " + orbitTime() + "\n";

    }
}
