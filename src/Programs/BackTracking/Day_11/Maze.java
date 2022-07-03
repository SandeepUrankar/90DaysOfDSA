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
        System.out.println("And the paths are -");
        path("", r, c);
    }

    static int count(int r, int c) {
        if (r <= 0 || c <= 0) {
            System.out.println("Zero matrix");
            return 0;
        }
        //If the r or c is 1 then we have found 1 possible path. So return 1.
        if (r == 1 || c == 1) {
            return 1;
        }
        //Number of paths from left subtree.
        int left = count(r - 1, c);
        //Number of paths from right subtree.
        int right = count(r, c - 1);
        return left + right;
    }

    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
        }
        if (r > 1) {
            path(p + "D", r - 1, c);
        }
        if (c > 1) {
            path(p + "R", r, c - 1);
        }
    }
}