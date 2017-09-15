package utils;

import java.util.Random;
import java.util.function.Consumer;

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
            array[i] = i;
        }
        //swap
        for (int i = 0; i < swapTimes; i++) {
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
    public static void printSortTime(int[] array, Consumer<int[]> sort, String sortName) {
        long start = System.nanoTime();
        sort.accept(array);
        long end = System.nanoTime();
        if (isSort(array)) {
            double time = ((double) (end - start)) / (Math.pow(10, 6));
            System.out.println(sortName + "\t算法花费时间为:" + time + "毫秒");
        } else System.out.println("该数组不是有序的!请检查排序算法~");
    }

    /**
     * 检查一个数组是否有序
     *
     * @param array 待检查的数组
     * @return 检查结果
     */
    private static boolean isSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
