package sort;

import java.util.Arrays;

import static utils.SortUtil.getRandomArray;
import static utils.SortUtil.getRandomArrayNearlyOrder;
import static utils.SortUtil.printSortTime;

public class MergeSort {
    public static void main(String[] args) {
        int n = 20000;
        int[] arr = getRandomArray(n, 50000);
        int[] arr02 = Arrays.copyOf(arr, n);
        int[] arr03 = Arrays.copyOf(arr, n);
        int[] arr04 = Arrays.copyOf(arr, n);
        int[] arr05 = Arrays.copyOf(arr, n);
        printSortTime(arr, MergeSort::mergeSort, "mergeSort");
        printSortTime(arr02, SelectionSort::selectionSort, "selectionSort");
        printSortTime(arr03, InsertionSort::insertionSort, "insertionSort");
        printSortTime(arr04, InsertionSort::insertionSortOpt, "insertionSortOpt");
        printSortTime(arr05, BucketSort::bucketSort, "bucketSort");

    }

    public static void mergeSort(int[] arr) {
        __mergeSort(arr, 0, arr.length - 1);
    }

    //对范围arr[l,r]的范围内的数组进行归并排序
    private static void __mergeSort(int[] arr, int l, int r) {
        //设置结束条件
        if (l >= r) {
            return;
        }
        //分成[l,middle] 与[middle+1, r]两组,分别进行归并排序
        int middle = (l + r) / 2;
        __mergeSort(arr, l, middle);
        __mergeSort(arr, middle + 1, r);
        //对这两组进行归并
        __merge(arr, l, middle, r);
    }

    //对范围arr[l,middle] 与[middle+1,r] 两部分进行归并
    private static void __merge(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

}


