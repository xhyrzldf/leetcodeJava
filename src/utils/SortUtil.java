package utils;

import java.util.Random;
import java.util.function.Function;

public class SortUtil {

    /**
     * 交换数组中两个元素的位置
     *
     * @param a a
     * @param b b
     */
    public static int[] swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        return array;
    }

    /**
     * 获得随机数组
     *
     * @param n 数组长度
     * @return 随机数组
     */
    public static int[] getRandomArray(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n);
        }
        return array;
    }

    /**
     * 获得一个近乎有序的数组
     *
     * @param n         数组长度
     * @param swapTimes 交换次数
     * @return 近乎有序的数组
     */
    public static int[] getRandomArrayNearlyOrder(int n, int swapTimes) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(n);
        }
        //swap
        for (int i = 0; i < array.length; i++) {
            int randomPoi = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPoi];
            array[randomPoi] = temp;
        }
        return array;
    }

    /**
     * 算法计算时间的辅助函数
     *
     * @param array    传入的数组
     * @param sort     算法方法
     * @param sortName 算法名称
     * @return 排序好的数组
     */
    public static int[] printSortTime(int[] array, Function<int[], int[]> sort, String sortName) {
        long start = System.nanoTime();
        array = sort.apply(array);
        long end = System.nanoTime();
        System.out.println(end - start);
        double time = ((double) (end - start)) / (Math.pow(10, 6));
        System.out.println(sortName + "\t算法花费时间为:" + time + "毫秒");
        return array;
    }

}
