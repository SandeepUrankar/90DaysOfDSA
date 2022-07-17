package Programs.LinkedList.Day_23;

public class LL {
    public int size;
    private Node head;
    private Node tail;

    //Empty constructor while sets size = 0
    public LL() {
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


    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public void removeDuplicates(){
        Node node = head;
        while (node.next != null){
            if (node.data == node.next.data){
                node.next = node.next.next;
                size --;
            }
            else {
                node = node.next;
            }
        }
        tail = node;
    }

    //https://leetcode.com/problems/merge-two-sorted-lists/
    public static LL mergeTwoSortedList(LL first, LL second){
        Node f = first.head;
        Node s = second.head;
        LL ans = new LL();
        while (f != null && s != null){
            if (f.data <= s.data){
                ans.insertAtLast(f.data);
                f = f.next;
            }
            else{
                ans.insertAtLast(s.data);
                s = s.next;
            }
        }
        while (f != null){
            ans.insertAtLast(f.data);
            f = f.next;
        }
        while (s != null){
            ans.insertAtLast(s.data);
            s = s.next;
        }
        return ans;
    }

    //Detect Cycles  https://leetcode.com/problems/linked-list-cycle/
    /*
    public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
     */
    public static void main(String[] args) {
//        LL list = new LL();
//        list.insertAtLast(1);
//        list.insertAtLast(1);
//        list.insertAtLast(2);
//        list.insertAtLast(3);
//        list.insertAtLast(3);
//        list.display();
//        list.removeDuplicates();
//        list.display();
        LL one = new LL();
        LL two = new LL();
        one.insertAtLast(1);
        one.insertAtLast(3);
        one.insertAtLast(5);
        two.insertAtLast(1);
        two.insertAtLast(2);
        two.insertAtLast(4);
        two.insertAtLast(6);
        two.insertAtLast(7);
        LL ans = LL.mergeTwoSortedList(one, two);
        ans.display();
    }
}
