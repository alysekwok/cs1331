/**
 * @author akwok6
 * @version 1.0
 */

public class ShelbyMustang extends Car {
    private int racesWon;

    /**
     * Accessor that returns amount of races won.
     *
     * @return races won
     */
    public int getRacesWon() {
        return racesWon;
    }

    /**
     * Mutator that changes races won.
     *
     * @param racesWon amount of races won
     */

    public void setRacesWon(int racesWon) {
        this.racesWon = racesWon;
    }

    /**
     * Constructor that takes in variables from the instance class as well as races won.
     *
     * @param name name of car
     * @param make make of car
     * @param fuelLevel fuel level of car
     * @param horsepower horsepower of car
     * @param previousUpgrade status of car upgrade
     * @param racesWon number of races won
     */

    public ShelbyMustang(String name, String make, double fuelLevel, int horsepower,
                         boolean previousUpgrade, int racesWon) {
        super(name, make, fuelLevel, horsepower, previousUpgrade);
        this.racesWon = racesWon;
    }

    /**
     * Constuctor that takes in no arguments.
     */
    public ShelbyMustang() {
        super("Carroll", "Shelby Automotives", 100, 350, false);
    }

    /**
     * Overrides Object's toString() method.
     *
     * @return String describing the object
     */
    @Override
    public String toString() {
        String newStr = super.toString() + ", Races Won:" + racesWon;
        return newStr;
    }

    /**
     * Overrides Object's equals() method.
     *
     * @param other object passed in
     * @return if the two objects are equal
     */

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ShelbyMustang)) {
            return false;
        } else {
            ShelbyMustang sm1 = (ShelbyMustang) other;
            return super.equals(sm1) && sm1.getRacesWon() == getRacesWon();
        }
    }

    /**
     * Overrides Car's abstract race() method.
     *
     * @param c Car object
     */
    @Override
    public void race(Car c) {
        if ((c instanceof ShelbyMustang) && c.getFuelLevel() > 50 && getFuelLevel() > 50) {
            ShelbyMustang smc = (ShelbyMustang) c;
            smc.setFuelLevel(smc.getFuelLevel() - 25);
            setFuelLevel(getFuelLevel() - 25);
            if (smc.getHorsepower() < getHorsepower()) {
                setRacesWon(getRacesWon() + 1);
                System.out.println(getName() + " won against " + smc.getName());
            } else if (smc.getHorsepower() > getHorsepower()) {
                smc.setRacesWon(smc.getRacesWon() + 1);
                System.out.println(smc.getName() + " won against " + getName());
            } else if (smc.getHorsepower() == getHorsepower()) {
                if (smc.getRacesWon() > getRacesWon()) {
                    smc.setRacesWon(smc.getRacesWon() + 1);
                    System.out.println(smc.getName() + " won against " + getName());
                } else if (smc.getRacesWon() < getRacesWon()) {
                    setRacesWon(getRacesWon() + 1);
                    System.out.println(getName() + " won against " + smc.getName());
                } else if (smc.getRacesWon() == getRacesWon()) {
                    System.out.println(smc.getName() + " tied with " + getName());
                }
            }
        } else {
            System.out.println(c.getName() + " could not race " + getName());
        }
    }

}
