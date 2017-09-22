package sort;

import java.util.Arrays;

import static utils.SortUtil.*;

public class InsertionSort {

    public static void main(String[] args) {
        final int[] array = getRandomArrayNearlyOrder(1000000, 10);
        final int[] array02 = Arrays.copyOf(array, array.length);
        final int[] array03 = Arrays.copyOf(array, array.length);
        printSortTime(array, SelectionSort::selectionSort, "选择排序");
        printSortTime(array02, InsertionSort::insertionSort, "插入排序");
        printSortTime(array03, InsertionSort::insertionSortOpt, "优化插入排序");
    }

    /**
     * 插入排序算法,原始版本,使用交换
     * @param array
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //寻找元素array[i]合适的插入位置
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array, j, j - 1);
            }
        }
    }

    /**
     * 优化插入排序减少了交换的次数
     */
    public static void insertionSortOpt(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //寻找array[i]合适的插入位置
            int e = array[i];
            int j; // j保存e应该插入的位置
            for (j = i; j > 0 && array[j - 1] > e; j--) {
                array[j] = array[j - 1];
            }
            array[j] = e;
        }
    }

    /**
     * 对一个数组arr[l,r]范围内的数字进行插入排序
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void insertionSortForOpt(int[] arr, int l, int r) {
        //对范围arr[l,r] 进行插入排序
        for (int i = l + 1; i <= r; i++) {
            //寻找arr[i]合适的插入位置
            int e = arr[i];
            int j;//j表示arr[i]合适的插入位置
            for (j = i; j > l && arr[j - 1] > e; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
}
