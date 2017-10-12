package string;

/**
 * Description : Given a string S and a string T, find the minimum window in S which will contain
 * all the characters in T in complexity O(n).
 * <p>
 * <p>For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * <p>
 * <p>Note: If there is no such window in S that covers all characters in T, return the empty string
 * "". If there are multiple such windows, you are guaranteed that there will always be only one
 * unique minimum window in S.
 * <p>
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 * <p>
 * <p>Date : 2017/10/13 0:17
 */
public class MinimumWindowSubstring_76 {
    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        System.out.println(minWindow(S, T));
    }

    public static String minWindow(String s, String t) {
        int hash[] = new int[128];
        int left = 0, right = 0, count = t.length();
        String minString = null;
        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        while (left < s.length()) {
            if (hash[s.charAt(left)] >= 1) {
                right = left;

                while (count != 0 && right < s.length()) {
                    if (hash[s.charAt(right)] >= 1) {
                        count--;
                    }

                    hash[s.charAt(right)]--;
                    right++;
                }

                if (count == 0 && (minString == null || right - left < minString.length()))
                    minString = s.substring(left, right);

                count = t.length();

                for (char c : t.toCharArray()) {
                    hash[c] = 0;
                }

                for (char c : t.toCharArray()) {
                    hash[c]++;
                }


            }
            left++;
        }
        return minString == null ? "" : minString;


    }
}
