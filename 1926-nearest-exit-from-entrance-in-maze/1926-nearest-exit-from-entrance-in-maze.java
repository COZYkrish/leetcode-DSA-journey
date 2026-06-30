class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1]});

        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] d : dir) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                        continue;

                    if (maze[nr][nc] == '+' || visited[nr][nc])
                        continue;

                    if (nr == 0 || nr == m - 1 || nc == 0 || nc == n - 1)
                        return steps + 1;

                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
            steps++;
        }
        return -1;
    }
}