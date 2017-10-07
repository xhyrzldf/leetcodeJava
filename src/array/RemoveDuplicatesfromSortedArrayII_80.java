package array;

/**
 * Follow up for ”Remove Duplicates”: What if duplicates are allowed at most twice?For example,
 * Given sorted array A = [1,1,1,2,2,3] Your function should return length = 5, and A is now
 * [1,1,2,2,3] 翻译:承接移出重复的数字 如果每个数字要求保留最多出现两次呢?例如,给定一个排序好的数组 A=[1,1,1,2,2,3] 你的方法应该返回长度为5 , 并且A 是
 * [1,1,2,2,3]
 */
@SuppressWarnings("unused")
public class RemoveDuplicatesfromSortedArrayII_80 {

  public static int RemoveDuplicatesfromSortedArrayII01(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int k = 1;
    int count = 1; // 思路与移出重复数字I的题目一样,只是这里多加一个变量用于计数,默认为1,因为我们是从第二个数开始遍历的
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[k - 1]) {
        nums[k++] = nums[i];
        count = 1; // 每次寻找到新的数字的时候将count赋值为1
      } else {
        if (count >= 2) { // 允许重复的数字出现2次,如果超过2次了,就跳过
          continue;
        }
        nums[k++] = nums[i];
        count++;
      }
    }
    return k;
  }
}
