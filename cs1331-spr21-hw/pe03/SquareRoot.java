import java.util.Random;
public class SquareRoot {
    public static void main(String[] args) {
        Random rand = new Random();
        long randLong = rand.nextInt(301) + 1000000000000000L;
        System.out.printf("The value is: %d\n", randLong);
        int count = 0;
        while (randLong != 1) {
            randLong = (long) Math.sqrt(randLong);
            System.out.println(randLong);
            count++;
        }
        System.out.println("Count: " + count);
    }
}