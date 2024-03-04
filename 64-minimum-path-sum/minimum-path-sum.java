class Solution {
    // Memoization
    public int calc(int r , int c , int[][] dp , int[][] grid) {
        // base case
        if(r < 0 || c < 0) return Integer.MAX_VALUE;
        if(r == 0 && c == 0) return grid[r][c];

        // check
        if(dp[r][c] != -1) return dp[r][c];

        // calc
        int from_up = calc(r - 1, c, dp , grid);
        int from_left = calc(r , c - 1, dp , grid);
        int res = grid[r][c] + Math.min(from_up, from_left);

        // store and return
        dp[r][c] = res;
        return res;
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] a  : dp) {
            Arrays.fill(a, -1);
        }
        return calc(grid.length - 1, grid[0].length - 1, dp , grid);
        
    }
}