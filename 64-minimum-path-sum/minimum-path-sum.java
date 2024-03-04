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
        // Memoization
        /*

        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] a  : dp) {
            Arrays.fill(a, -1);
        }
        return calc(grid.length - 1, grid[0].length - 1, dp , grid);

        Tabulation
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int col = 1 ; col < grid[0].length ; col++) {
            dp[0][col] = grid[0][col] + dp[0][col-1];
        }
        for(int row = 1; row < grid.length; row++) {
            dp[row][0] = grid[row][0] + dp[row - 1][0];
        }

        for(int i = 1 ; i < grid.length ; i++) {
            for(int j = 1; j < grid[0].length ; j++) {
                dp[i][j] = grid[i][j] + Math.min( dp[i-1][j] , dp[i][j-1] );
            }
        }
        return dp[grid.length-1][grid[0].length-1];
        
        */

        // Tabulation with space optimization
        int rows = grid.length;
        int cols = grid[0].length;
        int[] prev = new int[cols];
        prev[0] = grid[0][0];
        for(int i = 1 ; i < cols; i++) {
            prev[i] = prev[i-1] + grid[0][i];
        }

        for(int row = 1 ; row < rows ; row++) {
            int[] curr = new int[cols];
            curr[0] = prev[0] + grid[row][0];

            for(int col = 1; col < cols ; col++) {
                curr[col] = grid[row][col] + Math.min(curr[col - 1] , prev[col]);
            }
            prev = curr;
        }
        return prev[cols - 1];
    }
}