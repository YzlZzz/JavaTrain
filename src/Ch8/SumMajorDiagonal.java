package Ch8;

import java.util.Scanner;


public class SumMajorDiagonal {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a 4-by-4 matrix row by row: ");

        double[][] matrix = new double[4][4];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = input.nextDouble();
            }
        }

        System.out.println("Sum of the elements in the major diagonal is " + sumMajorDiagonal(matrix));
    }

    public static double sumMajorDiagonal(double[][] m){
        double sum = 0;

        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                if(i == j || (i + j == m.length)){
                    sum += m[i][j];
                }
            }
        }

        return sum;
    }
}
