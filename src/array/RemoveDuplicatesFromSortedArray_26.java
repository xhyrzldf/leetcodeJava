package array;

/**
 * RemoveDuplicatesFromSortedArray_26 Given a sorted array, remove the duplicates in place such that
 * each element appear only once and return the new length. Do not allocate extra space for another
 * array, you must do this in place with constant memory. For example, Given input array A =
 * [1,1,2], Your function should return length = 2, and A is now [1,2].
 *
 * <p>翻译 从有序数组中移出重复的元素
 *
 * <p>给定一个排序的数组,移除里面重复的元素这样每一个元素只出现一次,并且返回新的长度 不要使用为新的数组开辟额外的内存空间,你必须在原数组的内存空间上操作
 * 局格子里,给定一个输入数组[1,1,2] 你的方法应该返回 2 ,并且A数组时[1,2] ps：对于java语言来说,在不使用额外的内存空间的情况下数组长度是不能改变滴,所以这道题
 * 可以转变为例如给定数组为[1,2,3,3,5,5],返回结果长度应该为4,数组可以变为[1,2,3,5,x,x] x代表任意字符即可
 */
@SuppressWarnings("unused")
public class RemoveDuplicatesFromSortedArray_26 {

  public int removeDuplicates01(int[] nums) {
    // 特殊情况的判断,如果数组为null或者0,直接返回0,如果是1个元素显而易见肯定是不重复的返回1
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return 1;

    int k = 1; // arr[1,k)正确元素应当插入的位置,这里从1开始算,从0开始算也应该维护0的定义
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[k - 1]) { // k是应当插入的位置,所以k-1就是应当插入的位置的前一个元素,k和k-1位置的元素不应当相同
        nums[k] = nums[i]; // 如果判断过了,说明当前遍历的nums[i]是一个独立的数字(因为数字是有序的),将nums[k]的值变为nums[i]
        k++; // k标记往后推一位
      }
    }
    return k;
  }

  // 02方法呢就是对01方法的一些简化写法,可以对比一下
  public int removeDuplicates02(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int k = 0;
    for (int i = 0; i < nums.length; i++) if (k == 0 || nums[i] != nums[k - 1]) nums[k++] = nums[i];
    return k;
  }
}
