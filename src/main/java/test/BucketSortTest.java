package main.java.test;

import main.java.sort.BucketSort;

import static main.java.utils.SortUtil.getRandomArray;
import static main.java.utils.SortUtil.printSortTime;

/**
 * Description : BucketSortTest Example
 * <p>
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 * <p>
 * <p>Date : 2017/10/7 18:01
 */
public class BucketSortTest {
    public static void main(String[] args) {
        int[] array = getRandomArray(1000000, 10);
        printSortTime(array, BucketSort::bucketSort, "桶排序");
    }
}
