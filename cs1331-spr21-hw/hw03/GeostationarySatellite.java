/**
 * @author akwok6
 * @version 1.0
 */
public class GeostationarySatellite extends Satellite {
    /**
     * Constructor that chains to the parent method.
     * @param name the name
     * @param catalogNumber the catalog number
     * @param launchYear the year launched
     * @param launchDay the day launched
     * @param inclination the inclination
     */
    public GeostationarySatellite(String name, int catalogNumber, int launchYear, int launchDay, double inclination) {
        super(name, catalogNumber, launchYear, launchDay, inclination, 1.0);
    }

}
