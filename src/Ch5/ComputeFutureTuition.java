package Ch5;

import java.util.Scanner;

public class ComputeFutureTuition {

    /***
     * @Exercise 5.7
     * @author yzl
     * @param args
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int tuition = 10000;
        int sum = 0;
        final int years = 10;

        for(int i = 0; i < years; i++){
            tuition = (int) (tuition * 1.05);
        }
        System.out.println("The tuition of 10th year is " + tuition);

        for(int i = 0; i<4; i++){
            tuition = (int) (tuition * 1.05);
            sum += tuition;
        }
        System.out.println("4 years need " + sum + "$ tuition after 10th year");
    }
}
