package Programs.BackTracking.Day_11;

import java.util.Scanner;

public class Maze {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter rows and columns: ");
        int r = in.nextInt();
        int c = in.nextInt();
        int count = count(r, c);
        System.out.println("The possible number of paths are " + count);
    }

    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = count(r - 1, c);
        int right = count(r, c - 1);
        return left + right;
    }
}