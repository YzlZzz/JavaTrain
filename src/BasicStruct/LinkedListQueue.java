package BasicStruct;

public class LinkedListQueue {
    private ListNode front;

    private ListNode rear;

    private int size = 0;

    public LinkedListQueue(){
        front = null;
        rear = null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(int num){
        ListNode node = new ListNode(num);

        if(front == null){
            front = node;
        }else {
            rear.next = node;
        }
        rear = node;
        size++;
    }

    public int pop(){
        int num = peek();

        front = front.next;
        size--;
        return num;
    }

    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return front.val;
    }

    public int[] toArray(){
        ListNode node = front;
        int[] array = new int[size()];

        for(int i = 0; i < array.length; i++){
            array[i] = node.val;
            node = node.next;
        }
        return array;
    }
}
