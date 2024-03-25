package Ch6;

import java.util.*;

public class PentagonalNumbers {

    public static void main(String[] args){

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++) {
                int temp = getPentagonalNumber(i * 10 + j + 1);
                System.out.printf("%7d", temp);
            }
            System.out.println();
        }
    }

    public static int getPentagonalNumber(int n){
        int result = n * ( 3 * n - 1 ) / 2;

        return result;

    }
}
