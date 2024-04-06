package BasicStruct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Sort {

    /**
     * 选择排序，时间复杂度O(n^2)，空间复杂度O(1)
     * 非稳定排序
     */
    public static void selectSort(int[] nums){
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(nums[j] < nums[minIndex]) minIndex = j;
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }


    /**
     * 冒泡排序，时间复杂度O(n^2)，空间复杂度O(1)
     * 稳定排序
     */
    public static void bubbleSort(int[] nums){
        for (int i = nums.length - 1; i >= 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
                if(!flag) break;
            }
        }
    }

    /**
     * 插入排序，时间复杂度O(n^2)，空间复杂度O(1)
     * 稳定排序
     */
    public static void insertionSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int base = nums[i];
            int j = i - 1;

            while(j >= 0 && nums[j] > base){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
    }

    /**
     * 快速排序，时间复杂度O(nlogn)，空间复杂度O(n)，尾递归优化后空间复杂度为O(logn)
     * 非稳定排序
     */
    public static void quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int left, int right){
        if(left >= right) return;

        while (left < right) {
            int pivot = partition(nums, left, right);

            if (pivot - left < right - pivot) {
                quickSort(nums, left, pivot - 1);
                left = pivot + 1;
            } else {
                quickSort(nums, pivot + 1, right);
                right = pivot - 1;
            }
        }

    }

    private static int partition(int[] nums, int left, int right){
        int median = medianThree(nums, left, (left + right) / 2, right);
        swap(nums, left, right);

        int i = left;
        int j = right;

        while(i < j){
            while (i < j && nums[j] >= nums[left]) j--;
            while (i < j && nums[i] <= nums[left]) i++;
            swap(nums, i, j);
        }
        swap(nums, left, i);
        return i;
    }

    private static int medianThree(int[] nums, int left, int median, int right){
        if((nums[left] < nums[median]) ^ (nums[left] < nums[right])){
            return left;
        }else if((nums[median] < nums[left]) ^ (nums[median] < nums[right])){
            return median;
        }else return right;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    /**
     * 归并排序，时间复杂度O(nlogn)，空间复杂度O(n)
     * 稳定排序
     */
    public static void mergeSort(int[] nums){
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int left, int right){
        if(left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);


    }

    private static void merge(int[] nums, int left, int mid, int right){
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right){
            if(nums[i] < nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }

        while (i <= mid){
            temp[k++] = nums[i++];
        }

        while (j <= right){
            temp[k++] = nums[j++];
        }

        for (int i1 = 0; i1 < temp.length; i1++) {
            nums[left + i1] = temp[i1];
        }
    }

    /**
     * 堆排序，时间复杂度O(nlogn)，空间复杂度O(1)
     * 非稳定排序
     */
    public static void heapSort(int[] nums){
        for(int i = nums.length / 2 - 1; i >= 0; i--){
            siftDown(nums, nums.length, i);
        }

        for(int i = nums.length - 1; i > 0; i--){
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            siftDown(nums, i, 0);
        }
    }

    private static void siftDown(int[] nums, int n, int i){
        while(true){
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int max = i;

            if(l < n && nums[l] > nums[max]) max = l;
            if(r < n && nums[r] > nums[max]) max = r;
            if(max == i) break;

            int temp = nums[i];
            nums[i] = nums[max];
            nums[max] = temp;

            i = max;
        }
    }

    /**
     * 桶排序，时间复杂度O(n+k)，空间复杂度O(n+k)
     * 稳定与否取决于桶内排序算法
     */
    public void bucketSort(float[] nums){
        int k = nums.length / 2;
        List<List<Float>> bucket = new ArrayList<>(k);

        for (int i = 0; i < k; i++) {
            bucket.add(new ArrayList<>());
        }

        for (float num : nums) {
            int base = (int) (num * k);
            bucket.get(base).add(num);
        }

        for (List<Float> floats : bucket) {
            Collections.sort(floats);
        }

        int i = 0;
        for (List<Float> floats : bucket) {
            for (Float f : floats) {
                nums[i++] = f;
            }
        }
    }

    /**
     * 计数排序，特殊的桶排序，时间复杂度O(n+m),空间复杂度O(n+m)
     * 稳定排序
     */
    public void countingSort(int[] nums){
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }

        for(int i = 0; i < max; i++){
            count[i + 1] += count[i];
        }

        int n = nums.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            res[count[num] - 1] = num;
            count[num]--;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }
}
