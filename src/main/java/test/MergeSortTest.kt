package test

import sort.MergeSort
import utils.SortUtil.getRandomArray
import utils.SortUtil.printSortTime
import java.util.*
import java.util.function.Consumer

/**
 * Description : MergeSort测试用例
 *
 *
 *
 * Author : Matrix [xhyrzldf@foxmail.com]
 *
 *
 *
 * Date : 2017/10/7 18:17
 */
object MergeSortTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val n = 150000
        val arr = getRandomArray(n, 150000)
        val arr02 = Arrays.copyOf(arr, n)
        val arr03 = Arrays.copyOf(arr, n)
        printSortTime(arr, Consumer<IntArray> { MergeSort.mergeSort(it) }, "mergeSort")
        printSortTime(arr02, Consumer<IntArray> { MergeSort.mergeSortBU(it) }, "mergeSortBottomUp")
        printSortTime(arr03, Consumer<IntArray> { Arrays.sort(it) }, "jdkSort")
    }
}
