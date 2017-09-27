package sort;

import java.util.Arrays;
import java.util.Random;

import static utils.SortUtil.*;

/**
 * <h1>class_name: QuickSort</h1>
 * <ul>describe: 快速排序是将数组分为 arr01 < v < arr02 这样的两个数组,然后再递归下去 </ul>
 * <ul>create_user: LDF(xhyrzldf@foxmail.com)</ul>
 * <ul>create_date: 2017/9/22 0022</ul>
 * <ul>create_time: 下午 12:17</ul>
 **/
@SuppressWarnings({"Duplicates", "unused", "WeakerAccess"})
public class QuickSort {


    public static void main(String[] args) {

        int n = 1000000;

        int[] arr = getRandomArray(n, n);
        int[] arr02 = Arrays.copyOf(arr, n);
        int[] arr03 = Arrays.copyOf(arr, n);
        System.out.printf("\nRandom array length is : %d , \t randomRange(0,%d)\n", n, n);
        printSortTime(arr, MergeSort::mergeSort, "mergeSort");
        printSortTime(arr02, QuickSort::quickSort2, "QuickSort2");
        printSortTime(arr03, QuickSort::quickSort3Ways, "QuickSort3Ways");

        arr = getRandomArrayNearlyOrder(n, 10);
        arr02 = Arrays.copyOf(arr, n);
        arr03 = Arrays.copyOf(arr, n);
        System.out.printf("\nRandom array NearlyOrder length is : %d , \t randomRange(0,%d)\n", n, n);
        printSortTime(arr, MergeSort::mergeSort, "mergeSort");
        printSortTime(arr02, QuickSort::quickSort2, "QuickSort2");
        printSortTime(arr03, QuickSort::quickSort3Ways, "QuickSort3Ways");

        arr = getRandomArray(n, 10);
        arr02 = Arrays.copyOf(arr, n);
        arr03 = Arrays.copyOf(arr, n);
        System.out.printf("\nRandom array length is : %d , \t randomRange(0,%d)\n", n, 10);
        printSortTime(arr, MergeSort::mergeSort, "mergeSort");
        printSortTime(arr02, QuickSort::quickSort2, "QuickSort2");
        printSortTime(arr03, QuickSort::quickSort3Ways, "QuickSort3Ways");
    }


    /**
     * 快速排序
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        __quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 对arr[l,r]范围内的数组进行快速排序,1.将数组分割为两个数组2.分别对他们快速排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void __quickSort(int[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.insertionSortForOpt(arr, l, r);
            return;
        }
        int p = __partition(arr, l, r);
        __quickSort(arr, l, p - 1);
        __quickSort(arr, p + 1, r);
    }

    /**
     * 对arr[l,r]数组进行partition操作,返回p
     * 使得数组 arr[l,p-1] < arr[p] < arr[p+1,r]
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int __partition(int[] arr, int l, int r) {
        //这里做一个优化,选取一个随机元素来作为partition,这样可以大大的降低快排降低到n^2级别的概率
        swap(arr, l, new Random().nextInt(r - l + 1) + l);
        int e = arr[l];
        //arr[l + 1, j] < e < arr[j + 1, i)
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < e) {
                swap(arr, i, ++j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    /**
     * 两个下标扫描,目的是平均相同数字的部分到前后两个区域
     *
     * @param arr
     */
    public static void quickSort2(int[] arr) {
        __quickSort2(arr, 0, arr.length - 1);
    }

    /**
     * @param arr
     * @param l
     * @param r
     */
    private static void __quickSort2(int[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.insertionSortForOpt(arr, l, r);
            return;
        }
        int p = __partition2(arr, l, r);
        __quickSort2(arr, l, p - 1);
        __quickSort2(arr, p + 1, r);
    }


    /**
     * 对数组进行分割返回p 使得 arr[l,p-1] < arr[p] < arr[p+1,r]
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int __partition2(int[] arr, int l, int r) {

        swap(arr, l, new Random().nextInt(r - l + 1) + l);
        int e = arr[l];
        // arr[l+1...i) <= e , arr(j...r] >= e
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < e) i++;
            while (j >= l + 1 && arr[j] > e) j--;
            if (i > j) break;
            swap(arr, i++, j--);
        }
        swap(arr, l, j);
        return j;
    }

    /**
     * 三路快速排序
     *
     * @param arr
     */
    public static void quickSort3Ways(int[] arr) {
        __quickSort3Ways(arr, 0, arr.length - 1);
    }


    /**
     * 对数组arr[l,r]的部分进行三路快速排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void __quickSort3Ways(int[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.insertionSortForOpt(arr, l, r);
            return;
        }
        //random seed
        swap(arr, l, new Random().nextInt(r - l + 1) + l);
        int v = arr[l];

        /* 3Ways partition,The array will be divided into three sections */
        int lt = l;     //  arr[l+1, lt] < v
        int gt = r + 1; //  arr[gt, r] > v
        int i = lt + 1; //  arr[lt + 1, i) = v
        while (i < gt) {
            if (arr[i] < v) swap(arr, i++, ++lt);
            else if (arr[i] > v) swap(arr, i, --gt);
            else if (arr[i] == v) i++;

        }

        swap(arr, l, lt--);

        __quickSort3Ways(arr, l, lt);
        __quickSort3Ways(arr, gt, r);

    }
}
