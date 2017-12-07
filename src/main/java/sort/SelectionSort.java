package main.java.sort;

import static main.java.utils.SortUtil.swap;

@SuppressWarnings("WeakerAccess")
public class SelectionSort {
    /**
     * 选择排序算法
     *
     * @param array
     */
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            // 寻找[i,0)区间里的最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) swap(array, i, minIndex);
        }
    }
}
