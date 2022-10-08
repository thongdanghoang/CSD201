package chapter3_fundamental_data_structures;

public class CircularlyLinkedList<E> {

    //---------------- nested Node class ----------------
    private static class Node<E> {

        private final E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }
    //----------- end of nested Node class -----------

    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getElement();
    }

    public E last() { // returns (but does not remove) the last element
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void rotate() { // rotate the first element to the back of the list
        if (tail != null) // if empty, do nothing
        {
            tail = tail.getNext(); // the old head becomes the new tail
        }
    }

    public void addFirst(E e) { // adds element e to the front of the list
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail); // link to itself circularly
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e) { // adds element e to the end of the list
        addFirst(e); // insert new element at front of list
        tail = tail.getNext(); // now new element becomes the tail
    }

    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) {
            return null; // nothing to remove
        }
        Node<E> head = tail.getNext();
        if (head == tail) {
            tail = null; // must be the only node left
        } else {
            tail.setNext(head.getNext()); // removes ”head” from the list
        }
        size--;
        return head.getElement();
    }
}
