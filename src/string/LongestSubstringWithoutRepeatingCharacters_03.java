package string;

/**
 * Description : Given a string, find the length of the longest substring without repeating
 * characters.
 *
 * <p>
 *
 * <p>Examples:
 *
 * <p>Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * <p>Given "bbbbb", the answer is "b", with the length of 1.
 *
 * <p>Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a
 * substring, "pwke" is a subsequence and not a substring.
 *
 * <p>描述:给定一个字符串，查找没有重复字符的最长子字符串的长度。
 *
 * <p>例:给出" abcabcbb "，答案是" abc "，长度为3。
 *
 * <p>给予" bbbbb "，答案是" b "，长度为1。
 *
 * <p>给定“pwwkew”，答案是“wke”，长度为3。注意，答案必须是一个子字符串，“pwke”是子字符串，而不是子字符串。
 *
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 *
 * <p>Date : 2017/10/11 22:18
 */
@SuppressWarnings("unused")
public class LongestSubstringWithoutRepeatingCharacters_03 {
  public int lengthOfLongestSubstring(String s) {
    int[] freq = new int[128];
    int begin = 0, end = 0, counter = 0, d = 0;
    while (end < s.length()) {
      // 1.确定计数器什么时候加,在这道题中是当出现重复元素的时候增加计数器，counter用于统计重复元素出现的次数
      // 也就是元素出现的频率大于0,然后增加他的出现频率,继续移动end
      if (freq[s.charAt(end++)]++ > 0) counter++;
      // 2.确定什么时候修正这个子串使得子串得以继续满足条件
      // 在这里是出现重复元素的时候就要进行修正,此时counter应该至少为1
      // 何时减少这个计数器,当begin的元素是重复的元素的时候,那重复的元素频率应该至少为2，频率为0代表还没出现的,频率为1代表已经出现了1次
      // 所以应该是频率 >= 2 的时候 减少这个计数,随后减少这个频率并且移动begin
      while (counter >= 1) if (freq[s.charAt(begin++)]-- >= 2) counter--;
      // 3.经过前面两步,此时的子串为[begin,end),所以长度就是end-begin,记录这个长度
      d = Math.max(d, end - begin);
    }
    return d;
  }

  public int lengthOfLongestSubstring01(String s) {

    int l = 0, r = -1, n = s.length(); // 滑动数组[l,r]
    int[] freq = new int[128]; // 使用128位数组来存储每个字母的状态
    int res = 0;

    while (l < n) {
      if (r + 1 < n && freq[s.charAt(r + 1)] == 0) freq[s.charAt(++r)]++;
      else freq[s.charAt(l++)]--;
      res = Math.max(res, r - l + 1);
    }

    return res;
  }

  public int lengthOfLongestSubstring02(String s) {
    int[] freq = new int[128];
    int res = 0, n = s.length();

    for (int start = 0, i = 0; i < n; i++) {
      start = Math.max(freq[s.charAt(i)], start);
      res = Math.max(res, i - start + 1);
      freq[s.charAt(i)] = i + 1;
    }

    return res;
  }
}
