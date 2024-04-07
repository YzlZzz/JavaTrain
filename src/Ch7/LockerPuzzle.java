package Ch7;

import java.util.Scanner;

public class LockerPuzzle {
    Scanner input = new Scanner(System.in);
    public static void main(String[] args){

        int[] student = new int[100];
        for(int i = 0; i<student.length; i++){
            student[i] = i+1;
        }

        boolean[] locker = new boolean[100];

        studentChange(student, locker);
        printLocker(locker);

    }

    public static void changeStatus(int i, boolean[] locker){

        locker[i] = !locker[i];

    }

    public static void studentChange(int[] student, boolean[] locker){
        for(int i =0; i < student.length; i++){
            for(int j =i; j < student.length; j += (i+1)){
                changeStatus(j, locker);
            }
        }
    }

    public static void printLocker(boolean[] locker){
        for(int i = 0; i < locker.length; i++){
            if(locker[i]){
                System.out.print((i + 1) + " ");
            }
        }
    }
}
