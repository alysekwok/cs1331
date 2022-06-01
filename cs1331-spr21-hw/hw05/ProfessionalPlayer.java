/**
 * @author akwok6
 * @version 1.0
 */

public class ProfessionalPlayer extends Player {
    private boolean isSeeded;

    /**
     * Accessor for isSeeded.
     * @return whether the player is seeded or not
     */

    public boolean isSeeded() {
        return isSeeded;
    }

    /**
     * Mutator for isSeeded.
     * @param seeded new seeded status of player
     */

    public void setSeeded(boolean seeded) {
        isSeeded = seeded;
    }

    /**
     * Constructor that takes in name, points, trophies, and isSeeded.
     * @param name name
     * @param points points
     * @param trophies trophies
     * @param isSeeded seeded status
     */

    public ProfessionalPlayer(String name, double points, int trophies, boolean isSeeded) {
        super(name, points, trophies);
        this.isSeeded = isSeeded;
    }

    /**
     * Calculates the skill level of the ProfessionalPlayer.
     * @return skill level of the player
     */

    public double calculateSkillLevel() {
        double skillLevel;
        skillLevel = getPoints() + 1.5 * getTrophies();
        if (isSeeded()) {
            skillLevel = skillLevel * 2;
        }
        return skillLevel;
    }

    /**
     * Overrides Object's equals() method; compares 2 ProfessionalPlayers.
     * @param o object being compared
     * @return whether the objects are equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProfessionalPlayer)) {
            return false;
        } else {
            ProfessionalPlayer pro = (ProfessionalPlayer) o;
            return super.equals(pro) && pro.isSeeded() == isSeeded;
        }
    }

}
