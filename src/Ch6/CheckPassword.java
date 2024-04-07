package Ch6;

import java.util.*;

public class CheckPassword {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String p = input.nextLine();

        if(isValid(p)){
            System.out.println("Valid Password");
        }
        else{
            System.out.println("Invalid Password");
        }
    }

    //判断密码长度是否有效
    public static boolean isLengthValid(String p){
        return p.length() >= 8;
    }

    //判断是否仅包含字母和数字
    public static boolean isLetterNumber(String p){

        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < p.length(); i++){


            boolean temp1 = Character.isDigit(p.charAt(i));
            boolean temp2 = Character.isLetter(p.charAt(i));

            if(temp1){
                count1++;
            }
            else if(temp2){
                count2++;
            }
            else{
                return false;
            }

        }
        if(count1 > 0 && count2 > 0) {
            return true;
        }
        else{
            return false;
        }
    }

    //判断数字个数是否大于2
    public static boolean isNumberCount(String p){
        int count =0;

        for(int i = 0; i < p.length(); i++){
            boolean temp = Character.isDigit(p.charAt(i));

            if(temp){
                count++;
            }
        }
        return count >= 2;
    }

    public static boolean isValid(String p){
        if(isLengthValid(p) && isLetterNumber(p) && isNumberCount(p)){
            return true;
        }
        else{
            return false;
        }
    }
}
