class Solution {
    public boolean eligible(int i , int j , int[][] vis , int[][] grid){
        if(i >= 0 && j >= 0 
            && i < grid.length
            && j < grid[0].length
            && vis[i][j] == 0
            && grid[i][j] != 0){
                return true;
            }
            return false;

    }

    public int dfs(int i , int j , int[][] vis , int[][] grid){
        vis[i][j] = 1;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int curr_ans = 0;
        for(int k = 0 ; k < 4 ; k++){
            int ni = i + dx[k];
            int nj = j + dy[k];

            if(eligible(ni , nj , vis , grid)){
                curr_ans = Math.max(curr_ans , dfs(ni , nj , vis , grid));
            }
        }
        vis[i][j] = 0;
        return grid[i][j] + curr_ans;
    }
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        
        
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j  = 0 ; j < m ; j++){
                if(grid[i][j] != 0){
                    int tans = dfs(i , j , vis , grid);
                    ans = Math.max(ans , tans);
                }
            }
        }
        return ans;
    }
}