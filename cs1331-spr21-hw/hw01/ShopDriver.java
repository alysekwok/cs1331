/**
 *
 * @author akwok6
 * @version 1.0
 */
public class ShopDriver {
    /**
     * Main method.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        Car1 c1 = new Car1("SUV", 15000, 14600, new double[]{0.70, 0.32, 0.45, 0.59});
        Mechanic m1 = new Mechanic("Raul");
        System.out.println(c1.getTireLife());
        System.out.println(m1);
        System.out.println(c1);




    }
}
