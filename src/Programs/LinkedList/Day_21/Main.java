package Programs.LinkedList.Day_21;

public class Main {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(12);
        list.insertFirst(11);
        list.display();
        System.out.println(list.size);
    }
}
