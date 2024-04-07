package Ch9;

import java.util.Arrays;

public class Stopwatch {
    public static void main(String[] args){
        Stopwatch a = new Stopwatch();
        int[] sortTest = new int[100000];

        //获取随机数组，大小为100000
        for(int i = 0; i < sortTest.length; i++){
            sortTest[i] = (int)(Math.random() * 1000000);
        }

        a.start();
        selectionSort(sortTest);
        a.stop();
        long time = a.getElapsedTime();

        System.out.println("sort need " + time + "ms");
    }

    private long startTime = 0;
    private long endTime = 0;

    public Stopwatch(){
        startTime = System.currentTimeMillis();
    }

    public void start(){
        startTime = System.currentTimeMillis();
    }

    public void stop(){
        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime(){
        return (endTime - startTime);
    }

    /***
     * 选择排序
     * @param list
     */
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            // Find the minimum in the list[i..list.length-1]
            int currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary;
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
}
