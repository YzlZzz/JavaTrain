package LeetCode;

import java.util.Arrays;

public class Solution_100242 {

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int median = n % 2 == 0 ? n / 2 + 1 : n / 2;

        return 0L;
    }
}
