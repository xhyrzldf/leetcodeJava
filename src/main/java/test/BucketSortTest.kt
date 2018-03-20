package test

import sort.BucketSort
import utils.SortUtil.getRandomArray
import utils.SortUtil.printSortTime

/**
 * Description : BucketSortTest Example
 *
 *
 *
 * Author : Matrix [xhyrzldf@foxmail.com]
 *
 *
 *
 * Date : 2017/10/7 18:01
 */
object BucketSortTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = getRandomArray(1000000, 10)
        printSortTime(array, { BucketSort.bucketSort(it) }, "桶排序")
    }
}
