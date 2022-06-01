/**
 * @author akwok6
 * @version 1.0
 */
public abstract class Car {
    private String name;
    private String make;
    private double fuelLevel;
    private int horsepower;
    private boolean previousUpgrade;
    protected static final double MAX_FUEL_LEVEL = 100;

    /**
     * Accessor  that returns name of Car.
     *
     * @return name of Car
     */
    public String getName() {
        return name;
    }

    /**
     * Mutator that changes name of Car.
     *
     * @param name name of Car
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor that returns the make of Car.
     *
     * @return make of car
     */

    public String getMake() {
        return make;
    }

    /**
     * Mutator that changes make of Car.
     *
     * @param make make of car
     */

    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Accessor that returns fuel level.
     *
     * @return fuel level
     */

    public double getFuelLevel() {
        return fuelLevel;
    }

    /**
     * Mutator that changes fuel level.
     *
     * @param fuelLevel fuel level of Car
     */

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    /**
     * Accessor that returns horsepower.
     *
     * @return horsepower of car
     */
    public int getHorsepower() {
        return horsepower;
    }

    /**
     * Mutator that changes horsepower.
     *
     * @param horsepower horsepower of Car.
     */

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    /**
     * Accessor taht returns if the car has been upgraded or not.
     *
     * @return status of upgrade
     */
    public boolean isPreviousUpgrade() {
        return previousUpgrade;
    }

    /**
     * Mutator that changes status of upgrade.
     *
     * @param previousUpgrade status of previous upgrade
     */

    public void setPreviousUpgrade(boolean previousUpgrade) {
        this.previousUpgrade = previousUpgrade;
    }

    /**
     * Accessor that returns the max fuel level.
     *
     * @return maximum fuel level
     */

    public double getMaxFuelLevel() {
        return MAX_FUEL_LEVEL;
    }

    /**
     * Constructor that takes in all instance variables.
     *
     * @param name name of car
     * @param make make of car
     * @param fuelLevel fuel level of car
     * @param horsepower horse power of car
     * @param previousUpgrade status of car upgrade
     */

    public Car(String name, String make, double fuelLevel, int horsepower, boolean previousUpgrade) {
        this.name = name;
        this.make = make;
        this.fuelLevel = fuelLevel;
        if (fuelLevel > MAX_FUEL_LEVEL) {
            this.fuelLevel = MAX_FUEL_LEVEL;
        }
        this.horsepower = horsepower;
        this.previousUpgrade = previousUpgrade;
    }

    /**
     * Overrides Object's toString() method.
     *
     * @return String value of Car
     */
    @Override
    public String toString() {
        return "Car named: " + name + ", Make: " + make + ", Fuel Amount: " + String.format("%.2f", fuelLevel)
                + ", HP: " + horsepower;
    }

    /**
     * Overrides Object's equals() method.
     *
     * @param other object passed in
     * @return whther or not two objects are equal
     */

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Car)) {
            return false;
        } else {
            Car c1 = (Car) other;
            return c1.name.equals(name) && c1.make.equals(make) && c1.horsepower == horsepower;

        }

    }

    /**
     * Upgrades horsepower and changes status of previous upgrade.
     */

    public void upgrade() {
        if (!previousUpgrade) {
            if (horsepower < 200) {
                horsepower = horsepower + 100;
            } else if (horsepower >= 200) {
                horsepower = horsepower + 50;
            }
            previousUpgrade = true;
        }

    }

    /**
     * Abstract method that allows two cars to race.
     *
     * @param c Car object
     */

    public abstract void race(Car c);

}
