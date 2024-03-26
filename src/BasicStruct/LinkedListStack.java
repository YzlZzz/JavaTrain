package BasicStruct;

public class LinkedListStack {
    private ListNode stackPeek;

    private int size = 0;

    public LinkedListStack(){
        stackPeek = null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    void push(int num){
        ListNode node = new ListNode(num);
        node.next = stackPeek;
        stackPeek = node;
        size++;
    }

    int pop(){
        int num = peek();
        stackPeek = stackPeek.next;
        size--;
        return num;
    }

    int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return stackPeek.val;
    }

    public int[] toArray(){
        ListNode node = stackPeek;
        int[] array = new int[size()];

        for(int i = array.length - 1; i >= 0; i--){
            array[i] = node.val;
            node = node.next;
        }
        return array;
    }
}
