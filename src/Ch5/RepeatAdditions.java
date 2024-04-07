package Ch5;

import java.util.Scanner;

public class RepeatAdditions {

    /***
     * @Exercise 5.2
     * @author yzl
     * @param args
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("GAME START");
        System.out.println("You need answer 5 questions!");

        final int NumberOfQuestions = 5;
        int correctNumber = 0;

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < NumberOfQuestions; i++){
            int number1 = (int)(1 + Math.random() * 15);
            int number2 = (int)(1 + Math.random() * 15);

            System.out.print( number1 + " + " + number2 +" = ");
            int answer = input.nextInt();

            if( number1 + number2 == answer){
                correctNumber++;
            }
        }

        long endTime = System.currentTimeMillis();
        long testTime = ( endTime - startTime )/1000;
        System.out.println("CORRECT NUMBER : " + correctNumber);
        System.out.println("TOTAL TIME : " + testTime +"s");

    }
}
