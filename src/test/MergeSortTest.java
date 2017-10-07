package test;

import sort.MergeSort;

import java.util.Arrays;

import static utils.SortUtil.getRandomArray;
import static utils.SortUtil.printSortTime;

/**
 * Description : MergeSort测试用例
 *
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 *
 * <p>Date : 2017/10/7 18:17
 */
public class MergeSortTest {
  public static void main(String[] args) {
    int n = 150000;
    int[] arr = getRandomArray(n, 150000);
    int[] arr02 = Arrays.copyOf(arr, n);
    int[] arr03 = Arrays.copyOf(arr, n);
    printSortTime(arr, MergeSort::mergeSort, "mergeSort");
    printSortTime(arr02, MergeSort::mergeSortBU, "mergeSortBottomUp");
    printSortTime(arr03, Arrays::sort, "jdkSort");
  }
}
