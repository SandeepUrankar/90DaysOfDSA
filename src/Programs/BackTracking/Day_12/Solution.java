package Programs.BackTracking.Day_12;

import java.util.*;

//Solution for leetcode https://leetcode.com/problems/n-queens/submissions/
class Solution {
    public static void main(String[] args) {
        List<List<String>> ans = solveNQueens(4);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    static public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        queens(board, 0, ans);
        return ans;
    }

    static int queens(boolean[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            displayBoard(board, ans);
            return 1;
        }
        int count = 0;
        //placing the queen and checking all row.
        for (int col = 0; col < board.length; col++) {
            //place the queen if it is safe.
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1, ans);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //check vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        //check diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        //check diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }

    private static void displayBoard(boolean[][] board, List<List<String>> ans) {
        String temp = "";
        List<String> tempList = new ArrayList<>();
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    temp += "Q";
                } else {
                    temp += ".";
                }
            }
            tempList.add(temp);
            temp = "";
        }
        ans.add(tempList);
    }
}
