class Solution {
    private int solve(int[] stoneValue, int i, int[] dp) {
        //Base case
        if (i >= stoneValue.length) {
            return 0;
        }

        if(dp[i] != Integer.MIN_VALUE) {
            return dp[i];
        }

        int first = stoneValue[i] - solve(stoneValue, i + 1, dp);

        int second = Integer.MIN_VALUE;
        if ((i + 1) < stoneValue.length) {
            second = stoneValue[i] + stoneValue[i + 1] - solve(stoneValue, i + 2, dp);
        }

        int third = Integer.MIN_VALUE;
        if ((i + 2) < stoneValue.length) {
            third = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - solve(stoneValue, i + 3, dp);
        }

        return dp[i] = Math.max(first, Math.max(second, third));
    }

    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length];

        Arrays.fill(dp, Integer.MIN_VALUE);

        int score = solve(stoneValue, 0, dp);
        
        //returning ans
        if (score == 0) {
            return "Tie";
        } else if (score > 0) {
            return "Alice";
        }
        return "Bob";
    }
}