package Ch7;

import java.util.Scanner;

public class CountOccurrence {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the integers between 1 and 100: ");

        int[] number = new int[100];
        number[0] = 1;

        for(int i =0; i < number.length; i++){
            number[i] = input.nextInt();
            if(number[i] == 0){
                break;
            }
        }

        count(number);
        System.out.println("--end--");
    }

    public static void count(int[] number) {

        int[] count = new int[100];


        for(int i = 0; i < count.length; i++){
            if(number[i] > 0) {
                count[number[i] - 1] = count[number[i] - 1] + 1;
            }
        }

        for(int i = 0; i < count.length; i++){
            if(count[i] == 1){
                System.out.println((i+1) + " occurs " + count[i] + " time");
            }
            else if(count[i] > 1){
                System.out.println((i+1) + " occurs " + count[i] + " times");
            }
        }

    }
}
