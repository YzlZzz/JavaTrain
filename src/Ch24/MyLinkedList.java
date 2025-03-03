package Ch24;

class MyLinkedList<E> {
    private Node<E> head, tail;
    private int size = 0; // Number of elements in the list

    /**
     * Create an empty list
     */
    public MyLinkedList() {
    }

    /**
     * Create a list from an array of objects
     */
    public MyLinkedList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            addAtIndex(i, objects[i]);
    }

    /**
     * Return the head element in the list
     */
    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    /**
     * Return the last element in the list
     */
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    /**
     * Add an element to the beginning of the list
     */
    public void addAtHead(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size

        if (tail == null) // the new node is the only node in list
            tail = head;
    }

    /**
     * Add an element to the end of the list
     */
    public void addAtTail(E e) {
        Node<E> newNode = new Node<>(e); // Create a new for element e

        if (tail == null) {
            head = tail = newNode; // The new node is the only node in list
        } else {
            tail.next = newNode; // Link the new with the last node
            tail = tail.next; // tail now points to the last node
        }

        size++; // Increase size
    }


    /**
     * Add a new element at the specified index
     * in this list. The index of the head element is 0
     */
    public void addAtIndex(int index, E e) {
        if (index == 0) {
            addAtHead(e);
        } else if (index >= size) {
            addAtTail(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    /**
     * Remove the head node and
     * return the object that is contained in the removed node.
     */
    public E deleteHead() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    /**
     * Remove the last node and
     * return the object that is contained in the removed node.
     */
    public E deleteTail() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;

            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    /**
     * Remove the element at the specified position in this
     * list. Return the element that was removed from the list.
     */
    public E deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return deleteHead();
        } else if (index == size - 1) {
            return deleteTail();
        } else {
            Node<E> previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    /**
     * Override toString() to return elements in the list
     */
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }

    /**
     * Clear the list
     */
    public void clear() {
        size = 0;
        head = tail = null;
    }

    /**
     * Return true if this list contains the element e
     */
    public boolean contains(Object o) {
        // Implement it in this exercise
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(o))
                return true;
            current = current.next;
        }

        return false;
    }

    /**
     * Return the element from this list at the specified index
     */
    public E get(int index) {
        // Implement it in this exercise
        if (index < 0 || index > size - 1)
            return null;

        Node<E> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;

        return current.element;
    }

    /**
     * Returns the index of the first matching element in this list.
     * Returns -1 if no match.
     */
    public int indexOf(Object o) {
        // Implement it in this exercise
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(o))
                return i;
            current = current.next;
        }

        return -1;
    }

    /**
     * Returns the index of the last matching element in this list
     * Returns -1 if no match.
     */
    public int lastIndexOf(Object o) {
        // Implement it in this exercise
        int lastIndex = -1;
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(o))
                lastIndex = i;
            current = current.next;
        }

        return lastIndex;
    }

    /**
     * Replace the element at the specified position in this list
     * with the specified element.
     */
    public E set(int index, E e) {
        if (index < 0 || index > size - 1)
            return null;

        Node<E> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;

        E temp = current.element;
        current.element = e;

        return temp;
    }

    /**
     * Override iterator() defined in Iterable
     */
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator
            implements java.util.Iterator<E> {
        private Node<E> current = head; // Current index

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override
        public void remove() {
            // Left as an exercise
        }
    }

    private class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public int size() {
        return size;
    }
}
