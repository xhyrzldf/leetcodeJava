package test;

import sort.BucketSort;

import static utils.SortUtil.getRandomArray;
import static utils.SortUtil.printSortTime;

/** @Description @Author Matrix [xhyrzldf@foxmail.com] @Date 2017/10/7 18:01 */
public class BucketSortTest {
  public static void main(String[] args) {
    int[] array = getRandomArray(1000000, 10);
    printSortTime(array, BucketSort::bucketSort, "桶排序");
  }
}
