package Ch12;

import java.util.Scanner;

public class InputMismatchException {

    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two integer: ");
        try {
            int sum = input.nextInt() + input.nextInt();
            System.out.println("sum is " + sum);
        }
        catch (java.util.InputMismatchException ex){
            System.out.println("Wrong input, please Enter again. ");
        }

    }
}
