package sort;

import domain.MaxHeap;

import static utils.SortUtil.swap;


/**
 * @Description 堆排序 @Author matrix[xhyrzldf@foxmail.com] @Date 2017/9/26 22:53
 */
@SuppressWarnings("WeakerAccess")
public class HeapSort {

    /**
     * 普通的构造方式
     *
     * @param arr
     */
    @SuppressWarnings("ForLoopReplaceableByForEach")
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
     *
     * @param arr
     */
    public static void heapSort2(Integer[] arr) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extracMax();
        }
    }

    /**
     * 原地heapify的堆排序
     *
     * @param arr
     */
    public static void heapSort3(int[] arr) {
        // heapify,The first one is not a subscript index of a leaf node is (arr.length-1)/2
        int n = arr.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            __shiftDown(arr, n, i);
        }

        // shiftDown
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            __shiftDown(arr, i, 0);
        }
    }

    /**
     * opt shiftDown
     *
     * @param arr
     * @param n
     * @param k
     */
    private static void __shiftDown(int[] arr, int n, int k) {

        int v = arr[k];

        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1] > arr[j]) j++;
            if (v >= arr[j]) break;
            arr[k] = arr[j];
            k = j;
        }

        arr[k] = v;
    }
}
