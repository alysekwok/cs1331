
public class FloorOrMax{
    public static void main(String[] args){
        double myRand =  ((Math.random() * 50) + 4.0);
        System.out.printf("The value is: %.2f%n", myRand);
        if (Math.floor(myRand) % 2 == 0 && Math.floor(myRand) > 15){
            int newNum = (int) Math.floor(myRand);
            System.out.println(newNum);
       }
        else if ((int) Math.floor(myRand) % 2 == 1) {
            System.out.println(Math.max(myRand, 32));
        }
        
        else{
            System.out.println(myRand);
        }

    }

}