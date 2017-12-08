package test;

import sort.HeapSort;
import sort.MergeSort;
import sort.QuickSort;

import java.util.Arrays;

import static utils.SortUtil.*;

/**
 * Description : HeapSortTest Example
 * <p>
 * <p>Date : 2017/10/7 18:02
 * <p>
 * <p>@author : Matrix [xhyrzldf@foxmail.com]
 */
public class HeapSortTest {

    /**
     * 测试用例
     *
     * @param args
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
    /* array length */
        int n = 1000000;

    /* random range */
        int r = 10;

    /* array element swaptimes */
        int s = 10;

        int[] arr = getRandomArray(n, n);
        int[] arr02 = Arrays.copyOf(arr, n);
        int[] arr03 = Arrays.copyOf(arr, n);
        int[] arr04 = Arrays.copyOf(arr, n);
        Integer[] arr05 = intArrayToInetegerArray(Arrays.copyOf(arr, n));
        int[] arr06 = Arrays.copyOf(arr, n);
        int[] arr07 = Arrays.copyOf(arr, n);

        System.out.printf("\nRandom array length is : %d , \t randomRange(0,%d)\n", n, n);
        printSortTime(arr, MergeSort::mergeSort, "mergeSort");
        printSortTime(arr02, QuickSort::quickSort2, "QuickSort2");
        printSortTime(arr03, QuickSort::quickSort3Ways, "QuickSort3Ways");
        printSortTime(arr04, HeapSort::heapSort, "HeapSort");
        printSortTimeObj(arr05, HeapSort::heapSort2, "HeapSort2");
        printSortTime(arr06, HeapSort::heapSort3, "HeapSort3");
        printSortTime(arr07, Arrays::sort, "JDK SORT");

        arr = getRandomArrayNearlyOrder(n, s);
        arr02 = Arrays.copyOf(arr, n);
        arr03 = Arrays.copyOf(arr, n);
        arr04 = Arrays.copyOf(arr, n);
        arr05 = intArrayToInetegerArray(Arrays.copyOf(arr, n));
        arr06 = Arrays.copyOf(arr, n);
        arr07 = Arrays.copyOf(arr, n);
        System.out.printf("\nRandom array NearlyOrder length is : %d , \t swaptimes(0,%d)\n", n, s);
        printSortTime(arr, MergeSort::mergeSort, "mergeSort");
        printSortTime(arr02, QuickSort::quickSort2, "QuickSort2");
        printSortTime(arr03, QuickSort::quickSort3Ways, "QuickSort3Ways");
        printSortTime(arr04, HeapSort::heapSort, "HeapSort");
        printSortTimeObj(arr05, HeapSort::heapSort2, "HeapSort2");
        printSortTime(arr06, HeapSort::heapSort3, "HeapSort3");
        printSortTime(arr07, Arrays::sort, "JDK SORT");

        arr = getRandomArray(n, r);
        arr02 = Arrays.copyOf(arr, n);
        arr03 = Arrays.copyOf(arr, n);
        arr04 = Arrays.copyOf(arr, n);
        arr05 = intArrayToInetegerArray(Arrays.copyOf(arr, n));
        arr06 = Arrays.copyOf(arr, n);
        arr07 = Arrays.copyOf(arr, n);

        System.out.printf("\nRandom array length is : %d , \t randomRange(0,%d)\n", n, r);
        printSortTime(arr, MergeSort::mergeSort, "mergeSort");
        printSortTime(arr02, QuickSort::quickSort2, "QuickSort2");
        printSortTime(arr03, QuickSort::quickSort3Ways, "QuickSort3Ways");
        printSortTime(arr04, HeapSort::heapSort, "HeapSort");
        printSortTimeObj(arr05, HeapSort::heapSort2, "HeapSort2");
        printSortTime(arr06, HeapSort::heapSort3, "HeapSort3");
        printSortTime(arr07, Arrays::sort, "JDK SORT");

    }
}
