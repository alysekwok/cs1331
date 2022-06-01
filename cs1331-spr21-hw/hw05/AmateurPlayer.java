/**
 * @author akwok6
 * @version 1.0
 */
public class AmateurPlayer extends Player {

    /**
     * Constructor that takes in name, points, and trophies.
     * @param name name
     * @param points points
     * @param trophies trophies
     */

    public AmateurPlayer(String name, double points, int trophies) {
        super(name, points, trophies);
    }

    /**
     * Calculates the skill level of the AmateurPlayer.
     * @return the calculated skill level
     */

    public double calculateSkillLevel() {
        return getPoints() + 0.5 * getTrophies();
    }
}
