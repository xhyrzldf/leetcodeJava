package array;

/**
 * Description : Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
 * sorted array.
 *
 * <p>Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) to
 * hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m
 * and n respectively.
 *
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 *
 * <p>Date : 2017/10/10 18:11
 */
public class MergeSortedArray_88 {
  /**
   * 传统的归并排序开辟一个m空间的数组从前往后
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] aux = new int[m];
    for (int i = 0; i < m; i++) {
      aux[i] = nums1[i];
    }

    for (int i = 0, j = 0, k = 0; k < m + n; k++) {
      if (j >= n) nums1[k] = aux[i++];
      else if (i >= m) nums1[k] = nums2[j++];
      else if (aux[i] < nums2[j]) nums1[k] = aux[i++];
      else nums1[k] = nums2[j++];
    }
  }

  /**
   * 反向归并,这样可以利用nums1数组多出来的空间
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public void merge01(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, k = nums1.length - 1;
    while (i >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
      else nums1[k--] = nums2[j--];
    }
    while (j >= 0) {
      nums1[k--] = nums2[j--];
    }
  }
}
