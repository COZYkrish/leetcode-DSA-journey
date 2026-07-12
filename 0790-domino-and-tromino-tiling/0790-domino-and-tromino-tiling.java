class Solution {
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;
        long a = 1; // dp[1]
        long b = 2; // dp[2]
        long c = 5; // dp[3]
        for (int i = 4; i <= n; i++) {
            long d = (2 * c + a) % MOD;
            a = b;
            b = c;
            c = d;
        }
        return (int) c;
    }
}