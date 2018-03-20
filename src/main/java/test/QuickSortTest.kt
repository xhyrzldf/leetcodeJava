package test

import sort.MergeSort
import sort.QuickSort
import utils.SortUtil.*
import java.util.*
import java.util.function.Consumer

/**
 * Description : 快速排序测试用例
 *
 *
 *
 * Author : Matrix [xhyrzldf@foxmail.com]
 *
 *
 *
 * Date : 2017/10/7 18:19
 */
object QuickSortTest {
    @JvmStatic
    fun main(args: Array<String>) {

        val n = 1000000

        var arr = getRandomArray(n, n)
        var arr02 = Arrays.copyOf(arr, n)
        var arr03 = Arrays.copyOf(arr, n)
        System.out.printf("\nRandom array length is : %d , \t randomRange(0,%d)\n", n, n)
        printSortTime(arr, Consumer<IntArray> { MergeSort.mergeSort(it) }, "mergeSort")
        printSortTime(arr02, Consumer<IntArray> { QuickSort.quickSort2(it) }, "QuickSort2")
        printSortTime(arr03, Consumer<IntArray> { QuickSort.quickSort3Ways(it) }, "QuickSort3Ways")

        arr = getRandomArrayNearlyOrder(n, 10)
        arr02 = Arrays.copyOf(arr, n)
        arr03 = Arrays.copyOf(arr, n)
        System.out.printf("\nRandom array NearlyOrder length is : %d , \t randomRange(0,%d)\n", n, n)
        printSortTime(arr, Consumer<IntArray> { QuickSort.quickSort(it) }, "mergeSort")
        printSortTime(arr02, Consumer<IntArray> { QuickSort.quickSort2(it) }, "QuickSort2")
        printSortTime(arr03, Consumer<IntArray> { QuickSort.quickSort3Ways(it) }, "QuickSort3Ways")

        arr = getRandomArray(n, 10)
        arr02 = Arrays.copyOf(arr, n)
        arr03 = Arrays.copyOf(arr, n)
        System.out.printf("\nRandom array length is : %d , \t randomRange(0,%d)\n", n, 10)
        printSortTime(arr, Consumer<IntArray> { MergeSort.mergeSort(it) }, "mergeSort")
        printSortTime(arr02, Consumer<IntArray> { QuickSort.quickSort2(it) }, "QuickSort2")
        printSortTime(arr03, Consumer<IntArray> { QuickSort.quickSort3Ways(it) }, "QuickSort3Ways")
    }
}
