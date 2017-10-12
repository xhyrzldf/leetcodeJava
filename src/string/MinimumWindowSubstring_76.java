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
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;
        int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) counter--; //in t
            while (counter == 0) { //valid
                if (end - begin < d) d = end - (head = begin);
                if (map[s.charAt(begin++)]++ == 0) counter++;  //make it invalid
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}
