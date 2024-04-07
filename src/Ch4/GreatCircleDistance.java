package Ch4;

import java.util.Scanner;

public class GreatCircleDistance {
    /***
     * @Exercise 4.2
     * @author yzl
     * @param args
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter point 1 (latitude and longitude) in degree: ");

        double x_1 = input.nextDouble();
        double y_1 = input.nextDouble();

        System.out.printf("Enter point 2 (latitude and longitude) in degree: ");
        double x_2 = input.nextDouble();
        double y_2 = input.nextDouble();

        final double r = 6371.01;

        double d = r * Math.acos( Math.sin( Math.toRadians(x_1) ) * Math.sin( Math.toRadians(x_2) ) + Math.cos( Math.toRadians(x_1) ) * Math.cos( Math.toRadians(x_2) ) * Math.cos( Math.toRadians(y_1 - y_2) ) );

        System.out.print("The distance between the two points is " + d + " km");
    }
}
