package Programs.LinkedList.Day_28;

public class Main {
    public static void main(String[] args) {
        ReverseLL list = new ReverseLL();
        list.insertAtLast(5);
        list.insertAtLast(4);
        list.insertAtLast(3);
        list.insertAtLast(2);
        list.insertAtLast(1);
        list.display();
//        list.reverseRecursive(list.head);
        list.reverse();
        list.display();

    }
}
