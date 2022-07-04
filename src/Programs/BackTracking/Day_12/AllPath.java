package Programs.BackTracking.Day_12;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AllPath {
    public static void main(String[] args) {
        boolean maze[][] = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[maze.length][maze[0].length];
        allPathPrint("", maze, 0, 0, path, 1);
    }
    static void allPath(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        maze[r][c] = false;     //Mark visited when entering the fuction call.
        if (r < maze.length - 1) {
            allPath(p + "D", maze, r + 1, c);    //Down
        }
        if (c < maze[0].length - 1) {
            allPath(p + "R", maze, r, c + 1);    //Right
        }
        if (r > 0) {
            allPath(p + "U", maze, r - 1, c);    //Up
        }
        if (c > 0) {
            allPath(p + "L", maze, r, c - 1);    //Left
        }
        maze[r][c] = true;  //Revert back the changes before the called method gets removed from the stack.
        //This is backtracking.
    }
    static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for (int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        //Mark visited when entering the fuction call.
        maze[r][c] = false;

        path[r][c] = step;
        if (r < maze.length - 1) {
            //Down
            allPathPrint(p + "D", maze, r + 1, c, path, step+1);
        }
        if (c < maze[0].length - 1) {
            //Right
            allPathPrint(p + "R", maze, r, c + 1, path, step+1);
        }
        if (r > 0) {
            //Up
            allPathPrint(p + "U", maze, r - 1, c,path, step+1);
        }
        if (c > 0) {
            //Left
            allPathPrint(p + "L", maze, r, c - 1,path, step+1);
        }
        //Revert back the changes before the called method gets removed from the stack.
        maze[r][c] = true;
        //This is backtracking.
        path[r][c] = 0;
    }


}
