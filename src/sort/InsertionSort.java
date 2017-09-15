package sort;

import java.util.Arrays;

import static utils.SortUtil.*;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = getRandomArrayNearlyOrder(10000, 10);
        int[] array02 = Arrays.copyOf(array, array.length);
        int[] array03 = Arrays.copyOf(array, array.length);
        printSortTime(array, SelectionSort::selectionSort, "选择排序");
        printSortTime(array02, InsertionSort::insertionSort, "插入排序");
        printSortTime(array03, InsertionSort::insertionSortOpt, "优化插入排序");
    }

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
        for (int i = 0; i < array.length; i++) {
            //寻找array[i]合适的插入位置
            int e = array[i];
            int j = i; // j保存e应该插入的位置
            for (j = i; j > 0 && array[j - 1] > e; j--) {
                array[j] = array[j - 1];
            }
            array[j] = e;
        }
    }
}