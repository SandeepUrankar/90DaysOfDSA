package Programs.LinkedList.Day_18;

public class LL {
    public int size;
    private Node head;
    private Node tail;

    //Empty constructor while sets size = 0
    public LL(){
        size = 0;
    }

    //This method inserts the data at the beginning of the linked list.
    public void insertAtFirst(int data){
        //Create a new node with the data given.
        Node node = new Node(data);
        //Assign the value of the head to its next.
        node.next = head;
        //Change head to point to the new node created, making it the first node.
        head = node;

        //If tail is null assign the value of head to it.
        if (tail == null){
            tail = head;
        }
        //Increment the size by 1.
        size += 1;
    }

    //Method for displaying the linked list.
    public void display(){
        //Create a temp Node variable which holds the value of the head, pointing to the start of the list.
        Node temp = head;

        //While temp is not equals to null, that is until it reaches the last node. Print the data.
        while(temp != null){
            System.out.print(temp.data+"->");
            //Make the temp to point to the next node.
            temp = temp.next;
        }
        System.out.println("END");
    }


    private class Node{
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
