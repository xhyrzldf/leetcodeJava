package test

import sort.HeapSort
import sort.MergeSort
import sort.QuickSort
import utils.SortUtil.*
import java.util.*

/**
 * Description : HeapSortTest Example
 *
 *
 *
 * Date : 2017/10/7 18:02
 *
 *
 *
 * @author : Matrix [xhyrzldf@foxmail.com]
 */
object HeapSortTest {

    /**
     * 测试用例
     *
     * @param args
     */
    @JvmStatic
    fun main(args: Array<String>) {
        /* array length */
        val n = 1000000

        /* random range */
        val r = 10

        /* array element swaptimes */
        val s = 10

        var arr = getRandomArray(n, n)
        var arr02 = Arrays.copyOf(arr, n)
        var arr03 = Arrays.copyOf(arr, n)
        var arr04 = Arrays.copyOf(arr, n)
        var arr05 = intArrayToInetegerArray(Arrays.copyOf(arr, n))
        var arr06 = Arrays.copyOf(arr, n)
        var arr07 = Arrays.copyOf(arr, n)

        System.out.printf("\nRandom array length is : %d , \t randomRange(0,%d)\n", n, n)
        printSortTime(arr, { MergeSort.mergeSort(it) }, "mergeSort")
        printSortTime(arr02, { QuickSort.quickSort2(it) }, "QuickSort2")
        printSortTime(arr03, { QuickSort.quickSort3Ways(it) }, "QuickSort3Ways")
        printSortTime(arr04, { HeapSort.heapSort(it) }, "HeapSort")
        printSortTimeObj(arr05, { HeapSort.heapSort2(it) }, "HeapSort2")
        printSortTime(arr06, { HeapSort.heapSort3(it) }, "HeapSort3")
        printSortTime(arr07, { Arrays.sort(it) }, "JDK SORT")

        arr = getRandomArrayNearlyOrder(n, s)
        arr02 = Arrays.copyOf(arr, n)
        arr03 = Arrays.copyOf(arr, n)
        arr04 = Arrays.copyOf(arr, n)
        arr05 = intArrayToInetegerArray(Arrays.copyOf(arr, n))
        arr06 = Arrays.copyOf(arr, n)
        arr07 = Arrays.copyOf(arr, n)

        System.out.printf("\nRandom array NearlyOrder length is : %d , \t swaptimes(0,%d)\n", n, s)
        printSortTime(arr, { MergeSort.mergeSort(it) }, "mergeSort")
        printSortTime(arr02, { QuickSort.quickSort2(it) }, "QuickSort2")
        printSortTime(arr03, { QuickSort.quickSort3Ways(it) }, "QuickSort3Ways")
        printSortTime(arr04, { HeapSort.heapSort(it) }, "HeapSort")
        printSortTimeObj(arr05, { HeapSort.heapSort2(it) }, "HeapSort2")
        printSortTime(arr06, { HeapSort.heapSort3(it) }, "HeapSort3")
        printSortTime(arr07, { Arrays.sort(it) }, "JDK SORT")

        arr = getRandomArray(n, r)
        arr02 = Arrays.copyOf(arr, n)
        arr03 = Arrays.copyOf(arr, n)
        arr04 = Arrays.copyOf(arr, n)
        arr05 = intArrayToInetegerArray(Arrays.copyOf(arr, n))
        arr06 = Arrays.copyOf(arr, n)
        arr07 = Arrays.copyOf(arr, n)

        System.out.printf("\nRandom array length is : %d , \t randomRange(0,%d)\n", n, r)
        printSortTime(arr, { MergeSort.mergeSort(it) }, "mergeSort")
        printSortTime(arr02, { QuickSort.quickSort2(it) }, "QuickSort2")
        printSortTime(arr03, { QuickSort.quickSort3Ways(it) }, "QuickSort3Ways")
        printSortTime(arr04, { HeapSort.heapSort(it) }, "HeapSort")
        printSortTimeObj(arr05, { HeapSort.heapSort2(it) }, "HeapSort2")
        printSortTime(arr06, { HeapSort.heapSort3(it) }, "HeapSort3")
        printSortTime(arr07, { Arrays.sort(it) }, "JDK SORT")

    }
}
