package Ch4;

import java.util.Scanner;

public class VowelOrConsonant {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter: ");

        String temp = input.nextLine();
        if (temp.length() != 1){
            System.out.println("You can only enter one character! ");
        }

        char ch = temp.charAt(0);

        if( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ){
            System.out.println(ch + " is a vowel! ");
        }
        else if(Character.isLetter( ch ) ){
            System.out.println(ch + " is a consonant! ");
        }
        else{
            System.out.println(ch + " is an invalid input! ");
        }
    }
}
