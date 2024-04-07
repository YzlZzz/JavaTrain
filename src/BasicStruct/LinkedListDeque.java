package BasicStruct;

public class LinkedListDeque {
    private DoubleListNode front;

    private DoubleListNode rear;

    private int size = 0;

    public LinkedListDeque() {
        front = null;
        rear = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void push(int num, boolean isFront) {
        DoubleListNode node = new DoubleListNode(num);

        if (isEmpty()) {
            front = node;
            rear = node;
        } else if (isFront) {
            front.prev = node;
            node.next = front;
            front = node;
        } else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
        size++;
    }

    public void pushFirst(int num) {
        push(num, true);
    }

    public void pushLast(int num) {
        push(num, false);
    }

    private int pop(boolean isFront) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int val;
        if (isFront) {
            val = front.val;

            DoubleListNode next = front.next;
            if (next != null) {
                front.prev = null;
                front.next = null;
            }
            front = next;
        } else {
            val = rear.val;

            DoubleListNode prev = rear.prev;
            if(prev != null){
                rear.next = null;
                rear.prev = null;
            }
            rear = prev;
        }
        size--;
        return val;
    }

    public int popFirst(){
        return pop(true);
    }

    public int popLast(){
        return pop(false);
    }

    public int peekFirst(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return front.val;
    }

    public int peekLast(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return rear.val;
    }

    public int[] toArray(){
        DoubleListNode node = front;
        int[] array = new int[size];

        for(int i = 0; i < array.length; i++){
            array[i] = node.val;
            node = node.next;
        }
        return array;
    }
}
