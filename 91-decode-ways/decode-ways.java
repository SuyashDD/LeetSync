class Solution {
    public int calc(int index , String s , int[] dp) {
        if(dp[index] != -1) {
            return dp[index];
        }

        if(s.charAt(index) == '0') {
            dp[index] = 0;
            return 0;
        }
        
        // calc
        int res = calc(index + 1 , s , dp);

        // calc for i + 2
        if(index + 1 < s.length() 
            && ( s.charAt(index) == '1' || 
                (s.charAt(index) == '2' && s.charAt(index + 1) <= '6') )
        ){
            res += calc(index + 2 , s , dp);
        }

        dp[index] = res;
        return res;
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];

        Arrays.fill(dp , -1);
        dp[s.length()] = 1;

        return calc(0 , s , dp);
    }
}