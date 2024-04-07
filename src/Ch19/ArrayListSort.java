package Ch19;

import java.util.ArrayList;

public class ArrayListSort {

    public static <E extends Comparable<E>> void sort(ArrayList<E> list){
        E currentMax = list.get(0);

        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++) {
                if (currentMax.compareTo(list.get(j)) < 0) {
                    currentMax = list.get(j);
                }

            }
        }
    }
}
