package Programs.LinkedList.Day_22;

public class CLL {
    int size;
    Node head;
    Node tail;

    public CLL() {
        size = 0;
    }

    public void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        if (tail == null) {
            head = node;
            tail = node;
        }
        if (tail != null) {
            tail.next = node;
        }
        size++;
    }

    public void insertLast(int data) {
        if (head == null) {
            insertFirst(data);
            return;
        }
        Node node = new Node(data);
        tail.next = node;
        node.next = head;
        tail = node;
        size++;
    }

    public void insert(int index, int data) {
        if (index == 0) {
            insertFirst(data);
            return;
        }
        if (index == size) {
            insertLast(data);
            return;
        }
        Node node = new Node(data);
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        tail.next = head;
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node secondLast = head;
        do {
            secondLast = secondLast.next;
        }while (secondLast.next.next != head);
        secondLast.next = head;
        tail = secondLast;
        size--;
    }

        public void display(){
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + "->");
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println("HEAD");
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
