package Ch3;

import java.util.Scanner;

public class CheckID {
    /***+
     * @Exercise 3.9plus
     * @author yzl
     * @param args
     */
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter first 17 digits of an ID as integer : ");
        String ID =input.nextLine();

        if(ID.length() != 17){
            System.out.println("Error: The integer digits is invalid! ");
            return;
        }

        int a_1 = Integer.parseInt(ID.substring(0,1));
        int a_2 = Integer.parseInt(ID.substring(1,2));
        int a_3 = Integer.parseInt(ID.substring(2,3));
        int a_4 = Integer.parseInt(ID.substring(3,4));
        int a_5 = Integer.parseInt(ID.substring(4,5));
        int a_6 = Integer.parseInt(ID.substring(5,6));
        int a_7 = Integer.parseInt(ID.substring(6,7));
        int a_8 = Integer.parseInt(ID.substring(7,8));
        int a_9 = Integer.parseInt(ID.substring(8,9));
        int a_10 = Integer.parseInt(ID.substring(9,10));
        int a_11 = Integer.parseInt(ID.substring(10,11));
        int a_12 = Integer.parseInt(ID.substring(11,12));
        int a_13 = Integer.parseInt(ID.substring(12,13));
        int a_14 = Integer.parseInt(ID.substring(13,14));
        int a_15 = Integer.parseInt(ID.substring(14,15));
        int a_16 = Integer.parseInt(ID.substring(15,16));
        int a_17 = Integer.parseInt(ID.substring(16,17));

        int Temp = ( a_1*7+a_2*9+a_3*10+a_4*5+a_5*8+a_6*4+a_7*2+a_8*1+a_9*6+a_10*3+a_11*7+a_12*9+a_13*10+a_14*5+a_15*8+a_16*4+a_17*2) % 11;
        String a_18 = null;

        switch (Temp){
            case 0:
                a_18 = "1";
                break;
            case 1:
                a_18 = "0";
                break;
            case 2:
                a_18 = "X";
                break;
            case 3:
                a_18 = "9";
                break;
            case 4:
                a_18 = "8";
                break;
            case 5:
                a_18 = "7";
                break;
            case 6:
                a_18 = "6";
                break;
            case 7:
                a_18 = "5";
                break;
            case 8:
                a_18 = "4";
                break;
            case 9:
                a_18 = "3";
                break;
            case 10:
                a_18 = "2";
                break;
        }

        System.out.println("The ID is " + ID + a_18);
    }
}
