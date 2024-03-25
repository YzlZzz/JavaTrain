package Ch3;

import java.util.Scanner;

public class palindromeNumber {

    /***
     * @Exercise 3.12
     * @author yzl
     * @param args
     */
    public static void main(String[] args){
        System.out.println("Please enter a three-digit integer: ");

        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        if( a >= 1000 || a < 100 ){
            System.out.println("Error: out of range! ");
            return;
        }

        int b = a / 100;
        int c = a % 10;

        if(b == c){
            System.out.println(a + " is a palindrome");
        }
        else{
            System.out.println(a + " is not a palindrome");
        }
    }
}
