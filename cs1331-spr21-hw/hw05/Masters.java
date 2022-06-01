import java.util.ArrayList;

/**
 * @author akwok6
 * @version 1.0
 */

public class Masters {
    private String name;
    private ArrayList<Player> leaderboard;

    /**
     * Accessor for name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Mutator for name.
     * @param name the new name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor for the leaderboard.
     * @return the leaderboard
     */

    public ArrayList<Player> getLeaderboard() {
        return leaderboard;
    }

    /**
     * Mutator for the leaderboard.
     * @param leaderboard the new leaderboard
     */

    public void setLeaderboard(ArrayList<Player> leaderboard) {
        this.leaderboard = leaderboard;
    }

    /**
     * Constructor that takes in name and leaderboard.
     * @param name name
     * @param leaderboard leaderboard
     */

    public Masters(String name, ArrayList<Player> leaderboard) {
        this.name = name;
        this.leaderboard = leaderboard;
    }


    /**
     * Creates and sorts the leaderboard with a insertion sort algorithm.
     */

    public void createLeaderboard() {
        int n = leaderboard.size();
        for (int i = 0; i < n; i++) {
            Player temp = leaderboard.get(i);
            int j = i - 1;
            while (j >= 0 && leaderboard.get(j).compareTo(temp) == -1) {
                leaderboard.set(j + 1, leaderboard.get(j));
                j--;
            }
            leaderboard.set(j + 1, temp);
        }
    }

    /**
     * Finds a an object equal to the passed in Player object.
     * @param player Player object
     * @return index of object equal to player
     */

    public int findPlayer(Player player) {
        int n = leaderboard.size();
        for (int i = 0; i < n; i++) {
            if (leaderboard.get(i) instanceof Player) {
                if (leaderboard.get(i).equals(player)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Overrides Object's toString() method.
     * @return a string describing the Masters object
     */
    @Override
    public String toString() {
        return "Welcome to the " + name + " tournament! The current leaderboard is: "
                + leaderboard.toString();
    }

}
