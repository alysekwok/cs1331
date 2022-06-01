/**
 *
 * @author akwok6
 * @version 1.0
 */

public class Mechanic {
    private final String name;
    private double revenue = 0.00;
    private double oilChangePrice = 44.99;
    private double newTirePrice = 59.99;

    /**
     * Creates a Mechanic with the passed in values.
     *
     * @param name name of the mechanic
     * @param revenue the revenue of the mechanic
     * @param oilChangePrice the cost of an oil change
     * @param newTirePrice the cost of a new tire
     */
    public Mechanic(String name, double revenue, double oilChangePrice, double newTirePrice) {
        this.name = name;
        this.revenue = revenue;
        this.oilChangePrice = oilChangePrice;
        this.newTirePrice = newTirePrice;
        if (revenue < 0) {
            this.revenue = 0;
        }
        if (oilChangePrice < 0.99) {
            this.oilChangePrice = 44.99;
        }
        if (newTirePrice < 0.99) {
            this.newTirePrice = 59.99;
        }
    }

    /**
     * Creates a mechanic with a default revenue of $0.00.
     *
     * @param name name of the mechanic
     * @param oilChangePrice cost of an oil change
     * @param newTirePrice cost of a new tire
     */

    public Mechanic(String name, double oilChangePrice, double newTirePrice) {
        this(name, 0.00, oilChangePrice, newTirePrice);

    }

    /**
     * Creates a mechanic with default revenue $0.00, oil change price of $44.99 and a new tire
     * price of $59.99.
     *
     * @param name the name of the mechanic
     */

    public Mechanic(String name) {
        this(name, 0.00, 44.99, 59.99);

    }

    /**
     *
     * @return the revenue of the mechanic
     */

    public double getRevenue() {
        return revenue;
    }

    /**
     *
     * @param revenue the revenue of the mechanic
     */

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    /**
     *
     * @return the cost of an oil change
     */

    public double getOilChangePrice() {
        return oilChangePrice;
    }

    /**
     *
     * @param oilChangePrice the cost of an oil change
     */

    public void setOilChangePrice(double oilChangePrice) {
        this.oilChangePrice = oilChangePrice;
    }

    /**
     *
     * @return the price of a new tire
     */

    public double getNewTirePrice() {
        return newTirePrice;
    }

    /**
     *
     * @param newTirePrice the price of a new tire
     */

    public void setNewTirePrice(double newTirePrice) {
        this.newTirePrice = newTirePrice;
    }

    /**
     *
     * @return a string that describes the Mechanic
     */

    public String toString() {
        return "This is a mechanic named " + name + ". I charge $" + String.format("%.2f", oilChangePrice)
                + " for an oil change, and I charge $" + String.format("%.2f", newTirePrice)
                + " for a new tire. I've made $" + String.format("%.2f", revenue) + " in revenue.";
    }

    /**
     *
     * @param c a Car object
     */

    public void service(Car1 c) {
        double[] arr = c.getTireLife();
        if (c.getMileage() >= c.getNextOilChange()) {
            c.setNextOilChange(c.getMileage() + 3000);
            revenue = revenue + oilChangePrice;
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i] <= 0.5) {
                revenue = revenue + newTirePrice;
                arr[i] = 1.00;
            }
        }
        c.setTireLife(arr);


    }

}
