package utils;

import java.util.Random;
import java.util.function.Consumer;

@SuppressWarnings("Duplicates")
public class SortUtil {

    private static double originalTimes;

    /**
     * 交换数组中两个元素的位置
     *
     * @param a a
     * @param b b
     */
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    /**
     * 获得一个随机数组,可以指定随机范围
     *
     * @param n           数组长度
     * @param randomRange 数组内元素的随机范围
     * @return
     */
    public static int[] getRandomArray(int n, int randomRange) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(randomRange);
        }
        return array;
    }

    /**
     * 获得一个随机数组,随机范围为0~数组长度
     *
     * @param n 数组长度
     * @return
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
     * 算法计算时间的辅助函数(方法为Consumer类型的)
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
        checkArrayIsSortedAndPrintTimes(array, sortName, start, end);
    }


    /**
     * int[] -> integer[]
     * @param arr
     * @return
     */
    public static Integer[] intArrayToInetegerArray(int[] arr) {
        Integer[] returnArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            returnArr[i] = arr[i];
        }
        return returnArr;
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

    /**
     * 内部方法,检查一个数组是否有序并且打印出排序消耗时间
     *
     * @param array
     * @param sortName
     * @param start
     * @param end
     */
    private static void checkArrayIsSortedAndPrintTimes(int[] array, String sortName, long start, long end) {
        if (isSort(array)) {
            originalTimes = (end - start);
            double millisecond = originalTimes / (Math.pow(10, 6));
            double second = originalTimes / Math.pow(10, 9);
            System.out.println(sortName + "\t算法花费时间为:" + millisecond + "ms(毫秒),约合" + second + "s(秒)");
        } else System.out.println("该数组不是有序的!请检查排序算法~");
    }


    public static void printSortTimeObj(Integer[] array, Consumer<Integer[]> sort, String sortName) {
        long start = System.nanoTime();
        sort.accept(array);
        long end = System.nanoTime();
        checkArrayIsSortedAndPrintTimes(array, sortName, start, end);
    }

    private static boolean isSort(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void checkArrayIsSortedAndPrintTimes(Integer[] array, String sortName, long start, long end) {
        if (isSort(array)) {
            originalTimes = (end - start);
            double millisecond = originalTimes / (Math.pow(10, 6));
            double second = originalTimes / Math.pow(10, 9);
            System.out.println(sortName + "\t算法花费时间为:" + millisecond + "ms(毫秒),约合" + second + "s(秒)");
        } else System.out.println("该数组不是有序的!请检查排序算法~");
    }
}
