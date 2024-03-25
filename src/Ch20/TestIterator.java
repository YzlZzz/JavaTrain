package Ch20;

import java.util.LinkedList;

public class TestIterator {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i = 0; i < 150000; i++){
            list.add((int) (Math.random() * 5000000));
        }

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < list.size(); i++){
            list.get(i);
        }

        long endTime = System.currentTimeMillis();

        double time = (endTime - startTime) / 1000.0;

        System.out.println("Travese time using index is " + time + "s");

        startTime = System.currentTimeMillis();
        for(int i : list){
            int x = i;
        }

        endTime = System.currentTimeMillis();

        time = (endTime - startTime) / 1000.0;

        System.out.print("Travese time using iterator is " + time + "s");
    }
}
