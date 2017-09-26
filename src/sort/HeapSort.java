package sort;

import domain.MaxHeap;

import java.util.Arrays;
import java.util.stream.Stream;

import static utils.SortUtil.*;

/**
 * @Description 堆排序
 * @Author matrix[xhyrzldf@foxmail.com]
 * @Date 2017/9/26 22:53
 */
public class HeapSort {

    /**
     * 普通的构造方式
     * @param arr
     */
    public static void heapSort(int[] arr) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extracMax();
        }
    }


    /**
     * heapify的构造方式,这样可以插入的时候少对2/n个元素shiftDown
     * @param arr
     */
    public static void heapSort2(Integer[] arr) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extracMax();
        }
    }

    /**
     * 测试用例
     * @param args
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        int n = 1000000;

        int[] arr = getRandomArray(n, n);
        int[] arr02 = Arrays.copyOf(arr, n);
        int[] arr03 = Arrays.copyOf(arr, n);
        int[] arr04 = Arrays.copyOf(arr, n);
        Integer[] arr05 = intArrayToInetegerArray(Arrays.copyOf(arr, n));

        System.out.printf("\nRandom array length is : %d , \t randomRange(0,%d)\n", n, n);
        printSortTime(arr, MergeSort::mergeSort, "mergeSort");
        printSortTime(arr02, QuickSort::quickSort2, "QuickSort2");
        printSortTime(arr03, QuickSort::quickSort3Ways, "QuickSort3Ways");
        printSortTime(arr04, HeapSort::heapSort, "HeapSort");
        printSortTimeObj(arr05, HeapSort::heapSort2, "HeapSort2");



        arr = getRandomArrayNearlyOrder(n, 10);
        arr02 = Arrays.copyOf(arr, n);
        arr03 = Arrays.copyOf(arr, n);
        arr04 = Arrays.copyOf(arr, n);
        arr05 = intArrayToInetegerArray(Arrays.copyOf(arr, n));

        System.out.printf("\nRandom array NearlyOrder length is : %d , \t randomRange(0,%d)\n", n, n);
        printSortTime(arr, MergeSort::mergeSort, "mergeSort");
        printSortTime(arr02, QuickSort::quickSort2, "QuickSort2");
        printSortTime(arr03, QuickSort::quickSort3Ways, "QuickSort3Ways");
        printSortTime(arr04, HeapSort::heapSort, "HeapSort");
        printSortTimeObj(arr05, HeapSort::heapSort2, "HeapSort2");



        arr = getRandomArray(n, 10);
        arr02 = Arrays.copyOf(arr, n);
        arr03 = Arrays.copyOf(arr, n);
        arr04 = Arrays.copyOf(arr, n);
        arr05 = intArrayToInetegerArray(Arrays.copyOf(arr, n));

        System.out.printf("\nRandom array length is : %d , \t randomRange(0,%d)\n", n, 10);
        printSortTime(arr, MergeSort::mergeSort, "mergeSort");
        printSortTime(arr02, QuickSort::quickSort2, "QuickSort2");
        printSortTime(arr03, QuickSort::quickSort3Ways, "QuickSort3Ways");
        printSortTime(arr04, HeapSort::heapSort, "HeapSort");
        printSortTimeObj(arr05, HeapSort::heapSort2, "HeapSort2");

    }


}
