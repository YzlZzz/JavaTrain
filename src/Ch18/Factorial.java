package Ch18;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        System.out.print("Enter a number to get its factorial: ");
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        System.out.println(factorial(new BigInteger(n)));
    }

    public static BigInteger factorial(BigInteger n){
        BigInteger result = new BigInteger("1");
        return factorial(n, result);
    }

    private static BigInteger factorial(BigInteger n, BigInteger result){
        if(n.intValue() == 0){
            return result;
        }
        else return factorial(n.subtract(new BigInteger("1")), result.multiply(n));
    }
}
