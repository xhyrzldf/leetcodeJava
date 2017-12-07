package main.java.test;

import main.java.sort.InsertionSort;
import main.java.sort.QuickSort;

import java.util.Arrays;

import static main.java.utils.SortUtil.getRandomArray;
import static main.java.utils.SortUtil.printSortTime;

/**
 * Description : SelectionSortTest Example
 * <p>
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 * <p>
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
