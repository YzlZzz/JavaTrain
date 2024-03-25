package Ch5;

import java.util.Scanner;

public class ComputeGCD {

    /***
     * @Exercise 5.14
     * @author yzl
     * @param args
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter two integer: ");
        int a = input.nextInt();
        int b = input.nextInt();

        int GCD = 1;

        for(int temp = ( Math.min(a,b) ); temp != 1; temp--){

            if(a % temp == 0 && b % temp == 0){
                GCD = temp;
                break;
            }
        }
        System.out.println("The greatest number of " + a + " and " + b + " is " + GCD);

    }
}
