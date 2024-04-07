package Ch6;

import java.util.*;

public class SumDigits {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a digit: ");
        long n = input.nextLong();

        System.out.print("The sum integer of digit is " + sumDigits(n));
    }

    public static int sumDigits(long n){
        int sum = 0;
        int temp = ( n + "" ).length();

        for(int i = 0; i < temp; i++){
            sum = (int) (sum + ( n % 10));
            n /= 10;
        }
        return sum;
    }
}
