package Ch12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayIndexOutBoundsException {
    public static void main(String[] args) {
        int[] randomArray = new int[100];
        for(int i = 0; i < randomArray.length; i++){
            randomArray[i] = (int) (Math.random() * 100);
        }
        try{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the index of array: ");
            int index = input.nextInt();
            System.out.println("The array[" + index + "] is " + randomArray[index]);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("The index of array is out of bounds");
        }
        catch (InputMismatchException ex){
            System.out.println("Wrong type input");
        }
    }
}
