package Ch8;
import java.util.Arrays;

public class ComputeWorkHours {
    public static void main(String[] args){
        int[][] workHours= {{2,4,3,4,5,8,8},{7,3,4,3,3,4,4},{3,3,4,3,3,2,2},{9,3,4,7,3,4,1},{3,5,4,3,6,3,8},{3,4,4,6,3,4,4},{3,7,4,8,3,8,4},{6,3,5,9,2,7,9}};
        int[] hours = sumHours(workHours);

        Arrays.sort(hours);

        printHours(hours);
    }

    /***
     * 将一个人的一周工作量相加，并放入依次一维数组中
     * @param workHours
     * @return
     */
    public static int[] sumHours(int[][] workHours){
        int[] hours = new int[workHours.length];

        for(int i = 0; i < workHours.length; i++){
            for(int j = 0; j < workHours[i].length; j++){
                hours[i] += workHours[i][j];
            }
        }
        return hours;
    }

    /***
     * 将汇总的工作时间排序后，以降序输出
     * @param a
     */
    public  static void printHours(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[a.length - i -1] + " ");
        }
    }
}
