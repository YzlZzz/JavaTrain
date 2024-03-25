package BasicStruct;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {

    private static final int BASE = 769;

    private LinkedList[] data;

    public MyHashMap() {
        data = new LinkedList[BASE];

        for(int i = 0; i < BASE; ++i){
            data[i] = new LinkedList<Pair>();
        }
    }

    public void put(int key, int value){
        int hash = hash(key);

        Iterator<Pair> iterator = data[hash].iterator();

        while(iterator.hasNext()){
            Pair pair = iterator.next();
            if(pair.getKey() == key){
                pair.setValue(value);
                return;
            }
        }
        data[hash].offerLast(new Pair(key, value));
    }

    public int get(int key){
        int hash = hash(key);
        Iterator<Pair> iterator = data[hash].iterator();

        while (iterator.hasNext()){
            Pair pair = iterator.next();
            if(pair.getKey() == key){
                return pair.getValue();
            }
        }
        return -1;
    }

    public void remove(int key){
        int hash = hash(key);

        Iterator<Pair> iterator = data[hash].iterator();

        while (iterator.hasNext()){
            Pair pair = iterator.next();
            if(pair.getKey() == key){
                data[hash].remove(pair);
                return;
            }
        }
    }

    private static int hash(int key){
        return key % BASE;
    }

    class Pair {
        private int key;

        private int value;

        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }

        public int getKey(){
            return key;
        }

        public int getValue(){
            return value;
        }

        public void setValue(int value){
            this.value = value;
        }
    }
}
