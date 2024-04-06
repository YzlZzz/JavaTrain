package BasicStruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyHeap {
    private List<Integer> nums;

    public MyHeap(int size){
        nums = new ArrayList<>(size);
    }

    public MyHeap(List<Integer> nums){
        this.nums = new ArrayList<>(nums);
        for(int i = parent(size() - 1); i >= 0; i--){
            siftDown(i);
        }
    }

    public int size(){
        return nums.size();
    }

    public boolean isEmpty(){
        return nums.isEmpty();
    }

    private int left(int i){
        return 2 * i + 1;
    }

    private int right(int i){
        return 2 * i + 2;
    }

    private int parent(int i){
        return (i - 1) / 2;
    }

    public int peek(){
        return nums.get(0);
    }

    private void swap(int i, int j){
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    public void push(int val){
        nums.add(val);
        siftUp(size() - 1);
    }

    public int pop(){
        if(nums.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        swap(0, size() - 1);
        int val = nums.remove(size() - 1);
        siftDown(0);
        return val;
    }

    private void siftUp(int i){
        while(true){
            int p = parent(i);

            if(p < 0 || nums.get(i) <= nums.get(p)){
                break;
            }

            swap(i, p);
            i = p;
        }
    }

    private void siftDown(int i){
        while(true){
            int l = left(i);
            int r = right(i);
            int max = i;

            if(l < size() && nums.get(l) > nums.get(i)){
                max = l;
            }
            if(r < size() && nums.get(r) > nums.get(i)){
                max = r;
            }
            if(max == i) break;

            swap(i, max);
            i = max;
        }
    }
}
