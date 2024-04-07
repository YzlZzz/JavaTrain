package Ch6;

import java.util.*;

public class PalindromeInteger {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int a =input.nextInt();

        System.out.print("Whether " + a + " is a palindrome: " + isPalindrome(a));

    }

    public static int reverse(int number){

        int palindrome = 0;
        int temp = (number + "").length();
        for(int i = 0; i < temp; i++){
            palindrome = palindrome * 10 + (number % 10);
            number /= 10;
        }
        return palindrome;
    }

    public static boolean isPalindrome(int number){
        if( number == reverse(number)){
            return true;
        }
        else{
            return false;
        }
    }
}
