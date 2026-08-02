class Solution {
    //Helper Fnx
    private int solve(int left, int right, int[] piles, int[][] dp) {
        //Base Case
        if (left == right) {
            return dp[left] [right] = piles[left];
        }

        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        int choosingLeft = piles[left] - solve(left + 1, right, piles, dp);
        int choosingRight = piles[right] - solve(left, right - 1, piles, dp);

        int max = Math.max(choosingLeft, choosingRight);
        dp[left][right] = max;

        return max;
    }

    //Main Fnx
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        int score = solve(0, piles.length - 1, piles, dp);

        return score >= 0;
    }
}