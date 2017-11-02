package test;

import sort.InsertionSort;
import sort.QuickSort;
import sort.SelectionSort;

import java.util.Arrays;

import static utils.SortUtil.getRandomArray;
import static utils.SortUtil.getRandomArrayNearlyOrder;
import static utils.SortUtil.printSortTime;

/**
 * Description : SelectionSortTest Example
 *
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 *
 * <p>Date : 2017/10/7 18:22
 */
public class SelectionSortTest {
  public static void main(String[] args) {
    int[] array = getRandomArray(1000000, 1000000);
    int[] array01 = Arrays.copyOf(array, 1000000);
    printSortTime(array, QuickSort::quickSort2, "quickSort");
    printSortTime(array01, InsertionSort::insertionSortOpt, "insertSort");
  }
}
