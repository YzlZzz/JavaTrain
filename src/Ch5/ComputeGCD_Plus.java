package Ch5;

import java.util.*;

public class ComputeGCD_Plus {
    static int GCD(int a, int b){
        if(a < 0 || b < 0){
            a = Math.abs(a);
            b = Math.abs(b);
        }

        if(b != 0){
            return GCD(b, a %b);
        }
        else{
            return a;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a and b :");
        int a = input.nextInt();
        int b = input.nextInt();

        System.out.print("The greatest common divisor is " + GCD(a,b));
    }
}
