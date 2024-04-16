package Interview;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


/**
 * 小红书笔试第二题，博客有点赞数和评论数，在n篇博客中选取k篇，使得评分最高。
 * 评分规则：选取的博客中的点赞数之和与评论数最小值的乘积。
 * 例子：n=4, k=2
 * 点赞：[1,2,3,4]
 * 评论数： [4,3,2,1]
 * 最大评分：10（选取第二篇与第三篇）
 */
public class Xhs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        Note[] notes = new Note[n];

        for (int i = 0; i < n; i++) {
            int good = in.nextInt();
            notes[i] = new Note(good);
        }
        for (int i = 0; i < n; i++) {
            notes[i].comment = in.nextInt();
        }

        Arrays.sort(notes, (a, b) -> a.comment - b.comment);

        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        int ans = 0;

        for(int i = n - k; i < n; i++){
            int temp = notes[i].good;
            sum += temp;
            pq.offer(temp);
        }
        ans = notes[n-k].comment * sum;

        for(int i = n - k - 1; i >= 0; i--){
            sum -= pq.poll();

            Note temp = notes[i];
            sum += temp.good;

            ans = Math.max(ans, temp.comment * sum);
        }
        System.out.println(ans);
    }
}

class Note{
    int good;
    int comment;

    Note(int good){
        this.good = good;
    }
}
