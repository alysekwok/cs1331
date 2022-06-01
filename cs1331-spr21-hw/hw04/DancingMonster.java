/**
 * @author akwok6
 * @version 1.0
 */
public class DancingMonster extends Monster implements Danceable {
    private String danceMove;
    private int dancesWon;

    /**
     * Accessor for dance move.
     * @return the dance move
     */

    public String getDanceMove() {
        return danceMove;
    }

    /**
     * Mutator for dance move.
     * @param danceMove the dance move
     */

    public void setDanceMove(String danceMove) {
        this.danceMove = danceMove;
    }

    /**
     * Accessor for the amount of dances won.
     * @return the amount of dances won
     */

    public int getDancesWon() {
        return dancesWon;
    }

    /**
     * Mutator for the amount of dances won.
     * @param dancesWon amount of dances won
     */

    public void setDancesWon(int dancesWon) {
        this.dancesWon = dancesWon;
    }

    /**
     * Constructor for DancingMonster object.
     * @param name the name
     * @param spookiness the spookiness level
     * @param danceMove the dance move
     */

    public DancingMonster(String name, int spookiness, String danceMove) {
        super(name, spookiness);
        this.danceMove = danceMove;
        dancesWon = 0;
    }

    /**
     * Overrides Danceable's dance() method.
     * @return a random integer
     */

    @Override
    public int dance() {
        System.out.println(getName() + " does the " + getDanceMove());
        int rand = (int) (Math.random() * (getSpookiness() + 1));
        return rand;
    }

    /**
     * Overrides Danceable's wonDance() method.
     */

    @Override
    public void wonDance() {
        setDancesWon(getDancesWon() + 1);
    }

    /**
     * Overrides Object's toString() method.
     * @return a string describing DancingMonster
     */

    @Override
    public String toString() {
        return getName() + " has a spook rating of " + getSpookiness() + " and has won "
                + getDancesWon() + " dances thus far";
    }


}
