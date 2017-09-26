package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：Two Sum
 * <p>Given an array of integers, return indices of the two numbers such that they add up to a specific target.</p>
 * <p>You may assume that each input would have exactly one solution.</p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>翻译: 两数之和</p>
 * 给定一个整形数组和一个整数target，返回2个元素的下标，它们满足相加的和为target。
 * 你可以假定每个输入，都会恰好有一个满足条件的返回结果
 */
public class TwoSum {
    public int[] twoSum(int[] A, int target) {
        if (A == null) return new int[]{0, 0};
        Map<Integer, Integer> map = new HashMap<>();// 答案MAP，用于存储答案，key为数值,value为在集合中下标

        for (int i = 0; i < A.length; i++) {
            Integer answer = map.get(target - A[i]);//寻找答案,这里的answer是答案的下标
            if (answer == null) {
                map.put(A[i], i);//如果没有找到对应的答案,那么就把这个数本身作为答案放入答案map，根据a+b=b+a,正在遍历的数即是请求也是答案
            } else {
                int answerIndex = map.get(answer);//如果找到答案了,从map中取出对应的答案下表,返回回去
                return new int[]{answerIndex, i};
            }
        }
        return new int[]{0, 0};
    }
}
