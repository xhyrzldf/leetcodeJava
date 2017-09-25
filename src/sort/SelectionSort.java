package sort;

import java.util.Arrays;

import static utils.SortUtil.*;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = getRandomArrayNearlyOrder(100000, 0);
        int[] array01 = Arrays.copyOf(array, 100000);
        printSortTime(array, SelectionSort::selectionSort, "selectionSort");
        printSortTime(array, InsertionSort::insertionSortOpt, "insertSort");
    }

    /**
     * 选择排序算法
     *
     * @param array
     */
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            //寻找[i,0)区间里的最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i)
                swap(array, i, minIndex);
        }
    }
}
