package Ch7;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 10 numbers: ");

        int[] a = new int[10];
        int[] b = new int[10];

        for(int i =0; i<a.length; i++){
            a[i] = input.nextInt();
        }
        reverse(a,b);
        for (int j : b) {
            System.out.print(j + " ");
        }
    }

    public static void reverse(int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            b[i] = a[a.length - 1 - i];
        }
    }

}
