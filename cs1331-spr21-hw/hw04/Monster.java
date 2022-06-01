/**
 * @author akwok6
 * @version 1.0
 */
public class Monster implements Comparable<Monster> {
    private String name;
    private int spookiness;

    /**
     * Accessor for name.
     * @return the name
     */

    public String getName() {
        return name;
    }

    /**
     * Mutator for name.
     * @param name the name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor for spookiness.
     * @return the spookiness level
     */

    public int getSpookiness() {
        return spookiness;
    }

    /**
     * Mutator for spookiness.
     * @param spookiness spookiness level
     */

    public void setSpookiness(int spookiness) {
        this.spookiness = spookiness;
    }

    /**
     * Constructor that takes in name and spookiness.
     * @param name the name
     * @param spookiness the level of spookiness
     */

    public Monster(String name, int spookiness) {
        this.name = name;
        this.spookiness = spookiness;
    }

    /**
     * Overrides Comparable's compareTo() method.
     * @param monster object being compared
     * @return int representing greater, equal or less than
     */

    @Override
    public int compareTo(Monster monster) {
        if (spookiness < monster.getSpookiness()) {
            return -1;
        } else if (spookiness > monster.getSpookiness()) {
            return 1;

        } else {
            return 0;
        }
    }

    /**
     * Overrides Object's toString() method.
     * @return a string describing the object
     */

    @Override
    public String toString() {
        return name + " has a spook rating of " + spookiness;
    }


}
