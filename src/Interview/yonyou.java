package Interview;

import java.util.*;

public class yonyou {


}

class Solution1 {

    static int n;

    static List<Integer>[] adj;

    static Set<Integer> set;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();

        adj = new List[n];
        set = new HashSet<>();
        in.nextLine();
        int end = -1;

        //邻接矩阵的构造
        for (int i = 0; i < n; i++) {
            String[] temp = in.nextLine().split(" ");
            adj[i] = new ArrayList<>(temp.length);

            for (String s : temp) {
                Integer val = Integer.parseInt(s);
                if (val == -1) {
                    end = val;
                    set.add(i);
                }
                adj[i].add(val);
            }
        }

        boolean p = true;

        while(p) {
            p = false;
            for (int i = 0; i < n; i++) {
                if(set.contains(i)) continue;

                if (check(i)) {
                    set.add(i);
                    p = true;
                }
            }
        }

        List<Integer> ans = new ArrayList<>(set);
        ans.sort(null);
        for (Integer a : ans) {
            System.out.print(a + " ");
        }
    }

    //检查一个工序指向的是否全是合规工序
    private static boolean check(int i){
        for (Integer j : adj[i]) {
            if(!set.contains(j)) return false;
        }
        return true;
    }
}

class Solution2 {

    static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner in = new Scanner(System.in);

        long upLimit = in.nextInt();
        long sum = in.nextInt();

        long ans = dfs(sum, 1);
        // 161 14
        System.out.println(ans > upLimit);
    }

    private static long dfs(long num, long mul){
        //num 为1或为0时直接返回
        if(num == 0 || num == 1) return mul;

        //如果已经计算过，就直接返回
        if(memo.containsKey(num)) return memo.get(num) * mul;

        long max = num * mul;
        for(int i = 1; i < num; i++){
            max = Math.max(max, dfs(num - i, mul * i));
        }
        memo.put(num, max / mul);
        return max;
    }
}
