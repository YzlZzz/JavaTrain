package Ch3;

import java.util.Scanner;


public class QuadraticEquation {

    /***
     * @Exercise 3.1
     * @author yzl
     * @param args
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a : ");
        double a = input.nextDouble();
        System.out.println("Enter b : ");
        double b = input.nextDouble();
        System.out.println("Enter c : ");
        double c = input.nextDouble();

        double r_1,r_2;
        if (a == 0 && b != 0){
            r_1 = -c/b;
            System.out.println("r = " + r_1);
        }
        else if ( (Math.pow(b, 2) - 4*a*c) > 0){
            r_1=(-b+Math.pow(Math.pow(b, 2)-4*a*c, 0.5))/2*a;
            r_2=(-b-Math.pow(Math.pow(b, 2)-4*a*c, 0.5))/2*a;
            System.out.println("r_1 = " + r_1);
            System.out.println("r_2 = " + r_2);
        }
        else if ( (Math.pow(b, 2) - 4*a*c) == 0){
            r_1=(-b+Math.pow(Math.pow(b, 2)-4*a*c, 0.5))/2*a;
            System.out.println("r_1 = r_2 = " + r_1);
        }
        else{
            System.out.println("The equation has no real roots! ");
        }

        //double r_1=(-b+Math.pow(Math.pow(b, 2)-4*a*c, 0.5))/2*a;
        //double r_2=(-b-Math.pow(Math.pow(b, 2)-4*a*c, 0.5))/2*a;


    }

}

