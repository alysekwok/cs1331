import java.util.Scanner;
public class ElevatorPitch {
	public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter your full name: ");
        String name = myScanner.nextLine();
        System.out.println("Enter your gpa: ");
        double gpa = myScanner.nextDouble();
        System.out.println("Enter the year you will graduate: ");
        int graduationYear = myScanner.nextInt();
        myScanner.nextLine();
        System.out.println("Enter your favorite hobby: ");
        String hobby = myScanner.nextLine();
        System.out.println("Enter your major: ");
        String major = myScanner.nextLine();
        String myPitch = "Hello, my name is " + name + ". I'm a " + major + " major with a gpa of " + gpa + " graduating in " + graduationYear + ". In my free time, I like " + hobby + ".";
        System.out.println(myPitch);









    }
    
}
