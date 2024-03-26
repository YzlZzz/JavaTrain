import BasicStruct.TreeNode;
import javafx.util.Pair;

import java.awt.*;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);

    }

    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node.right != null) queue.offer(node.right);
            if(node.left != null) queue.offer(node.left);

            res = node.val;
        }
        return res;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        newRoot.left = mergeTrees(root1.left, root2.left);
        newRoot.right = mergeTrees(root1.right, root2.right);
        return newRoot;
    }

    public int minOperations(int k) {
        int n = 1;
        int x = 1;
        int sum = 0;
        int operations = 0;

        while (sum < k) {
            if (sum + n + 1 <= k) {
                sum = n * operations;
                n++;
            } else {
                sum = n * (operations + 1);
            }
            operations++;
        }

        return operations;
    }

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        Map<Integer, Long> frequencyMap = new HashMap<>();

        PriorityQueue<Pair<Long, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b.getKey(), a.getKey()));

        int n = nums.length;
        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {
            int id = nums[i];
            long change = frequencyMap.merge(id, (long) freq[i], Long::sum);

            maxHeap.offer(new Pair<>(change, id));

            while (!maxHeap.peek().getKey().equals(frequencyMap.get(maxHeap.peek().getValue()))) {
                maxHeap.poll();
            }

            ans[i] = maxHeap.peek().getKey();
        }
        return ans;
    }


    public int maximumLengthSubstring(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int max = 0;
        int len = 0;

        while (right < n) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while (map.get(arr[right]) > 2) {

                map.put(arr[left], map.getOrDefault(arr[left], 1) - 1);
                left++;
                len--;
            }
            right++;
            len++;
            max = max(max, len);
        }
        return max;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && max <= i) return false;
            max = max(max, i + nums[i]);
            if (max >= n) return true;
        }
        return true;
    }

    class Status {
        int iSum, lSum, rSum, mSum;

        public Status(int iSum, int lSum, int rSum, int mSum) {
            this.iSum = iSum;
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
        }
    }

    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] arr, int left, int right) {
        if (left == right) {
            int temp = arr[left];
            return new Status(temp, temp, temp, temp);
        }

        int m = (left + right) / 2;
        Status lSub = getInfo(arr, left, m);
        Status rSub = getInfo(arr, m + 1, right);
        return pushUp(lSub, rSub);
    }

    Status pushUp(Status left, Status right) {
        int iSum = left.iSum + right.iSum;
        int lSum = max(left.lSum, left.iSum + right.lSum);
        int rSum = max(right.rSum, right.iSum + left.rSum);
        int mSum = max(max(left.mSum, right.mSum), left.rSum + right.lSum);
        return new Status(iSum, lSum, rSum, mSum);
    }

    private boolean check(String s1, String s2) {
        int k = s1.length() / s2.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(s1);
        }
        return sb.toString().equals(s2);
    }

    char[] arr;

    public String longestPalindrome(String s) {
        int n = s.length();
        if (s.isEmpty()) {
            return "";
        }

        int start = 0;
        int end = 0;
        arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int l1 = expand(i, i);
            int l2 = expand(i, i + 1);

            int len = max(l1, l2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(int left, int right) {

        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            --left;
            ++right;
        }
        return right - left + 1;
    }

    public int minimumDeletions(String word, int k) {
        int n = word.length();
        int[] bucket = new int[26];
        for (char c : word.toCharArray()) {
            bucket[c - 'a']++;
        }
        Arrays.sort(bucket);

        int max = 0;

        for (int i = 0; i < 26; i++) {
            int temp = 0;
            for (int j = 0; j < 26; j++) {
                temp += min(bucket[j], bucket[i] + k);
            }
            max = max(temp, max);
        }
        return n - max;
    }

    public long countSubstrings(String s, char c) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int count = 0;

        for (char c1 : arr) {
            if (c1 == c) count++;
        }

        return (long) (count + 1) * count / 2;
    }

    public boolean isSubstringPresent(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        for (int i = 0; i < n - 1; i++) {
            char a1 = arr[i];
            char a2 = arr[i + 1];

            if (a1 == a2) return true;

            for (int j = i + 1; j < n - 1; j++) {
                char b1 = arr[j];
                char b2 = arr[j + 1];
                if (b1 == b2) return true;

                if (check(a1, a2, b1, b2)) return true;
            }
        }
        return false;
    }

    private boolean check(char a1, char a2, char b1, char b2) {
        if ((a1 == b1 || a1 == b2) && (a2 == b1 || a2 == b2)) return true;
        return false;
    }

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int[] checked = new int[n];
        long[] ans = new long[m];

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            } else {
                return x[0] - y[0];
            }
        });

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            pq.add(new int[]{nums[i], i});
        }

        for (int i = 0; i < m; i++) {
            int index = queries[i][0];
            int k = queries[i][1];

            if (checked[index] == 1) {
                sum -= nums[index];
                checked[index] = 1;
            }

            while (k > 0 && !pq.isEmpty()) {
                int[] temp = pq.poll();
                if (checked[temp[1]] == 0) {
                    sum -= temp[0];
                    checked[temp[1]] = 1;
                    k--;
                }
            }
            ans[i] = sum;
        }
        return ans;
    }

    public int sumOfEncryptedInt(int[] nums) {
        int count = 0;
        int max = 0;
        int sum = 0;

        for (int num : nums) {
            while (num > 0) {
                max = max(max, num % 10);
                num /= 10;
                count++;
            }
            num = 0;

            while (count > 0) {
                num = num * 10 + max;
                count--;
            }
            max = 0;
            sum += num;
        }
        return sum;
    }

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        StringBuilder sb = new StringBuilder();

        int max = max(n, m);
        int carry = 0;

        for (int i = 0; i < max; i++) {
            carry += i < n ? arr1[i] - 48 : 0;
            carry += i < m ? arr2[i] - 48 : 0;

            sb.append(carry % 10);
            carry /= 10;
        }
        if (carry > 0) sb.append(carry);

        return sb.reverse().toString();
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int n = haystack.length();
        int m = needle.length();

        haystack = " " + haystack;
        needle = " " + needle;

        char[] arr1 = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();

        int[] next = new int[m + 1];

        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && arr2[i] != arr2[j + 1]) {
                j = next[j];
            }

            if (arr2[i] == arr2[j + 1]) {
                j++;
            }
            next[i] = j;
        }

        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && arr1[i] != arr2[j + 1]) {
                j = next[j];
            }

            if (arr1[i] == arr2[j + 1]) {
                j++;
            }
            if (j == m) return i - m;
        }
        return -1;
    }

    public String licenseKeyFormatting(String s, int k) {
        char[] arr = s.toUpperCase().toCharArray();

        int n = 0;

        for (char c : arr) {
            if (c != '-') ++n;
        }

        n = n % k == 0 ? k : n % k;
        StringBuilder sb = new StringBuilder();

        for (char c : arr) {
            if (c != '-') {
                sb.append(c);
                n--;
            }
            if (n == 0) {
                sb.append('-');
                n = k;
            }
        }
        if (sb.charAt(sb.length() - 1) == '-') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;

        ++digits[n - 1];

        for (int i = n - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                ++digits[i - 1];
            } else {
                break;
            }
        }

        int[] res = new int[n + 1];

        if (digits[0] == 10) {
            digits[0] = 0;

            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, n);
        }
        return res[0] == 0 ? digits : res;

    }

    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int i = 0;
        int j = 0;

        while (j < m) {
            while (s.charAt(i) != t.charAt(j)) {
                if (++j == m) return false;
            }
            ++i;
            ++j;

            if (i == n) return true;
        }
        return false;
    }

    public String getHint(String secret, String guess) {
        char[] arr1 = secret.toCharArray();
        char[] arr2 = guess.toCharArray();
        int n = arr1.length;
        int[] bucket = new int[10];

        int a = 0;
        int b = 0;

        for (int i = 0; i < n; i++) {
            if (arr1[i] == arr2[i]) a++;
            else {
                bucket[arr1[i] - 48]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i] && bucket[arr2[i]] > 0) {
                b++;
                bucket[arr2[i]]--;
            }
        }

        return a + "A" + b + "B";
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] bucket = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            bucket[ransomNote.charAt(i) - 97]++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            bucket[magazine.charAt(i)]--;
        }

        for (int i = 0; i < 26; i++) {
            if (bucket[i] >= 1) return false;
        }
        return true;
    }

    public char findTheDifference(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int n = arr1.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr2[i];
            sum -= arr1[i];
        }
        sum += arr2[n];

        return (char) sum;
    }

    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] sumAns = new String[n];

        for (int i = 0; i < n; i++) {
            int m = arr[i].length();
            String ans = "";

            for (int size = 1; size < m && ans.isEmpty(); size++) {
                for (int j = size; j <= m; j++) {
                    String temp = arr[i].substring(j - size, j);
                    if ((ans.isEmpty() || temp.compareTo(ans) < 0) && check(arr, i, temp)) {
                        ans = temp;
                    }
                }
            }
            sumAns[i] = ans;
        }
        return sumAns;
    }

    private boolean check(String[] arr, int i, String substring) {
        for (int j = 0; j < arr.length; j++) {
            if (j != i && arr[j].contains(substring)) return false;
        }
        return true;
    }

    public int firstUniqChar(String s) {
        char[] array = s.toCharArray();

        int[] bucket = new int[26];

        for (char c : array) {
            bucket[c - 97]++;
        }

        for (int i = 0; i < array.length; i++) {
            if (bucket[array[i] - 97] == 1) return i;
        }
        return -1;
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long sum = 0;
        int n = happiness.length;

        for (int i = 0; i < k; ++i) {
            int temp = happiness[n - i - 1] - i;
            sum += (temp > 0 ? temp : 0);
        }
        return sum;
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int i : apple) {
            sum += i;
        }

        Arrays.sort(capacity);
        int m = capacity.length;

        for (int i = m - 1; i >= 0; i--) {
            sum -= capacity[i];
            if (sum <= 0) return m - i;
        }
        return m;
    }

    public String reverseWords(String s) {
        StringBuilder sb = trimSpace(s);

        reverse(sb, 0, sb.length() - 1);

        reverseWord(sb);
        return sb.toString();
    }

    public StringBuilder trimSpace(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        StringBuilder sb = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }

    private void reverseWord(StringBuilder sb) {
        int n = sb.length();
        int left = 0;
        int right = 0;

        while (left < n) {
            while (right < n && sb.charAt(right) != ' ') {
                ++right;
            }

            reverse(sb, left, right - 1);

            left = ++right;
        }
    }

    public String reverseWords1(String s) {
        int n = s.length();

        char[] array = s.toCharArray();
        int left = 0;
        int right = 0;

        while (right < n) {
            while (array[left] == ' ') {
                left++;
            }
            while (right < n && array[right] != ' ') {
                right++;
            }
            reverse(array, left, right - 1);
            left = right;
            right += 1;
        }
        return new String(array);
    }

    public String reverseStr(String s, int k) {
        int n = s.length();

        char[] array = s.toCharArray();

        for (int i = 0; i < n; i += 2 * k) {
            reverse(array, i, min(i + k, n) - 1);
        }
        return new String(array);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            array[left] ^= array[right];
            array[right] ^= array[left];
            array[left] ^= array[right];
            --right;
            ++left;
        }
    }

    private int ceil(int a, int b) {
        int k = a / b;
        return a % b == 0 ? k : k + 1;
    }

    public void reverseString(char[] s) {
        int n = s.length;

        for (int left = 0, right = n - 1; left < right; ++right, ++left) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    public int lengthOfLastWord(String s) {
        int n = s.length() - 1;
        int temp = 0;

        while (n > 0) {
            if (s.charAt(n) != ' ') {
                temp = n;
                break;
            }
            n--;
        }

        while (temp > 0) {
            if (s.charAt(temp) == ' ') {
                break;
            }
            temp--;
        }
        return n - temp;
    }

    public int countSegments(String s) {
        String[] ans = s.split(" ");
        int count = 0;
        for (String an : ans) {
            if (!an.isEmpty()) count++;
        }
        return count;
    }

    public String longestCommonPrefix(String[] strs) {

        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            ans = commonPrefix(ans, strs[i]);
        }

        return ans;
    }

    private String commonPrefix(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = min(a.length(), b.length());

        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                sb.append(a.charAt(i));
            } else break;
        }

        return sb.toString();
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        return s.contentEquals(new StringBuilder(s).reverse());
    }

    public boolean detectCapitalUse(String word) {
        int len = word.length();

        if (len == 1) return true;

        if (word.charAt(0) < 91) {
            int upper = 0, lower = 0;
            for (int i = 1; i < len; i++) {
                if (word.charAt(i) < 91) {
                    upper++;
                } else {
                    lower++;
                }
                if (lower > 0 && upper > 0) return false;
            }
        } else {
            for (int i = 1; i < len; i++) {
                if (word.charAt(i) < 91) return false;
            }
        }

        return true;
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, pre = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == 1) pre++;
            else pre--;

            if (map.containsKey(pre)) {
                max = max(max, i - map.get(pre));
            } else map.put(pre, i);
        }
        return max;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return false;

        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        map.put(0, -1);

        for (int i = 0; i < len; i++) {
            pre = (pre + nums[i]) % k;
            if (map.containsKey(pre)) {
                int index = map.get(pre);
                if (i - index > 1) return true;
            } else {
                map.put(pre, i);
            }
        }
        return false;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0, pre = 0;
        map.put(0, 1);

        for (int num : nums) {
            pre += num;

            int temp = pre - k;
            if (map.containsKey(temp)) {
                count += map.get(temp);
            }

            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int sum = n1 + n2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;

        for (int n3 : nums3) {
            for (int n4 : nums4) {
                int sum = n3 + n4;
                if (map.containsKey(sum)) res += map.get(sum);
            }
        }
        return res;
    }

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++) {
                String[] name_cont = values[i].split("\\(");
                name_cont[1] = name_cont[1].replace(")", "");

                List<String> list = map.getOrDefault(name_cont[1], new ArrayList<>());
                list.add(values[0] + "/" + name_cont[0]);
                map.put(name_cont[1], list);
            }
        }

        List<List<String>> res = new ArrayList<>();

        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            if (stringListEntry.getValue().size() > 1) res.add(stringListEntry.getValue());
        }
        return res;
    }

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();

        for (List<Integer> list : wall) {
            int n = list.size();
            int sum = 0;

            for (int i = 0; i < n - 1; i++) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int max = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = max(max, entry.getValue());
        }

        return wall.size() - max;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i1 = 0, i2 = 0;
        int len1 = nums1.length, len2 = nums2.length;

        int[] intersection = new int[min(len1, len2)];
        int i = 0;

        while (i1 < len1 && i2 < len2) {
            int n1 = nums1[i1], n2 = nums2[i2];
            if (n1 < n2) {
                i1++;
            } else if (n1 > n2) {
                i2++;
            } else {
                intersection[i++] = n1;
                i1++;
                i2++;
            }
        }
        return Arrays.copyOf(intersection, i);
    }

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer i : map.keySet()) {
            if (map.containsKey(i + 1)) {
                res = max(res, map.get(i) + map.get(i + 1));
            }
        }
        return res;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && abs(i - map.get(nums)) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }


        for (int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            if (map.containsKey(gap)) {
                if (map.get(gap) != i) return new int[]{map.get(gap), i};
            }
        }
        return new int[0];
    }

    private int[] get(int a, int b) {
        return a < b ? new int[]{a, b} : new int[]{b, a};
    }


    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node node = head;
        while (node != null) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;

            node = node.next.next;
        }

        node = head;
        while (node != null) {
            Node newnode = node.next;
            newnode.random = (node.random == null) ? null : node.random.next;
            node = node.next.next;
        }

        node = head;
        Node headNew = head.next;
        while (node != null) {
            Node newnode = node.next;
            node.next = node.next.next;
            newnode.next = (newnode.next == null) ? null : newnode.next.next;
        }
        return headNew;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        int len = s.length();
        if (len != t.length()) return false;

        for (int i = 0; i < len; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (s2t.containsKey(ch1) && s2t.get(ch1) != ch2) {
                return false;
            }
            if (t2s.containsKey(ch2) && t2s.get(ch2) != ch1) {
                return false;
            }
            s2t.put(ch1, ch2);
            t2s.put(ch2, ch1);
        }
        return true;
    }

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, y = 0, res = 0;
        for (int x = 0; x < n; x++) {
            if (x == 0 || nums[x] != nums[x - 1]) {
                while (y < n && (nums[y] < nums[x] + k || y <= x)) {
                    y++;
                }
                if (y < n && nums[y] == nums[x] + k) {
                    res++;
                }
            }
        }
        return res;
    }

    private static int abs(int a) {
        return a > 0 ? a : -a;
    }

    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> str2ch = new HashMap<>();
        Map<Character, String> ch2str = new HashMap<>();

        int m = pattern.length();
        int index = 0;

        String[] strings = s.split(" ");
        int n = strings.length;

        if (m != n) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String string = strings[i];

            if (str2ch.containsKey(string) && str2ch.get(string) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !string.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(string, ch);
            ch2str.put(ch, string);
        }
        return true;
    }

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;
        int temp = 0;

        for (int i = 1; i < nums.length; i++) {
            int gap = nums[i] - nums[i - 1];
            if (gap > 1) {
                ans = max(ans, temp);
                temp = 0;
            } else if (gap == 1) {
                temp++;
            }
        }
        ans = max(ans, temp);
        return ans + 1;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (Integer n : nums1) {
            set1.add(n);
        }

        for (int n : nums2) {
            set2.add(n);
        }
        return getIntersection(set1, set2);
    }

    private int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getIntersection(set2, set1);
        }

        Set<Integer> intersectionSet = new HashSet<>();

        for (Integer i : set1) {
            if (set2.contains(i)) intersectionSet.add(i);
        }

        int[] intersection = new int[intersectionSet.size()];
        int index = 0;

        for (int i : intersectionSet) {
            intersection[index++] = i;
        }
        return intersection;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();

        for (int i : nums) {
            if (!s.add(i)) {
                return true;
            }
        }
        return false;
    }
}
