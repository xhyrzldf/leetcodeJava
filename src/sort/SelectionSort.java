package sort;

import static utils.SortUtil.*;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = getRandomArray(100);
        printSortTime(array, SelectionSort::selectionSort, "selectionSort");
    }

    /**
     * 选择排序算法
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
            swap(array, i, minIndex);
        }
    }
}
