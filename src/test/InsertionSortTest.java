package test;

import sort.InsertionSort;
import sort.SelectionSort;

import java.util.Arrays;

import static utils.SortUtil.getRandomArrayNearlyOrder;
import static utils.SortUtil.printSortTime;

/** @Description @Author Matrix [xhyrzldf@foxmail.com] @Date 2017/10/7 18:04 */
public class InsertionSortTest {
  public static void main(String[] args) {
    final int[] array = getRandomArrayNearlyOrder(1000000, 10);
    final int[] array02 = Arrays.copyOf(array, array.length);
    final int[] array03 = Arrays.copyOf(array, array.length);
    printSortTime(array, SelectionSort::selectionSort, "选择排序");
    printSortTime(array02, InsertionSort::insertionSort, "插入排序");
    printSortTime(array03, InsertionSort::insertionSortOpt, "优化插入排序");
  }
}
