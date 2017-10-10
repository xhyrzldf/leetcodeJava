package array;

/**
 * Description : Given an array of integers that is already sorted in ascending order, find two
 * numbers such that they add up to a specific target number.
 *
 * <p>The function twoSum should return indices of the two numbers such that they add up to the
 * target, where index1 must be less than index2. Please note that your returned answers (both
 * index1 and index2) are not zero-based.
 *
 * <p>You may assume that each input would have exactly one solution and you may not use the same
 * element twice.
 *
 * <p>Input: numbers={2, 7, 11, 15}, target=9
 *
 * <p>Output: index1=1, index2=2
 *
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 *
 * <p>Date : 2017/10/10 16:25
 */
public class TwoSumII_167 {
  public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    if (numbers == null || numbers.length < 2) return result;

    // 前指针是l,后指针是r
    int l = 0;
    int r = numbers.length - 1;
    int answer = 0;

    /* 如果nums[l] + numbers[r] = target,那么直接返回
    如果小于,那么前指针后移一位,这样nums[l] + nums[r] 就会变大,逐渐向target靠拢(利用了数组本身是有序的这个特性)
    如果大于后指针前移一位,这样nums[l] + nums[r] 就会变小,逐渐向target靠拢(利用了数组本身是有序的这个特性)
    * */
    while (l < r) {
      answer = numbers[l] + numbers[r];
      if (answer == target) {
        result[0] = l + 1;
        result[1] = r + 1;
        break;
      } else if (answer < target) l++;
      else r--;
    }

    return result;
  }
}
