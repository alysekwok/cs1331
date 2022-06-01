/**
 * @author akwok6
 * @version 1.0
 */

public abstract class Player implements Comparable<Player> {
    private String name;
    private double points;
    private int trophies;

    /**
     * Accessor for name.
     * @return the name
     */

    public String getName() {
        return name;
    }

    /**
     * Mutator for the name.
     * @param name the new name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor for the amount of points.
     * @return the amount of points
     */

    public double getPoints() {
        return points;
    }

    /**
     * Mutator for the amount of points.
     * @param points the new amount of points
     */

    public void setPoints(double points) {
        this.points = points;
    }

    /**
     * Accessor for the amount of trophies.
     * @return the amount of trophies
     */

    public int getTrophies() {
        return trophies;
    }

    /**
     * Mutator for the number of trophies.
     * @param trophies the new amount of trophies
     */

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

    /**
     * Constructor that takes in name, points, and trophies.
     * @param name the name
     * @param points the amount of points
     * @param trophies the amount of trophies
     */

    public Player(String name, double points, int trophies) {
        this.name = name;
        this.points = points;
        this.trophies = trophies;
    }

    /**
     * Abstract method that calculates skill level.
     * @return a double representing the skill level
     */

    public abstract double calculateSkillLevel();

    /**
     * Overrides Comparable's compareTo() method.
     * @param player a player object
     * @return an int representing which player has a larger skill level
     */
    @Override
    public int compareTo(Player player) {
        if (player.calculateSkillLevel() < calculateSkillLevel()) {
            return 1;
        } else if (player.calculateSkillLevel() > calculateSkillLevel()) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Overrides Object's equals() method.
     * @param o object being compared
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player)) {
            return false;
        } else {
            Player play = (Player) o;
            return play.getName() == getName() && play.getPoints() == getPoints()
                    && play.getTrophies() == getTrophies();
        }
    }

    /**
     * Overrides Object's toString() method.
     * @return a string describing the player
     */
    @Override
    public String toString() {
        return name + ": " + String.format("%.1f", points) + " points - " + trophies + " trophies";
    }

}
