class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int MODULO = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][target + 1];

        // base case: when n = 0, no dice left to roll
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // iterate through each possible value of the current rolled dice
                for (int t = 1; t <= k; t++) {
                    if (j >= t) {
                        // add the number of ways to reach the current sum j
                        // with the t value of the current dice
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - t]) % MODULO;
                    }
                }
            }
        }

        return dp[n][target];
    }
}