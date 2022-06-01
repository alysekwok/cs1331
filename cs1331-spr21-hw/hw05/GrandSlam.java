import java.util.ArrayList;

/**
 * @author akwok6
 * @version 1.0
 */

public class GrandSlam {
    private String name;
    private ArrayList<ProfessionalPlayer> leaderboard;

    /**
     * Accessor for the name.
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
     * Accessor for the leaderboard.
     * @return the leaderboard
     */

    public ArrayList<ProfessionalPlayer> getLeaderboard() {
        return leaderboard;
    }

    /**
     * Mutator for the leaderboard.
     * @param leaderboard the new leaderboard
     */

    public void setLeaderboard(ArrayList<ProfessionalPlayer> leaderboard) {
        this.leaderboard = leaderboard;
    }

    /**
     * Constructor that takes in a name and leaderboard.
     * @param name the name
     * @param leaderboard the leaderboard
     */

    public GrandSlam(String name, ArrayList<ProfessionalPlayer> leaderboard) {
        this.name = name;
        this.leaderboard = leaderboard;
        createLeaderboard();

    }

    /**
     * Creates and sorts the leaderboard with a selection sort algorithm.
     */

    public void createLeaderboard() {
        int n = leaderboard.size();
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (leaderboard.get(j).compareTo(leaderboard.get(min)) == 1) {
                    min = j;
                }
            }
            ProfessionalPlayer temp = leaderboard.get(min);
            leaderboard.set(min, leaderboard.get(i));
            leaderboard.set(i, temp);
        }
    }

    /**
     * Searches for an object in leaderboard equal to the passed in ProfessionalPlayer object.
     * @param pro ProfessionalPlayer object being compared to
     * @return whether or not the two objects are equal.
     */

    public int findPlayer(ProfessionalPlayer pro) {
        int low = 0;
        int high = leaderboard.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (leaderboard.get(mid).compareTo(pro) == 1) {
                low = mid + 1;
            } else if (leaderboard.get(mid).compareTo(pro) == -1) {
                high = mid - 1;
            } else if (leaderboard.get(mid).equals(pro)) {
                return mid;
            }
        }
        return -1;

    }

    /**
     * Overrides Object's toString() method.
     * @return a string describing the GrandSlam
     */
    @Override
    public String toString() {
        return "Welcome to the " + name + " tournament! The current leaderboard is: " + leaderboard.toString();
    }
}
