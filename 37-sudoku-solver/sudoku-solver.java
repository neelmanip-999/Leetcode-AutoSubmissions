class Solution {
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][] boxes = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        // Initialize state
        initialize(board);
        solve(board, 0, 0);
    }

    private void initialize(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1';
                    int boxIdx = (r / 3) * 3 + (c / 3);
                    rows[r][num] = cols[c][num] = boxes[boxIdx][num] = true;
                }
            }
        }
    }

    private boolean solve(char[][] board, int row, int col) {
        if (col == 9) {
            row++;
            col = 0;
        }
        if (row == 9) {
            return true;
        }
        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }

        int boxIdx = (row / 3) * 3 + (col / 3);
        for (int num = 0; num < 9; num++) {
            if (!rows[row][num] && !cols[col][num] && !boxes[boxIdx][num]) {
                board[row][col] = (char) ('1' + num);
                rows[row][num] = cols[col][num] = boxes[boxIdx][num] = true;

                if (solve(board, row, col + 1)) {
                    return true;
                }

                // Backtrack
                board[row][col] = '.';
                rows[row][num] = cols[col][num] = boxes[boxIdx][num] = false;
            }
        }
        return false;
    }
}
