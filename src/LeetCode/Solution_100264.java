package LeetCode;

public class Solution_100264 {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int res = 0;

        while(right < n - 1){
            if(nums[right] >= nums[right + 1]){
                res = Math.max(res, right - left + 1);
                left = right + 1;
            }
            right++;
        }
        res = Math.max(res, right - left + 1);

        left = 0;
        right = 0;

        while(right < n - 1){
            if(nums[right] <= nums[right + 1]){
                res = Math.max(res, right - left + 1);
                left = right + 1;
            }
            right++;
        }
        res = Math.max(res, right - left + 1);
        return res;
    }
}
