package string;

/**
 * Description : Given a string s, find the longest palindromic substring in s. You may assume that
 * the maximum length of s is 1000.
 * <p>Example:
 * <p>Input: "babad"
 * <p>Output: "bab"
 * <p>Note: "aba" is also a valid answer. Example:
 * <p>Input: "cbbd"
 * <p>Output: "bb"
 * <p>
 * <p>描述:给定一个字符串s，在s中找到最长的回文子串。你可以假设s的最大长度是1000。
 * <p>输入:“babad” 输出:“bab”
 * <p>注:“aba”也是一个有效的答案。
 * <p>示例:输入:“cbbd” 输出:“bb”
 * <p>Date : 2017/10/26 16:21
 * <p>@author : Matrix [xhyrzldf@foxmail.com]
 */
public class LongestPalindromicSubstring_05 {
    private int index, maxLength;

    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;

        for (int i = 0; i < n-1 ; i++) {
            extensionSubstring(s,i,i);
            extensionSubstring(s,i,i+1);
        }

        return s.substring(index, index + maxLength);
    }

    private void extensionSubstring(String s, int left, int right) {
        //回文子串为(left,right),即保证[left+1,right-1]这一部分是回文子串
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (maxLength < right - left - 1) {
            maxLength = right - left - 1;
            index = left + 1;
        }
    }
}
