package Ch27;

import java.util.LinkedList;
import java.util.Set;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private static int DEFAULT_INITIAL_CAPACITY = 4;

    //is same as 2^30;
    private static int MAXIMUM_CAPACITY = 1 << 30;

    private int capacity;

    private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;

    private float loadFactorThreshold;

    private int size = 0;

    LinkedList<MyMap.Entry<K, V>>[] table;

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactorThresholdFactor) {
        if (initialCapacity > MAXIMUM_CAPACITY) this.capacity = MAXIMUM_CAPACITY;
        else this.capacity = trimToPowerOf2(initialCapacity);

        this.loadFactorThreshold = loadFactorThresholdFactor;
        table = new LinkedList[capacity];
    }


    @Override
    public void clear() {
        size = 0;
        removeEntries();
    }

    @Override
    public boolean containsKey(K key) {
        if (get(key) != null) return true;
        else return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K, V> entry : bucket) {
                    if (entry.getValue().equals(value)) return true;
                }
            }
        }
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        java.util.Set<MyMap.Entry<K, V>> set = new java.util.HashSet<>();

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K, V> entry : bucket) {
                    set.add(entry);
                }
            }
        }
        return set;
    }

    @Override
    public V get(K key) {
        int bucketIndex = hash(key.hashCode());

        if (table[bucketIndex] != null) {
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set<K> keySet() {
        java.util.Set<K> set = new java.util.HashSet<>();

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K, V> entry : bucket) {
                    set.add(entry.getKey());
                }
            }
        }
        return set;
    }

    @Override
    public V put(K key, V value) {
        if (get(key) != null) {
            int bucketIndex = hash(key.hashCode());
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];

            for (Entry<K, V> entry : bucket) {
                V oldValue = entry.getValue();
                entry.value = value;
                return oldValue;
            }
        }

        if (size >= capacity * loadFactorThreshold) {
            if (capacity == MAXIMUM_CAPACITY) {
                throw new RuntimeException("Exceeding maximum capacity");
            }
            rehash();
        }

        int bucketIndex = hash(key.hashCode());

        if (table[bucketIndex] == null) {
            table[bucketIndex] = new LinkedList<Entry<K, V>>();
        }

        table[bucketIndex].add(new MyMap.Entry<K, V>(key, value));

        size++;

        return value;
    }

    @Override
    public void remove(K key) {
        int bucketIndex = hash(key.hashCode());

        if (table[bucketIndex] != null) {
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)){
                    bucket.remove(entry);
                    size--;
                    break;
                }
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<V> values() {
        java.util.Set<V> set = new java.util.HashSet<>();

        for(int i = 0; i < capacity; i++){
            if(table[i] != null){
                LinkedList<Entry<K, V>> bucket = table[i];
                for(Entry<K, V> entry : bucket){
                    set.add(entry.getValue());
                }
            }
        }
        return set;
    }

    private int hash(int hashCode) {
        return supplementalHash(hashCode) & (capacity - 1);
    }

    private static int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int trimToPowerOf2(int initialCapacity) {
        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1; //same as capacity *= 2.
        }
        return capacity;
    }

    private void removeEntries() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                table[i].clear();
            }
        }
    }

    private void rehash() {
        java.util.Set<Entry<K, V>> set = entrySet(); //get entries
        capacity <<= 1;
        table = new LinkedList[capacity];
        size = 0;

        for (Entry<K, V> entry : set) {
            put(entry.getKey(), entry.getValue());
        }
    }
}
