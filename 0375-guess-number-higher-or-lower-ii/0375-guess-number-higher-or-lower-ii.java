class Solution {
    public int getMoneyAmount(int n) {

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 2; len <= n; len++) {

            for (int left = 1; left + len - 1 <= n; left++) {

                int right = left + len - 1;
                dp[left][right] = Integer.MAX_VALUE;

                for (int x = left; x <= right; x++) {

                    int leftCost = (x > left) ? dp[left][x - 1] : 0;
                    int rightCost = (x < right) ? dp[x + 1][right] : 0;

                    int cost = x + Math.max(leftCost, rightCost);

                    dp[left][right] = Math.min(dp[left][right], cost);
                }
            }
        }

        return dp[1][n];
    }
}