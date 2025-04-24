class Solution {
    public static void swap(int[] arr, int index1, int index2) {
    int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while(mid <= right){
            if(nums[mid] == 0){
                swap(nums , mid , left);
                left++;
                mid++;
            }
            else if(nums[mid] == 2){
                swap(nums , mid , right);
                right--;
            }
            else{
                mid++;
            }
        }
    }
}