class Solution {
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
    public int minFallingPathSum(int[][] matrix) {
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

    }
}