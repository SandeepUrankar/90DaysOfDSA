package Programs.LinkedList.Day_21;

public class DLL {
    int size;
    Node head;

    public DLL() {
        size = 0;
    }

    public void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        size++;
    }

    public void insertLast(int data) {
        Node node = new Node(data);
        node.next = null;
        Node last = head;

        if (head == null) {
            head = node;
            node.prev = null;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;
        size ++;
    }

    public Node find(int data){
        Node temp = head;
        while(temp != null){
            if (temp.data == data){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void insert(int after, int data){
        Node prev = find(after);
        if (prev == null){
            System.out.println("Value "+after+" doesn't exist.");
            return;
        }

        Node node = new Node(data);
        node.next = prev.next;
        prev.next = node;
        node.prev = prev;
        if(node.next != null){
            node.next.prev = node;
        }
        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {
        int data;
        Node next;
        Node prev;


        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
