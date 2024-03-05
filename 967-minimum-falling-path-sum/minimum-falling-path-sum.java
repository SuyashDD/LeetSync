class Solution {
    // Memoization
    /*
    public int calc(int rows , int cols , int[][] mat , int[][] dp) {
        // base
        if(rows < 0 || cols < 0 || cols >= mat[0].length) return Integer.MAX_VALUE;
        if(rows == 0) return mat[rows][cols];

        // check
        if(dp[rows][cols] != Integer.MAX_VALUE) return dp[rows][cols];

        // calc
        int t1 = calc(rows - 1, cols + 1, mat, dp);
        int t2 = calc(rows - 1, cols, mat , dp);
        int t3 = calc(rows - 1, cols - 1, mat , dp);
        int res = mat[rows][cols] + Math.min(t1 , Math.min(t2 , t3));

        // store and return
        dp[rows][cols] = res;
        return res;
    }
    */

    public int minFallingPathSum(int[][] matrix) {
        /* Memoization -
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] a : dp) Arrays.fill(a , Integer.MAX_VALUE);

        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i < cols ; i++) {
            int temp = calc(rows - 1, i , matrix, dp);
            res = Math.min(res , temp);
        }
        return res;
        */

        // Tabulation
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < cols ; i++) {
            dp[0][i] = matrix[0][i];
        }

        for(int r = 1 ; r < rows ; r++) {
            for(int c = 0 ; c < cols ; c++) {
                int t1 = Integer.MAX_VALUE;
                int t3 = Integer.MAX_VALUE;
                if(c-1 >= 0) {
                    t1 = dp[r-1][c-1] ;
                }
                if(c+1 < cols) {
                    t3 = dp[r-1][c+1];
                }
                int t2 = dp[r-1][c];
                dp[r][c] = matrix[r][c] + Math.min(t1 , Math.min(t2,t3));

            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i < cols ; i++) {
            res = Math.min(res , dp[rows - 1][i]);
        }
        return res;


    }
}