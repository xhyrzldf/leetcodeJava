package algorithm;

import sort.QuickSort;

import java.util.Arrays;
import java.util.Random;

import static utils.SortUtil.getRandomArray;
import static utils.SortUtil.swap;

/**
 * @Description find the n th largest element in the array 寻找到数组中第几大的元素 @Author
 * matrix[xhyrzldf@foxmail.com] @Date 2017/9/26 15:38
 */
public class findTheNThLargestElementInTheArray {

  public static void main(String[] args) {

    /* 这里是断言测试,测试快速排序方法找数的方法对不对
    int n = 10000;
    int[] array = getRandomArrayNearlyOrder(n, 0);
    for (int i = 1; i <= n; i++) {
        System.out.println("i = " + i);
        System.out.println("exceped Num:  " + array[n - i]);
        System.out.println("actually Num: " + quickSortWay(array, i));
        assert quickSortWay(array, i) == array[n - i];
        System.out.println("test\t" + i + "th element complete\n");
    }*/

    /* 下面是性能测试 在我这电脑是时间差距大概是10倍左右 毕竟一个是Nlogn级别 一个是n级别 */
    int n2 = 10000000;
    int target = new Random().nextInt(n2);
    int[] array02 = getRandomArray(n2);
    int[] array03 = Arrays.copyOf(array02, n2);

    System.out.println("target Index is :  " + target + "\n");
    long start = System.nanoTime();
    System.out.println(traditionWay(array02, target));
    long end = System.nanoTime();
    double currentTimes = (end - start) / Math.pow(10, 6);
    System.out.println("traditionWay spend " + (currentTimes) + " ms");

    start = System.nanoTime();
    System.out.println(quickSortWay(array03, target));
    end = System.nanoTime();
    currentTimes = (end - start) / Math.pow(10, 6);
    System.out.println("quickSortWay spend " + (currentTimes) + " ms");
  }

  /**
   * 传统方法,采用排序算法,然后取出相应的数值,时间复杂度nlogn级别,这里就采用三路快排吧
   *
   * <p>The traditional method, using the sorting algorithm, and then taking out the corresponding
   * values, the time complexity is nlogn level , we're going to use three quick sort here
   *
   * @param array 目标数组
   * @param n 需求的大小排名
   * @return 第N大的元素
   */
  private static int traditionWay(int[] array, int n) {
    int arrSize = array.length;
    int nIndex = arrSize - n;
    QuickSort.quickSort3Ways(array);
    return nIndex >= 0 && nIndex < arrSize ? array[nIndex] : 0;
  }

  /**
   * 使用快速排序的思路来解决,每次partition的时候比较一下元素的位置,然后选择需要那一部分继续快速找值 Use a quick sort of thinking to solve,
   * compare the location of the element each time partition, and then choose to need that part to
   * continue to find the value quickly 算法时间期望值为 n+n/2+n/4+n/8......+1 = 2n 时间复杂度是N级别的
   *
   * @param arr
   * @param n
   * @return
   */
  private static int quickSortWay(int[] arr, int n) {
    if (n > arr.length || n < 0) return 0;
    return __quickSortWay(arr, 0, arr.length - 1, n);
  }

  /**
   * find the n th largest element in arr[l,r]
   *
   * @param arr
   * @param l
   * @param r
   * @param n
   * @return
   */
  private static int __quickSortWay(int[] arr, int l, int r, int n) {
    if (r - l <= 0) return arr[l];

    // Use partition to spilt array
    int p = __partition(arr, l, r);
    int targetIndex = arr.length - n;

    if (p == targetIndex) return arr[p];
    else if (p < targetIndex) return __quickSortWay(arr, p + 1, r, n);
    else if (p > targetIndex) return __quickSortWay(arr, l, p - 1, n);

    return 0;
  }

  /**
   * partition 这里就不多说啦,参考 {@link QuickSort#__partition2(int[], int, int)}
   *
   * @param arr
   * @param l
   * @param r
   * @return
   */
  @SuppressWarnings("Duplicates")
  private static int __partition(int[] arr, int l, int r) {
    // random seed
    swap(arr, l, new Random().nextInt(r - l + 1) + l);
    int v = arr[l];
    // arr[l+1,i)< v , arr(j,r] > v
    int i = l + 1;
    int j = r;
    while (true) {
      while (i <= r && arr[i] < v) i++;
      while (j >= l + 1 && arr[j] > v) j--;
      if (i > j) break;
      swap(arr, i++, j--);
    }
    swap(arr, l, j);

    return j;
  }
}
