package Programs.BackTracking.Day_13;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knight(board, 0, 0, n);
    }
    static void knight(boolean[][] board, int row, int col, int knights) {
        //If all the knights are placed, print the board.
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        //If the col is at the last, try with next row
        if (col == board.length) {
            knight(board, row + 1, 0, knights);
            return;
        }

        if (row == board.length - 1 && col == board.length - 1) {
            return;
        }

        //If the cell is safe place there and move ahead.
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        //If the cell is not safe, just move ahead don't place.
        knight(board, row, col + 1, knights);
    }
    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        return true;
    }
    private static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }
    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("K");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
}
