class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0 ; i < n - 2 ; i ++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1;
            int k = n - 1;

            while(j < k){
                int curr = nums[i] + nums[j] + nums[k];

                if(curr == 0) {
                    ans.add(Arrays.asList(nums[i] , nums[j] , nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--; 

                }
                else if(curr > 0) {
                    k--;
                    while(j < k && nums[k] == nums[k+1]){
                        k--;
                    }
                }
                else{
                    j++;
                    while(j < k && nums[j] == nums[j - 1]){
                        j++;
                    }
                }
            }

        }
            return ans;
    }
}