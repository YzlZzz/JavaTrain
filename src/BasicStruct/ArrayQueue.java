package BasicStruct;

import java.util.Arrays;

public class ArrayQueue {
    private int[] nums;

    private int front = 0;

    private int size = 0;

    private int capacity = 10;

    private int extendRatio = 2;

    public ArrayQueue(){
        nums = new int[capacity];
    }

    public ArrayQueue(int capacity){
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
        return size() == 0;
    }

    public void push(int num){
        if(size == capacity) extendCapacity();

        int rear = (front + size) % capacity;
        nums[rear]  = num;
        size++;
    }

    public int pop(){
        int num = peek();

        front = (front + 1) % capacity;
        size--;
        return num;
    }

    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return nums[front];
    }

    public void extendCapacity(){
        nums = Arrays.copyOf(nums, capacity * extendRatio);
        capacity = nums.length;
    }

    public int[] toArray(){
        int[] array = new int[size];

        for(int i = 0, j = front; i < size; i++, j++){
            array[i] = nums[j % capacity];
        }
        return array;
    }

}
