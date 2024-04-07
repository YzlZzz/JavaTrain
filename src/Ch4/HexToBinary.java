package Ch4;

import java.util.Scanner;

public class HexToBinary {
    /***
     * @exercise 4.12
     * @author yzl
     * @param args
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a hex digital: ");
        String hexString = input.nextLine();

        if(hexString.length() != 1){
            System.out.println("You must enter exactly one character! ");
        }
        char ch = Character.toUpperCase(hexString.charAt(0));

        if('A' <= ch && ch <= 'F'){
            int value = ch - 'A' + 10;
            System.out.println("The char binary value is " + Integer.toBinaryString(value));
        }
        else if(Character.isDigit(ch)){
            int temp = Integer.parseInt( hexString );
            System.out.printf( "The num binary value is " + DecToBinary(temp) );


        }
        else{
            System.out.println("Error: " + ch + " is an invalid input! ");
        }

    }

    public static int DecToBinary(int n){
        int t = 0;  //用来记录位数
        int bin = 0;    //用来记录最后的二进制数
        int r = 0;  //用来存储余数


        while(n != 0){
            r = n % 2;
            n = n / 2;
            bin += r * Math.pow(10, t );
            t++;
        }
        return bin;
    }
}
