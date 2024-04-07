package Ch8;

import java.util.Scanner;

public class SumColumn {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 3-by-4 matrix row by row: ");

        double[][] matrix = new double[3][4];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = input.nextDouble();
            }
        }

        System.out.println("Sum of the element at column 0 is " + sumColumn(matrix, 0));
        System.out.println("Sum of the element at column 1 is " + sumColumn(matrix, 1));
        System.out.println("Sum of the element at column 2 is " + sumColumn(matrix, 2));
        System.out.println("Sum of the element at column 3 is " + sumColumn(matrix, 3));

    }

    public static double sumColumn(double[][] m, int columnIndex){
        double sum = 0;
        for(int i = 0; i < m.length; i++){
            sum += m[i][columnIndex];
        }
        return sum;
    }
}
