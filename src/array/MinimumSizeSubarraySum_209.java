package array;

/**
 * Description : Given an array of n positive integers and a positive integer s, find the minimal
 * length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead. For
 * example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under
 * the problem constraint.
 *
 * <p>More practice: If you have figured out the O(n) solution, try coding another solution of which
 * the time complexity is O(n log n).
 *
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 *
 * <p>Date : 2017/10/11 21:34
 */
public class MinimumSizeSubarraySum_209 {
  /**
   * 使用双索引构建一个动态的数组,并不断计算里面的和,通过一个个的增加或者减少来计算和,避免大量的重复计算
   *
   * @param s
   * @param nums
   * @return
   */
  public int minSubArrayLen(int s, int[] nums) {
    int l = 0, r = -1, n = nums.length; // 动态数组为 [i,j]
    int sum = 0;
    int res = Integer.MAX_VALUE;

    while (l < n) {
      if (r + 1 < n && sum < s) sum += nums[++r];
      else sum -= nums[l++];
      if (sum >= s) res = Math.min(res, r - l + 1);
    }

    return res == Integer.MAX_VALUE ? 0 : res;
  }
}
