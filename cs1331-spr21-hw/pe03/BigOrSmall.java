public class BigOrSmall {
    public static void main(String[] args){
        int smallRandNum = (int) ((Math.random()*4 ) + 2);
        System.out.println("We will run " + smallRandNum + " times!");
        for (int i = smallRandNum; i > 0; i-- ){
            int newNum = (int) (Math.random()*19) +2;
            System.out.println("The value is: " + newNum);
            if (newNum > 10){
                System.out.println("Yay!");
            }
            else{
                System.out.println("Nay!");
            }

        }

    }
    
}
