package test;

import sort.MergeSort;
import sort.QuickSort;

import java.util.Arrays;

import static utils.SortUtil.*;

/**
 * Description : 快速排序测试用例
 *
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 *
 * <p>Date : 2017/10/7 18:19
 */
public class QuickSortTest {
  public static void main(String[] args) {

    int n = 1000000;

    int[] arr = getRandomArray(n, n);
    int[] arr02 = Arrays.copyOf(arr, n);
    int[] arr03 = Arrays.copyOf(arr, n);
    System.out.printf("\nRandom array length is : %d , \t randomRange(0,%d)\n", n, n);
    printSortTime(arr, MergeSort::mergeSort, "mergeSort");
    printSortTime(arr02, QuickSort::quickSort2, "QuickSort2");
    printSortTime(arr03, QuickSort::quickSort3Ways, "QuickSort3Ways");

    arr = getRandomArrayNearlyOrder(n, 10);
    arr02 = Arrays.copyOf(arr, n);
    arr03 = Arrays.copyOf(arr, n);
    System.out.printf("\nRandom array NearlyOrder length is : %d , \t randomRange(0,%d)\n", n, n);
    printSortTime(arr, MergeSort::mergeSort, "mergeSort");
    printSortTime(arr02, QuickSort::quickSort2, "QuickSort2");
    printSortTime(arr03, QuickSort::quickSort3Ways, "QuickSort3Ways");

    arr = getRandomArray(n, 10);
    arr02 = Arrays.copyOf(arr, n);
    arr03 = Arrays.copyOf(arr, n);
    System.out.printf("\nRandom array length is : %d , \t randomRange(0,%d)\n", n, 10);
    printSortTime(arr, MergeSort::mergeSort, "mergeSort");
    printSortTime(arr02, QuickSort::quickSort2, "QuickSort2");
    printSortTime(arr03, QuickSort::quickSort3Ways, "QuickSort3Ways");
  }
}
