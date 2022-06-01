/**
 *
 * @author akwok6
 * @version 1.0
 */
public class Car {
    private String type;
    private int mileage = 0;
    private int nextOilChange;
    private double[] tireLife = new double[4];
    private static int numCars = 0;

    /**
     * Creates a Car with passed in values.
     *
     * @param type the type of car
     * @param mileage the mileage of the car
     * @param nextOilChange the miles until next oil change
     * @param tireLife an array that displays tire quality
     */

    public Car(String type, int mileage, int nextOilChange, double[] tireLife) {
        this.type = type;
        if (mileage < 0) {
            this.mileage = 0;
        } else {
            this.mileage = mileage;
        }
        this.nextOilChange = nextOilChange;
        if (nextOilChange < 0) {
            this.nextOilChange = this.mileage + 3000;
        }
        for (int i = 0; i < 4; i++) {
            if (tireLife[i] < 0) {
                tireLife[i] = 1.0;
            }
            if (tireLife[i] > 1.0)  {
                tireLife[i] = 1.0;
            }
        }
        this.tireLife = tireLife;
        numCars++;

    }

    /**
     * Creates a car with passed in values.
     *
     * @param type the type of car
     * @param mileage the mileage of the car
     * @param tireLife an array that displays tire quality
     */

    public Car(String type, int mileage, double[] tireLife) {
        this(type, mileage, 3000 + mileage, tireLife);
    }

    /**
     * Creates a car with the passed in values.
     *
     * @param type the type of car
     * @param tireLife an array that displays tire quality
     */

    public Car(String type, double[] tireLife) {
        this(type, 0,  3000, tireLife);
    }

    /**
     * Creates a deep copy.
     *
     * @param copy Car object to be copied
     */

    public Car(Car copy) {
        this.type = copy.type;
        this.mileage = copy.mileage;
        this.nextOilChange = copy.nextOilChange;
        this.tireLife = copy.tireLife.clone();
        numCars++;

    }

    /**
     *
     * @return this car's type
     */

    public String getType() {
        return type;
    }

    /**
     *
     * @param type type of the car
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return this car's mileage
     */

    public int getMileage() {
        return mileage;
    }

    /**
     *
     * @param mileage mileage of the car
     */

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    /**
     *
     * @return this car's next oil change
     */

    public int getNextOilChange() {
        return nextOilChange;
    }

    /**
     *
     * @param nextOilChange the amount of miles until the next oil change
     */

    public void setNextOilChange(int nextOilChange) {
        this.nextOilChange = nextOilChange;
    }

    /**
     *
     * @return an array that displays tire quality
     */

    public double[] getTireLife() {
        return tireLife;
    }

    /**
     *
     * @param tireLife an array of the tire pressure of each tire
     */

    public void setTireLife(double[] tireLife) {
        this.tireLife = tireLife;
    }

    /**
     *
     * @return the number of cars
     */

    public int getNumCars() {
        return numCars;
    }

    /**
     *
     * @param numCars the number of cars
     */

    public void setNumCars(int numCars) {
        this.numCars = numCars;
    }

    /**
     *
     * @return the average value of tire pressures in tireLife
     */

    private int averageTireLife() {
        double sum = 0;
        for (int i = 0; i < 4; i++) {
            sum = tireLife[i] + sum;
        }
        int average = (int) ((sum / 4) * 100);
        return average;
    }

    /**
     *
     * @return a String describing the Car object
     */
    public String toString() {
        int avg = averageTireLife();
        String pleaseWork = "This is a car of type " + type + " with a mileage of " + mileage
                + " miles. I'm due for a checkup in " + (nextOilChange - mileage) + " miles,"
                + " and my average tire life is " + avg + "%.";
        return pleaseWork;
    }

}