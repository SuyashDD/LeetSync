class Solution {
    public int calc(int t1ind , int t2ind , String t1, String t2, int[][] dp){
        // base case
        if(t1ind < 0 | t2ind < 0) return 0;
        

        // check
        if(dp[t1ind][t2ind] != -1) return dp[t1ind][t2ind];

        // calc

        // match
        int res = 0;
        if(t1.charAt(t1ind) == t2.charAt(t2ind)){
            res = 1 + calc(t1ind - 1 , t2ind - 1 , t1 , t2 , dp);
        }
        else{
            int r1 = calc(t1ind - 1 , t2ind , t1 , t2 , dp);
            int r2 = calc(t1ind , t2ind - 1 , t1 , t2 , dp);
            res = Math.max(r1 , r2);
        }

        dp[t1ind][t2ind] = res;
        return res;






    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] a : dp) {
            Arrays.fill(a , -1);
        }

        return calc(text1.length()  - 1, text2.length() - 1 , text1, text2, dp);
        
    }
}