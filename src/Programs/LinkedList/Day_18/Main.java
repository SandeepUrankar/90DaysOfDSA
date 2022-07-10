package Programs.LinkedList.Day_18;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtFirst(15);
        list.insertAtFirst(30);
        list.display();
        System.out.println(list.size);
    }
}
