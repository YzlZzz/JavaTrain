package BasicStruct;

import java.util.Arrays;

public class MyList {
    private int[] arr;

    private int capacity;

    private int size = 0;

    private int extendRatio;

    public MyList() {
        arr = new int[capacity];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(" index out of bounds");
        }
        return arr[index];
    }

    public void set(int index, int num) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(" index out of bounds");
        }
        arr[index] = num;
    }

    public void add(int num) {
        if (size == capacity) extendCapacity();

        arr[size++] = num;
    }

    public void insert(int index, int num) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(" index out of bounds");
        }

        if (size == capacity) extendCapacity();

        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = index;
        }
        arr[index] = num;
        size++;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(" index out of bounds");
        }

        int temp = arr[index];

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return temp;
    }

    public int[] toArray(){
        int size = size();

        return Arrays.copyOf(this.arr, size);
    }

    public void extendCapacity() {
        arr = Arrays.copyOf(arr, capacity * extendRatio);
        capacity = arr.length;
    }
}
