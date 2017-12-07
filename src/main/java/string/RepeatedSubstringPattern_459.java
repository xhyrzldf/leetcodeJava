package main.java.string;

/**
 * <p>Description : Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * <p>
 * Example 1:
 * Input: "abab"
 * <p>
 * Output: True
 * <p>
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * <p>
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 * <p>
 * Output: True
 * <p>
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 * <p>
 * 描述:给定一个非空字符串检查，如果它可以通过提取它的子字符串并将多个子字符串的副本附加在一起来构造它。
 * 您可以假设给定的字符串仅由小写的英文字母组成，它的长度不会超过10000。
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 * <p>Date : 2017/10/14 6:03
 */
public class RepeatedSubstringPattern_459 {

    /**
     * solution 01 ,complexity O(n√n) , 48ms
     *
     * @param str
     * @return
     */
    public boolean repeatedSubstringPattern01(String str) {
        int l = str.length();
        for (int i = l / 2; i >= 1; i--) {
            if (l % i == 0) {
                int m = l / i;
                String subS = str.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                if (sb.toString().equals(str)) return true;
            }
        }
        return false;
    }


    /**
     * solution01 update ,constant level optimize,18ms
     *
     * @param str
     * @return
     */
    public boolean repeatedSubstringPattern02(String str) {
        int len = str.length();
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                int m = len / i;
                String subS = str.substring(0, i);
                int j;
                for (j = 1; j < m; j++) {
                    if (!subS.equals(str.substring(j * i, i + j * i))) break;
                }
                if (j == m)
                    return true;
            }
        }
        return false;
    }

    /**
     * Use the jdk library 'startsWith'，Simplify the code , time is 28ms , very good ! :)
     *
     * @param str
     * @return
     */
    public boolean repeatedSubstringPattern03(String str) {
        int n = str.length();
        for (int i = 1; i <= n / 2; i++)
            if (n % i == 0 && str.startsWith(str.substring(i)))
                return true;
        return false;
    }

    /**
     * amazing solution , SS double = SSSS ,take out the first and the last character
     * it became Sx SS Sy ,then check if SxSSSy contains SS ,take 65ms ,still very good
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern04(String s) {
        return (s + s).substring(1, s.length() + s.length() - 1).contains(s);
    }

    /**
     * the KMP solution ways ,use the next array to check every part of Str ,take 20ms
     *
     * @param str
     * @return
     */
    public boolean repeatedSubstringPattern05(String str) {
        //This is the kmp issue
        int[] prefix = kmp(str);
        int len = prefix[str.length() - 1];
        int n = str.length();
        return (len > 0 && n % (n - len) == 0);
    }

    private int[] kmp(String s) {
        int len = s.length();
        int[] res = new int[len];
        char[] ch = s.toCharArray();
        int i = 0, j = 1;
        res[0] = 0;
        while (i < ch.length && j < ch.length) {
            if (ch[j] == ch[i]) {
                res[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    res[j] = 0;
                    j++;
                } else {
                    i = res[i - 1];
                }
            }
        }
        return res;
    }

}
