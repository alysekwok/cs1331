/**
 * @author akwok6
 * @version 1.0
 */
public class FordGT extends Car {
    private double weight;
    private String driverName;

    /**
     * Accessor that returns weight of car.
     *
     * @return weight of car
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Mutator that changes weight of car.
     *
     * @param weight weight of car
     */

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Accessor that returns name of driver.
     *
     * @return name of driver
     */

    public String getDriverName() {
        return driverName;
    }

    /**
     * Mutator that changes name of driver.
     *
     * @param driverName name of driver
     */

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * Constructor that takes in parent Class Car's values and weight and driver name.
     * @param name name of car
     * @param make make of car
     * @param fuelLevel fuel level of car
     * @param horsepower horse power of car
     * @param previousUpgrade status of upgrade
     * @param weight weight of car
     * @param driverName name of car driver
     */
    public FordGT(String name, String make, double fuelLevel, int horsepower, boolean previousUpgrade,
                  double weight, String driverName) {
        super(name, make, fuelLevel, horsepower, previousUpgrade);
        this.weight = weight;
        this.driverName = driverName;
    }

    /**
     * Constructor that takes no arguments.
     */
    public FordGT() {
        this("Pony", "Ford", 100, 450, false, 3300, "Ken Miles");
    }

    /**
     * Overrides Object's toString() method.
     *
     * @return String that describing object
     */
    @Override
    public String toString() {
        return super.toString() + ", Weight: " + weight + ", Driver: " + driverName;
    }

    /**
     * Overrides Object's equals() method.
     *
     * @param other object passed in
     * @return if the two values are true
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof FordGT)) {
            return false;
        } else {
            FordGT fg1 = (FordGT) other;
            return super.equals(fg1) && fg1.getWeight() == getWeight();
        }
    }

    /**
     * Overrides Car's upgrade method.
     */
    @Override
    public void upgrade() {
        if (getHorsepower() < 200) {
            setHorsepower(getHorsepower() + 100);
        } else if (getHorsepower() >= 200) {
            setHorsepower(getHorsepower() + 50);
        }
        setPreviousUpgrade(true);
        setFuelLevel(getFuelLevel() + 50);
        if (getFuelLevel() > getMaxFuelLevel()) {
            setFuelLevel(getMaxFuelLevel());
        }
    }

    /**
     * Overrides Car's abstract race() method.
     * @param c Car object
     */
    @Override
    public void race(Car c) {
        if ((c instanceof FordGT) && c.getFuelLevel() > 50 && getFuelLevel() > 50) {
            FordGT fgc = (FordGT) c;
            fgc.setFuelLevel(fgc.getFuelLevel() - 25);
            setFuelLevel(getFuelLevel() - 25);
            if (fgc.getHorsepower() < getHorsepower()) {
                System.out.println(getName() + " with " + getDriverName() + " as the driver won against "
                        + fgc.getName() + " with " + fgc.getDriverName() + " as the driver");
            } else if (fgc.getHorsepower() > getHorsepower()) {
                System.out.println(fgc.getName() + " with " + fgc.getDriverName() + " as the driver won against "
                        + getName() + " with " + getDriverName() + " as the driver");
            } else if (fgc.getHorsepower() == getHorsepower()) {
                if (fgc.getWeight() < getWeight()) {
                    System.out.println(getName() + " with " + getDriverName() + " as the driver won against "
                            + fgc.getName() + " with " + fgc.getDriverName() + " as the driver");
                } else if (fgc.getWeight() > getWeight()) {
                    System.out.println(fgc.getName() + " with " + fgc.getDriverName() + " as the driver won against "
                            + getName() + " with " + getDriverName() + " as the driver");
                } else {
                    System.out.println(fgc.getName() + " tied with " + getName());
                }
            }
        } else if (!(c instanceof FordGT) || c.getFuelLevel() <= 50 || getFuelLevel() <= 50) {
            System.out.println(c.getName() + " could not race " + getName());
        }
    }
}
