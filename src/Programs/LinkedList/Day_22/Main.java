package Programs.LinkedList.Day_22;

public class Main {
    public static void main(String[] args) {
        CLL list = new CLL();
        list.insertFirst(10);
        list.insertFirst(9);
        list.insertFirst(8);
        list.insertFirst(7);
        list.insertLast(12);
        list.insertLast(13);
        list.insertLast(14);
        list.insert(0, 6);
        list.insert(5, 11);
        list.insert(9, 15);
        list.display();
        list.deleteFirst();
        list.display();
        System.out.println(list.size);
        list.deleteFirst();
        list.deleteLast();
        list.display();
        System.out.println(list.size);
    }
}
