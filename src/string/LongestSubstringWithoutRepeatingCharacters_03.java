package string;

/**
 * Description : Given a string, find the length of the longest substring without repeating
 * characters.
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
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 *
 * <p>Date : 2017/10/11 22:18
 */
public class LongestSubstringWithoutRepeatingCharacters_03 {
  public int lengthOfLongestSubstring(String s) {

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

  public int lengthOfLongestSubstring01(String s) {
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
