package Programs.BackTracking.Day_11;

import java.util.ArrayList;
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
        System.out.println(pathRet("", r, c));
        //Maze with Obstacles or Restriction.
//        boolean maze[][] = {
//                {true, true, true},
//                {true, false, true},
//                {true, true, true}
//        };
//        pathRestriction("", maze, 0, 0);
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
        int mid = count(r - 1, c - 1);
        //Number of paths from right subtree.
        int right = count(r, c - 1);
        return left + right + mid;
    }

    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
        }
        if (r > 1 && c > 1) {
            path(p + "D", r - 1, c - 1); //Diagonally
        }
        if (r > 1) {
            path(p + "V", r - 1, c);    //Vertically
        }
        if (c > 1) {
            path(p + "H", r, c - 1);    //Horizontally
        }
    }

    static ArrayList<String> pathRet(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (r > 1 && c > 1) {
            list.addAll(pathRet(p + "D", r - 1, c - 1)); //Diagonally
        }
        if (r > 1) {
            list.addAll(pathRet(p + "V", r - 1, c));    //Vertically
        }
        if (c > 1) {
            list.addAll(pathRet(p + "H", r, c - 1));    //Horizontally
        }
        return list;
    }

    static void pathRestriction(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
        }
        if (!maze[r][c]) {
            return;
        }
        if (r < maze.length - 1 && c < maze[0].length - 1) {
            pathRestriction(p + "D", maze, r + 1, c + 1); //Diagonally
        }
        if (r < maze.length - 1) {
            pathRestriction(p + "V", maze, r + 1, c);    //Vertically
        }
        if (c < maze[0].length - 1) {
            pathRestriction(p + "H", maze, r, c + 1);    //Horizontally
        }
    }

}