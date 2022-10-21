package assignment3;

public class exist {
    public static void main(String[] args) {
        char[][] test = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        boolean result = exist(test, "ABCCED");
        System.out.print("The result is " + result);
    }

    private static boolean res = false;

    private static boolean exist(char[][] board, String word) {
        // initiate a map called trip to mark down a path it traverses at every time.
        // when it reachs a cell in which the character is not equal to corresponding character in the given string, it goes back to previous node of the path and try to go in another direction until it goes back to beginning node of the path.
        boolean[][] trip = new boolean[board.length][board[0].length];
        for(int m = 0; m < board.length; ++m) {
            for(int n = 0; n < board[0].length; ++n) {
                dps(board, trip, 0, m, n, word);
            }
        }
        return res;
    }

    private static void dps(char[][] board, boolean[][] trip, int index, int x, int y, String word) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || trip[x][y]
                || board[x][y] != word.charAt(index)) {
            return;
        }
        if(index == word.length() - 1) {
            res = true;
            return;
        }
        trip[x][y] = true;
        dps(board, trip, index + 1, x - 1, y, word);
        dps(board, trip, index + 1, x + 1, y, word);
        dps(board, trip, index + 1, x, y - 1, word);
        dps(board, trip, index + 1, x, y + 1, word);
        trip[x][y] = false;
    }

}
