package main.java.string;

/**
 * <p>Description : Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * <p>Example 2:
 * Input:
 * <p>
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 * <p>
 * <p>给定一个字符串s，找到s中最长的子序列的长度。你可以假设s的最大长度是1000。
 * <p>例1:输入: "bbbab" 输出:4 可能最长的palindromic子序列是“bbbb”。
 * <p>例2:输入: " cbbd "输出:2 可能最长的palindromic子序列是bb。
 * <p>Date : 2017/10/26 17:39
 * <p>@author : Matrix [xhyrzldf@foxmail.com]
 */
public class LongestPalindromicSubsequence_516 {
    private int maxLength;

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len <= 1) return 1;
        for (int i = 0; i < len - 1; i++) {
            extensionSubString(s, i, i); //odd
            extensionSubString(s, i, i + 1); //even
        }
        return maxLength;
    }

    private void extensionSubString(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        maxLength = Math.max(right - left - 1, maxLength);
    }

}
