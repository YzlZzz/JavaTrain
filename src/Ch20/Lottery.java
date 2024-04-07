package Ch20;

import java.util.*;


public class Lottery{

    public static void main(String[] args) {
        List<Integer> lottery = creatLottery();

        System.out.print("Please enter a three-digit number: ");
        Scanner input = new Scanner(System.in);


        int scanner = input.nextInt();
        List<Integer> myLottery = getLottery(scanner);

        checkPrize(lottery, myLottery);

    }

    public static List<Integer> creatLottery(){
        List<Integer> lottery = new ArrayList<Integer>();

        for(int i = 0; i < 3; i++){
            lottery.add((int)(Math.random()*10) );
        }

        return lottery;
    }

    public static List<Integer> getLottery(int scanner){
        if(scanner >= 1000 || scanner < 0){
            System.out.println("invalid input");
            System.exit(0);
        }

        List<Integer> newLottery = new ArrayList<Integer>();
        for(int i = 0; i < 3; i++){
            newLottery.add(scanner % 10);
            scanner /= 10;
        }
        Collections.reverse(newLottery);
        return newLottery;
    }

    public static void checkPrize(List<Integer> lottery, List<Integer> newLottery){
        System.out.println("prize number: ");
        for(int i : lottery){
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("your number: ");
        for(int i : newLottery){
            System.out.print(i + " ");
        }
        System.out.println();

        if(lottery.equals(newLottery)){
            System.out.println("Congratulation: You get the first prize, 10000$!");
            System.exit(0);
        }


        Collections.sort(lottery);
        Collections.sort(newLottery);
        int count = 0;

        for(int i  : newLottery){
            for(int j = 0; j < lottery.size(); j++){
                if(i == lottery.get(j)){
                    count++;
                    lottery.remove(j);
                }
            }
        }

        switch (count) {
            case 0 -> System.out.println("You have no prize!");
            case 1 -> System.out.println("Congratulation: You get the forth prize, 1000$");
            case 2 -> System.out.println("Congratulation: You get the third prize, 3000$");
            case 3 -> System.out.println("Congratulation: You get the second prize, 5000$");
        }
    }

}
