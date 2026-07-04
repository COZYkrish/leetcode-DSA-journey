class Solution {

    long[][] memo;
    List<Integer> robots;
    int[][] factories;
    final long INF = (long)1e18;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        robots = robot;
        factories = factory;
        memo = new long[robot.size() + 1][factory.length + 1];

        for (long[] row : memo)
            Arrays.fill(row, -1);

        return dfs(0, 0);
    }

    private long dfs(int i, int j) {

        if (i == robots.size())
            return 0;

        if (j == factories.length)
            return INF;

        if (memo[i][j] != -1)
            return memo[i][j];
        long ans = dfs(i, j + 1);

        long cost = 0;
        for (int k = i;
             k < robots.size() && k < i + factories[j][1];
             k++) {

            cost += Math.abs((long)robots.get(k) - factories[j][0]);

            ans = Math.min(ans,
                    cost + dfs(k + 1, j + 1));
        }

        return memo[i][j] = ans;
    }
}