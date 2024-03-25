package Ch3;

import java.util.Scanner;

public class AddThreeNumbers {

    /***
     * @Exercise 3.2
     * @author yzl
     * @param args
     */
    public static void main(String[] args) {
        int number1 = (int) (System.currentTimeMillis() % 10);
        int number2 = (int) (System.currentTimeMillis() / 10 % 10);
        int number3 = (int) (System.currentTimeMillis() / 100 % 10);

        Scanner input = new Scanner(System.in);


        System.out.println("What is " + number1 + " + " + number2 + " + " + number3 + " ? ");
        int answer = input.nextInt();

        System.out.println(number1 + number2 + number3 == answer);

    }

}

