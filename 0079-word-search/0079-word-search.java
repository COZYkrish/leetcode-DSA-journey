class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] target = word.toCharArray();

        if (target.length > m * n) {
            return false;
        }

        int[] boardFreq = new int[128];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                boardFreq[board[r][c]]++;
            }
        }

        int[] wordFreq = new int[128];
        for (char ch : target) {
            wordFreq[ch]++;
            if (wordFreq[ch] > boardFreq[ch]) {
                return false;
            }
        }

        if (boardFreq[target[target.length - 1]] < boardFreq[target[0]]) {
            reverse(target);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == target[0] && dfs(board, target, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, char[] target, int r, int c, int idx) {
        if (idx == target.length - 1) {
            return true;
        }

        char original = board[r][c];
        board[r][c] = '#';

        int nextIdx = idx + 1;
        for (int[] d : DIRS) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length
                    && board[nr][nc] == target[nextIdx]) {
                if (dfs(board, target, nr, nc, nextIdx)) {
                    board[r][c] = original;
                    return true;
                }
            }
        }

        board[r][c] = original;
        return false;
    }

    private void reverse(char[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}