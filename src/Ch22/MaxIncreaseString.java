package Ch22;

public class MaxIncreaseString {

    public static void main(String[] args) {
        String a = "abcabcdgabmnsxy";
        System.out.println(getString(a));
    }
    public static String getString(String s){
        char[] chars = s.toCharArray();

        int len = 0;
        int position = 0;

        int tempL = 0;
        int tempP = 0;


        for(int i = 0; i < chars.length - 1; i++){

            if(chars[i] <= chars[i+1]){
                tempL++;
            }
            else {
                tempP = i + 1;
                tempL = 0;
            }
            if(tempL > len){
                len = tempL;
                position = tempP;
            }
        }
        return s.substring(position, position+len+1);
    }

}
