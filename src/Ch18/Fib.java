package Ch18;

import java.util.Scanner;

public class Fib {
    public static void main(String[] args) {
        System.out.print("Enter the number of fib: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        System.out.println(fib(n));
    }
    public static int fib(int n){
        int f0 = 0;
        int f1 = 1;

        int currentFib = 0;
        for(int i = 0; i < n; i++){
            currentFib = f0 + f1;
            f0 = f1;
            f1 = currentFib;
        }
        return currentFib;
    }
}
