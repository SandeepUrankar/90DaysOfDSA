package Programs.LinkedList.Day_21;

public class Main {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(12);
        list.insertFirst(11);
        list.insertLast(77);
        list.insertLast(88);
        list.insert(77, 78);
        list.insert(88, 99);
        list.insert(99, 99);
        list.display();
        System.out.println(list.size);
    }
}
