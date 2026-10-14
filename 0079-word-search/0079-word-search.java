class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (util(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean util(char[][] board, String word, int idx, int row, int col) {
        //Base Case
        if (idx == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(idx)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '$';

        boolean ans = util(board, word, idx + 1, row, col + 1) ||  //right
                      util(board, word, idx + 1, row + 1, col) ||  //down
                      util(board, word, idx + 1, row, col - 1) ||  //left
                      util(board, word, idx + 1, row - 1, col);  //up


        board[row][col] = temp;

        return ans;
    }
}