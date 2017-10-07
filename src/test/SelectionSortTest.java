package test;

import sort.InsertionSort;
import sort.SelectionSort;

import java.util.Arrays;

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
    int[] array = getRandomArrayNearlyOrder(100000, 0);
    int[] array01 = Arrays.copyOf(array, 100000);
    printSortTime(array, SelectionSort::selectionSort, "selectionSort");
    printSortTime(array01, InsertionSort::insertionSortOpt, "insertSort");
  }
}
