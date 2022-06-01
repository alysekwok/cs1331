import java.util.Scanner;

public class CoffeeShop {
    public static Order[] createOrderArray(String orders) {
        Order[] orderArr = new Order[orders.length()];

        for (int i = 0; orders.length() > i; i++) {
            if (orders.charAt(i) == 'L') {
                orderArr[i] = Order.LATTE;
            }
            if (orders.charAt(i) == 'C') {
                orderArr[i] = Order.COFFEE;
            }
            if (orders.charAt(i) == 'I') {
                orderArr[i] = Order.ICED_COFFEE;
            }
            if (orders.charAt(i) == 'F') {
                orderArr[i] = Order.FRAPPE;
            }
            if (orders.charAt(i) == 'P') {
                orderArr[i] = Order.PASTRY;
            }
        }
        return orderArr;
    }
    public static double lookupMakeTime(Order drink) {
        switch (drink) {
        case LATTE:
            return 3.0;
        case COFFEE:
            return 0.5;
        case ICED_COFFEE:
            return 2.0;
        case FRAPPE:
            return 6.0;
        case PASTRY:
            return 3.0;
        default:
            return 0.0;
        }
    }
    public static void computeOrderMakeTime(Order[] orderList, int numBaristas) {
        double totalMakeTime, time;
        int numOrders = orderList.length;
        totalMakeTime = 0;
        for (int x = 0; orderList.length > x; x++) {
            totalMakeTime += lookupMakeTime(orderList[x]);
        }
        time = (totalMakeTime / numBaristas) + (numOrders % numBaristas);
        System.out.println("It will take " + time +  " minutes for " + numBaristas + " baristas to make these orders.");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to your local coffee shop! What does the rush look like today?");
        Scanner scan = new Scanner(System.in);
        String newOrder = scan.nextLine();
        computeOrderMakeTime(createOrderArray(newOrder), 1);
        computeOrderMakeTime(createOrderArray(newOrder), 2);
        computeOrderMakeTime(createOrderArray(newOrder), 3);

    }

}

