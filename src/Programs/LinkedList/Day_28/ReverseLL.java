package Programs.LinkedList.Day_28;

import Programs.LinkedList.Day_18.LL;

public class ReverseLL {
    public int size;
    public Node head;
    private Node tail;

    //Empty constructor while sets size = 0
    public ReverseLL() {
        size = 0;
    }

    //This method inserts the data at the beginning of the linked list.
    public void insertAtFirst(int data) {
        //Create a new node with the data given.
        Node node = new Node(data);
        //Assign the value of the head to its next.
        node.next = head;
        //Change head to point to the new node created, making it the first node.
        head = node;

        //If tail is null assign the value of head to it.
        if (tail == null) {
            tail = head;
        }
        //Increment the size by 1.
        size += 1;
    }

    //This method inserts the data at the last of the linked list.
    public void insertAtLast(int data) {
        //
        if (tail == null) {
            insertAtFirst(data);
            return;
        }
        Node node = new Node(data);
        /* Could do this. Time complexity O(n).
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        */
        //Updating the last node next to the new node.
        tail.next = node;
        //Assigning new node to tail.
        tail = node;
        size++;
    }

    //This method inserts the data at some index of the linked list.
    public void insert(int data, int index) {
        //If the list is empty.
        if (index == 0) {
            insertAtFirst(data);
            return;
        }
        //If the index value is at the last.
        if (index == size) {
            insertAtLast(data);
            return;
        }
        //Take a temp node to traverse till the previous node of the index.
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        //Create a new node. And pass the next value as the previous node's next.
        Node node = new Node(data, temp.next);
        //Update the previous node's next to newly created node.
        temp.next = node;
        size++;
    }

    //Method for displaying the linked list.
    public void display() {
        //Create a temp Node variable which holds the value of the head, pointing to the start of the list.
        Node temp = head;

        //While temp is not equals to null, that is until it reaches the last node. Print the data.
        while (temp != null) {
            System.out.print(temp.data + "->");
            //Make the temp to point to the next node.
            temp = temp.next;
        }
        System.out.println("END");
    }

    //Method to delete value at first.
    public int deleteFirst() {
        //store the data from the fist node.
        int val = head.data;
        //Increment the head pointer to remove the link of the first node.
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    //Method to delete value at last.
    public int deleteLast() {
        //If the size is 1, then deleteFirst will be called.
        if (size <= 1) {
            return deleteFirst();
        }
        //Get the second last node.
        Node secondLast = get(size - 2);
        //Store the data from the last node.
        int data = tail.data;
        //Point the tail to second last node.
        tail = secondLast;
        //The second last node will point to null, hence last node deleted.
        secondLast.next = null;
        size--;
        return data;
    }

    //Method to delete at a given index.
    public int delete(int index) {
        //If index is 0 call deleteFirst.
        if (index == 0) {
            return deleteFirst();
        }
        //If the index is last, call deletLast.
        if (index == size - 1) {
            return deleteLast();
        }
        //Get the previous node to the index.
        Node previous = get(index - 1);
        //Store the data.
        int data = previous.next.data;
        //Point the previous to the next of current node.
        previous.next = previous.next.next;
        size --;
        return data;
    }

    //Method that return the node at given index
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    //Method for reversing a Linked List using recursion.
    public void reverseRecursive(Node node){
        //Base condition - if the current node is tail then change head to tail.
        if (node == tail){
            head = tail;
            return;
        }
        //Calling recursively until it reaches tail.
        reverseRecursive(node.next);

        //When it reaches the tail, start reversing.
        tail.next = node;
        tail = node;
        tail.next = null;
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
