class Solution {
    public int calc(int rows, int cols, int[][] obstacleGrid ,int[][] dp) {
        // base condition
        System.out.print("r -> " + rows + " c -> "+ cols + " ");
        if(rows < 0 || cols < 0) return 0;
        if(obstacleGrid[rows][cols] == 1) return 0;
        if(rows == 0 && cols == 0) return 1;


        // check 
        if(dp[rows][cols] != -1) return dp[rows][cols];

        // calc
        int up = calc(rows - 1, cols , obstacleGrid, dp);
        int left = calc(rows, cols - 1, obstacleGrid, dp);
        // System.out.print("l -> " + left + " , up ->" + up + " ");
        int res = left + up;

        // store and return
        dp[rows][cols] = res;
        return res;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[rows][cols];
        for(int[] a : dp) Arrays.fill(a , -1);

        return calc(rows - 1, cols - 1, obstacleGrid , dp);
        
    }
}