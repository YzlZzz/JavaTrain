package Ch4;

import java.util.Scanner;

public class AreaOfPentagon {
    /***
     * @Exercise 4.1
     * @author yzl
     * @param args
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length from to a vertex: ");

        double r = input.nextDouble();
        double s = 2 * r * Math.sin(Math.PI / 5);
        double area = ( 5 * Math.pow(s,2)) / (4 * Math.tan(Math.PI / 5));

        System.out.printf("The area of the pentagon is %.2f" , area);
    }
}
