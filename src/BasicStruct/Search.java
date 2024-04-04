package BasicStruct;

import java.util.HashMap;
import java.util.Map;

public class Search {

    public static int binarySearch(int[] nums, int target){
        int i = 0;
        int j = nums.length - 1;
        while(i <= j){
            int m = i + (j - i) / 2;

            if(nums[m] < target) i = m + 1;
            else if(nums[m] > target) j = m - 1;
            else return m;
        }
        return -1;
    }

    public static int binarySearchInsert(int[] nums, int target){
        int i = 0;
        int j = nums.length - 1;

        while(i <= j){
            int m = i + (j - i) / 2;

            if(nums[m] < target) i = m + 1;
            else if (nums[m] > target) j = m - 1;
            else return m;

        }
        return i;
    }

    public static int[] twoSumHashTable(int[] nums, int target){
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
