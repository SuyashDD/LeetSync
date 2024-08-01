class Solution {
    public boolean eligible(int i , int j , int[][] vis , int[][] grid){
        if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length 
                && grid[i][j] != 0 && vis[i][j] == 0){
                    return true;
                }
                return false;
    }
    public int dfs(int i , int j , int[][] vis , int[][] grid){
        vis[i][j] = 1;
        int[] dx = {1 , 0 , -1 ,  0};
        int[] dy = {0 , 1 ,  0 , -1};
        int ans = 0;
        for(int k = 0 ; k < 4 ; k++){
            int newx = i + dx[k];
            int newy = j + dy[k];
            if(eligible(newx , newy , vis , grid)){
                ans = Math.max(ans , dfs(newx , newy , vis , grid));
            }
        }
        vis[i][j] = 0;
        return ans + grid[i][j];

    }
    public int getMaximumGold(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        for(int[] a : vis){
            Arrays.fill(a , 0);
        }
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] != 0){
                    ans = Math.max(ans , dfs(i , j , vis , grid));
                }
            }
        }
        return ans;
    }
}