package BasicStruct;

import java.util.ArrayList;

public class ArrayStack {
    private ArrayList<Integer> stack;

    public ArrayStack(){
        stack = new ArrayList<>();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void push(int num){
        stack.add(num);
    }

    public int pop(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return stack.remove(size() - 1);
    }

    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return stack.get(size() - 1);
    }
}
