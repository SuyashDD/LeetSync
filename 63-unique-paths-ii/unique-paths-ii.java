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

        // int[][] dp = new int[rows][cols];
        // for(int[] a : dp) Arrays.fill(a , -1);

        // return calc(rows - 1, cols - 1, obstacleGrid , dp);
        int[] prev = new int[cols];
        prev[0] = 1;
        for(int i = 1 ; i < cols; i++) {
            if(obstacleGrid[0][i] != 1 && prev[i - 1] != 0) {
                prev[i] = 1;
            }
            else{
                prev[i] = 0;
            }
        }
        // System.out.print(" Prev -> ");
        // for(int i : prev) System.out.print(" " + i + " ");

        for(int row = 1; row < rows; row++){
            int[] curr = new int[cols];
            if(prev[0] == 1 && obstacleGrid[row][0] == 0) {
                curr[0] = 1;
            }
            else{
                curr[0] = 0;
            }

            for(int col = 1 ; col < cols; col++){
                if(obstacleGrid[row][col] == 1){
                    curr[col] = 0;
                }
                else{
                    curr[col] = curr[col - 1] + prev[col];
                }
            }
            
            System.out.print(" Prev -> ");
            for(int i : prev) System.out.print(" " + i + " ");
            System.out.print(" Curr -> ");
            for(int i : curr) System.out.print(" " + i + " ");

            System.out.print("\n");
            prev = curr;
        }
        return prev[prev.length - 1];

    }
}