package string;

/**
 * Description : Given a string, find the length of the longest substring T that contains at most 2
 * distinct characters.
 * <p>
 * <p>For example, Given s = “eceba”,
 * <p>
 * <p>T is "ece" which its length is 3.
 * <p>
 * <p>描述:给定一个字符串，查找包含最多2个不同字符的最长子字符串T的长度。
 * <p>
 * <p>例如，给定s = " eceba "，
 * <p>
 * <p>T是" ece "，其长度为3。
 * <p>
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 * <p>
 * <p>Date : 2017/10/13 2:26
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters_159 {

    public static void main(String[] args) {
        String input = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(input));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        // 0.初始化元素 [begin,end),本体是求最大值,counter的定义是滑动数组中,不重复的元素的个数
        int begin = 0, end = 0, counter = 0, d = 0;
        int[] freq = new int[128];
        // 1.确定counter的变化情况
        // 这里是如果碰到第一次出现的元素,也就是频率 ==0 ,那么counter++
        while (end < s.length()) {
            if (freq[s.charAt(end++)]++ == 0) counter++;
            // 2.确定counter达到目标值之后的操作以及修正情况
            // 在这里的条件是最多2个不重复的元素,也就是说当counter > 2就要进行修正,因为是最大值,所以是先修正再记录
            // counter的修正条件特征是 当某一个元素彻底被删除了,counter才变化
            while (counter > 2) if (freq[s.charAt(begin++)]-- == 1) counter--;
            // 3.确定返回值,因为滑动数组为[begin,end),所以长度是end-begin
            d = Math.max(d, end - begin);
        }
        return d;
    }
}
