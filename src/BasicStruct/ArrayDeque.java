package BasicStruct;

import java.util.Arrays;

public class ArrayDeque {
    private int[] nums;

    private int front;

    private int size = 0;

    private int capacity = 10;

    private int extendRatio = 2;

    public ArrayDeque(){
        nums = new int[capacity];
    }

    public ArrayDeque(int capacity){
        this.capacity = capacity;
        nums = new int[this.capacity];
    }

    public int capacity(){
        return capacity;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private int index(int i){
        return (i + capacity) % capacity;
    }

    public void pushFirst(int num){
        if(size == capacity) extendCapacity();

        front = index(front - 1);
        nums[front] = num;
        size++;
    }

    public void pushLast(int num){
        if(size == capacity) extendCapacity();

        int rear = index(front + size);
        nums[rear] = num;
        size++;
    }

    public int popFirst(){
        int first = peekFirst();

        front = index(front + 1);
        size--;
        return first;
    }

    public int popLast(){
        int last = peekLast();

        size--;
        return last;
    }

    public int peekFirst(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return nums[front];
    }

    public int peekLast(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        int last = index(front + size - 1);
        return nums[last];
    }

    public void extendCapacity(){
        nums = Arrays.copyOf(nums, capacity * extendRatio);
        capacity = nums.length;
    }

    public int[] toArray(){
        int[] array = new int[size];

        for(int i = 0, j = front; i < size; i++, j++){
            array[i] = nums[index(j)];
        }
        return array;
    }
}
