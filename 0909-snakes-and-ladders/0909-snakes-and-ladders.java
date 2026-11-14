class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[target + 1];        
        queue.offer(1);
        visited[1] = true;
        int moves = 0;        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == target) {
                    return moves;
                }
                for (int next = curr + 1; next <= Math.min(curr + 6, target); next++) {
                    int[] pos = getCoords(next, n);
                    int r = pos[0];
                    int c = pos[1];           
                    int destination = (board[r][c] == -1) ? next : board[r][c];
                    
                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            moves++;
        }   
        return -1;
    }
    private int[] getCoords(int square, int n) {
        int r = n - 1 - (square - 1) / n;
        int c = (square - 1) % n;
        if ((n - 1 - r) % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{r, c};
    }
}