package sort;

@SuppressWarnings("WeakerAccess")
public class MergeSort {

  /**
   * 递归归并排序,对范围arr[0,n]范围内的元素进行归并排序,注意这里是闭区间
   *
   * @param arr
   */
  public static void mergeSort(int[] arr) {
    __mergeSort(arr, 0, arr.length - 1);
  }

  /**
   * 自底而上的归并排序 好处是不需要使用很多内存空间,因为这个是循环 :)
   *
   * @param arr
   */
  public static void mergeSortBU(int[] arr) {
    for (int sz = 1; sz <= arr.length; sz += sz) { // 每次merge的区间,从下往上分别1,2,4,8...
      /*将arr[i,i+sz-1]与arr[i+sz,i+2*sz-1]的范围内的数组进行归并,每次归并完之后i往后移动2个size的距离
          [     3       ,     1   ,     5   ,     8   ,     4   ,     6   ,     2   ,     9    ,    7   ]
               i------------i+sz-1-----i+sz-------i+2z-1
              |-------sz-------|---------sz--------|           差不多就是这么一个意思啦 :)
              接下来要处理两个越界问题
              那就是 假设 n = arr.length
              单纯的 i < n ,并不能够保证数组不会越界 , 因为后面还有 i+sz , i+2*sz-1 这些
              所以说循环的限制条件要改为 i+sz < n , 这个条件意思是merge的第二个区间是一定存在的
              然后右边边界有可能会超出 意思就是右边的区间应该取到n - 1 (因为这里的范围是闭区间)就结束了 但是i+2z-1可能会大于n ,那么这个时候应该取 i + sz -1 与n的最小值
              这样如果超出了,merge到n 就结束了 ,如果不足 n ,
              那么之前的__merge方法里已经处理过了,不足的n的话右边界有可能提前结束,那剩下的就是merge左边界了,具体处理办法在本类的第89行
              优化也是同样的
              1.对merge操作进行判断条件,如果两部分已经有序了,即arr[i + sz - 1] <= arr[i + sz ],则无需merge
              2.对于比较小的sz 采用插入排序来代替,因为在小范围内 A*n^2 < B*n*logN (B > A)
      */

      for (int i = 0; i + sz < arr.length; i += sz + sz) {
        if (sz <= 15) InsertionSort.insertionSortForOpt(arr, i, i + sz + sz - 1);
        else if (arr[i + sz - 1] > arr[i + sz])
          __merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, arr.length - 1));
      }
    }
  }

  // 对arr[l,r]范围内的数组进行归并排序
  private static void __mergeSort(int[] arr, int l, int r) {
    // 设置结束条件
    if (r - l <= 15) {
      InsertionSort.insertionSortForOpt(arr, l, r);
      return;
    }
    // 分成[l,middle] 与[middle+1, r]两组,分别进行归并排序
    int middle = (l + r) / 2;
    __mergeSort(arr, l, middle);
    __mergeSort(arr, middle + 1, r);
    // 对这两组进行归并,添加if条件,减少merge次数
    if (arr[middle] > arr[middle + 1]) __merge(arr, l, middle, r);
  }

  // 对范围arr[l,middle] 与[middle+1,r] 两部分进行归并
  private static void __merge(int[] arr, int l, int mid, int r) {
    int[] aux = new int[r - l + 1];
    System.arraycopy(arr, l, aux, 0, r - l + 1);

    int i = l, j = mid + 1;
    for (int k = l; k <= r; k++) {
      if (i > mid) {
        arr[k] = aux[j - l];
        j++;
      } else if (j > r) {
        arr[k] = aux[i - l];
        i++;
      } else if (aux[i - l] < aux[j - l]) {
        arr[k] = aux[i - l];
        i++;
      } else {
        arr[k] = aux[j - l];
        j++;
      }
    }
  }
}
