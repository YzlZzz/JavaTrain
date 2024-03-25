package Ch3;

import java.util.Scanner;


public class CheckISBN10 {

    /***
     * @Exercise 3.9
     * @author yzl
     * @param args
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter first nine digits of am ISBN as integer: ");
        String ISBN9 = input.nextLine();

        if(ISBN9.length() != 9){
            System.out.println("Error: The integer digits is invalid! ");
            return;
        }

        int d_1 = Integer.parseInt(ISBN9.substring(0,1));
        int d_2 = Integer.parseInt(ISBN9.substring(1,2));
        int d_3 = Integer.parseInt(ISBN9.substring(2,3));
        int d_4 = Integer.parseInt(ISBN9.substring(3,4));
        int d_5 = Integer.parseInt(ISBN9.substring(4,5));
        int d_6 = Integer.parseInt(ISBN9.substring(5,6));
        int d_7 = Integer.parseInt(ISBN9.substring(6,7));
        int d_8 = Integer.parseInt(ISBN9.substring(7,8));
        int d_9 = Integer.parseInt(ISBN9.substring(8,9));

        int Temp = (d_1 * 1 + d_2 * 2 + d_3 * 3 + d_4 * 4 + d_5 * 5 + d_6 * 6 + d_7 * 7 + d_8 * 8 + d_9 * 9) % 11;

        String d_10;

        if(Temp == 10){
            d_10 = "X";
        }
        else{
            d_10 = Temp + "";
        }

        System.out.println("The ISBN-10 number is " + d_1 + d_2 + d_3 + d_4 + d_5 + d_6 + d_7 + d_8 + d_9 + d_10);

    }
}
