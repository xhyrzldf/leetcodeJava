package test

import sort.InsertionSort
import sort.QuickSort
import utils.SortUtil.getRandomArray
import utils.SortUtil.printSortTime
import java.util.*
import java.util.function.Consumer

/**
 * Description : SelectionSortTest Example
 *
 *
 *
 * Author : Matrix [xhyrzldf@foxmail.com]
 *
 *
 *
 * Date : 2017/10/7 18:22
 */
object SelectionSortTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = getRandomArray(1000000, 1000000)
        val array01 = Arrays.copyOf(array, 1000000)
        printSortTime(array, Consumer<IntArray> { QuickSort.quickSort2(it) }, "quickSort")
        printSortTime(array01, Consumer<IntArray> { InsertionSort.insertionSortOpt(it) }, "insertSort")
    }
}
