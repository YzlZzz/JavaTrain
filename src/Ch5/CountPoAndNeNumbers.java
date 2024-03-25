package Ch5;

import java.util.Scanner;

public class CountPoAndNeNumbers {

    /***
     * @Exercise 5.1
     * @author yzl
     * @param args
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer, and the input end if it is 0: ");

        double n;
        double sum = 0;
        int count = 0;
        int PoCount = 0;
        int NeCount = 0;

        do{
            n = input.nextDouble();
            sum +=n;
            if(n > 0){
                PoCount++;
            }
            if(n < 0){
                NeCount++;
            }
            count++;


        }while(n != 0);

        double average = sum / count;

        System.out.print("\nThe number of positives is " + PoCount);
        System.out.print("\nThe number of negatives is " + NeCount);
        System.out.print("\nThe total is " + sum);
        System.out.print("\nThe average is " + average);

    }
}
