package Ch10;

import java.lang.Integer;

public class MyString {
    public static void main(String[] args){
        char[] chars = {'1', '2', '3'};
        char[] chars1 = {'a', 'B', 'c'};
        MyString a = new MyString(chars);
        MyString b = new MyString(chars1);

        System.out.println(a.charAt(1));
        System.out.println(a.length());
        System.out.println(a.subString(0,1).toString());
        System.out.println(b.toLowerCase().toString());
        System.out.println(a.equals(b));

    }

    private char[] chars;

    public MyString(char[] chars){
        this.chars = chars;
    }

    public char charAt(int index){
        return chars[index];
    }

    public int length(){
        return chars.length;
    }

    public MyString subString(int begin, int end){
        char[] result = new char[end - begin];

        for(int i =0; i < result.length; i++){
            result[i] = chars[begin + i];
        }

        return new MyString(result);
    }

    public MyString toLowerCase(){
        int size = 0;
        for(int i = 0; i < this.chars.length; i++){
            if(Character.isLowerCase(chars[i])){
                size++;
            }
        }

        char[] result = new char[size];

        int array = 0;

        for(int i = 0; i < chars.length; i++){
            if(Character.isLowerCase(chars[i])){
                result[array++] = chars[i];
            }
        }

        return new MyString(result);
    }

    public boolean equals(MyString s){
        if(this.chars.length != s.chars.length){
            return false;
        }
        for(int i = 0; i < this.chars.length; i++){
            if(this.chars[i] != s.chars[i]){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < chars.length; i++){
            result += chars[i];
        }
        return result;
    }
}
