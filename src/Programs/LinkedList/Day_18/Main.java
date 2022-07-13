package Programs.LinkedList.Day_18;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtFirst(15);
        list.insertAtFirst(30);
        list.insertAtLast(40);
        list.insert(18, 3);
        list.display();
        System.out.println("Size: " + list.size);
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println("Size: " + list.size);
        System.out.println(list.deleteLast());
        list.display();
        System.out.println("Size: " + list.size);
    }
}
