package Ch9;

import java.util.Date;

public class UseDate {
    public static void main(String[] args){
        Date a = new Date(10000);
        System.out.println(a.toString());

        a.setTime(100000);
        System.out.println(a.toString());

        a.setTime(1000000);
        System.out.println(a.toString());

        a.setTime(10000000);
        System.out.println(a.toString());

        a.setTime(100000000);
        System.out.println(a.toString());

        a.setTime(1000000000);
        System.out.println(a.toString());

        /***
         * To do
         * 参数太大
         * long
         */
        /*a.setTime(10000000000);
        System.out.println(a.toString());

        a.setTime(100000000000);
        System.out.println(a.toString());*/
    }
}
