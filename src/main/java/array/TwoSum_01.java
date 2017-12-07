package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：Two Sum
 *
 * <p>Given an array of integers, return indices of the two numbers such that they add up to a
 * specific target.
 *
 * <p>You may assume that each input would have exactly one solution. Example: Given nums = [2, 7,
 * 11, 15], target = 9,
 *
 * <p>Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 * <p>翻译: 两数之和 给定一个整形数组和一个整数target，返回2个元素的下标，它们满足相加的和为target。 你可以假定每个输入，都会恰好有一个满足条件的返回结果
 */
@SuppressWarnings("unused")
public class TwoSum_01 {

  public int[] twoSum(int[] nums, int target) {
    if (nums == null) return new int[] {-1, -1};
    Map<Integer, Integer> map = new HashMap<>(); // 答案MAP，用于存储答案，key为数字,value为在数字集合中下标位置

    for (int i = 0; i < nums.length; i++) {
      Integer exceptNum = target - nums[i]; // 期望的答案
      if (map.containsKey(exceptNum)) return new int[] {map.get(exceptNum), i}; // 如果寻找到答案了,直接返回
      else map.put(nums[i], i); // 如果没有找到对应的答案,那么就把这个数本身作为答案放入答案map，根据a+b=b+a,正在遍历的数即是请求也是答案
    }
    return new int[] {-1, -1};
  }

  public int[] twoSum01(int[] arr, int target) {

    if (arr == null) return new int[] {-1, -1};

    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] + arr[j] == target) return new int[] {i, j};
      }
    }

    return new int[] {-1, -1};
  }
}
