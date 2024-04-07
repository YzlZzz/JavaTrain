package Ch7;

import java.util.*;

public class AssignGrades {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of student: ");

        int studentNum = input.nextInt();//number of student

        System.out.print("Enter " + studentNum + " scores: ");
        double[] grade = new double[studentNum];

        for(int i =0; i < studentNum; i++){
            grade[i] = input.nextDouble();
        }

        classifyGrade(getMax(grade),grade);

    }

    public static double getMax(double[] grade){
        double max = grade[0];
        for (double v : grade) {
            if (v > max) {
                max = v;
            }
        }

        return max;
    }

    public static void classifyGrade(double max, double[] grade){
        for(int i = 0; i < grade.length; i++){
            if(grade[i] >= max - 10){
                System.out.println("Student " + i + " score is " + grade[i] + " and grade is A");
            }
            else if(grade[i] >= max - 20){
                System.out.println("Student " + i + " score is " + grade[i] + " and grade is B");
            }
            else if (grade[i] >= max -30) {
                System.out.println("Student " + i + " score is " + grade[i] + " and grade is C");
            }
            else if (grade[i] >= max -40) {
                System.out.println("Student " + i + " score is " + grade[i] + " and grade is D");
            }
            else{
                System.out.println("Student " + i + " score is " + grade[i] + " and grade is F");
            }
        }
    }
}
