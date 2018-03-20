package test

import sort.InsertionSort
import sort.SelectionSort
import utils.SortUtil.getRandomArrayNearlyOrder
import utils.SortUtil.printSortTime
import java.util.*
import java.util.function.Consumer


/**
 * Description : InsertionSortTest Example
 *
 *
 *
 * @Author : Matrix [xhyrzldf@foxmail.com]
 *
 *
 *
 * Date : 2017/10/7 18:02
 */
object InsertionSortTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = getRandomArrayNearlyOrder(1000000, 10)
        val array02 = Arrays.copyOf(array, array.size)
        val array03 = Arrays.copyOf(array, array.size)
        printSortTime(array, Consumer<IntArray> { SelectionSort.selectionSort(it) }, "选择排序")
        printSortTime(array02, Consumer<IntArray> { InsertionSort.insertionSort(it) }, "插入排序")
        printSortTime(array03, Consumer<IntArray> { InsertionSort.insertionSortOpt(it) }, "优化插入排序")
    }
}
