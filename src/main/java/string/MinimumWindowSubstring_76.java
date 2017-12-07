package string;

/**
 * Description : Given a string S and a string T, find the minimum window in S which will contain
 * all the characters in T in complexity O(n).
 *
 * <p>For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 *
 * <p>Note: If there is no such window in S that covers all characters in T, return the empty string
 * "". If there are multiple such windows, you are guaranteed that there will always be only one
 * unique minimum window in S.
 *
 * <p>描述:给定一个字符串S和一个字符串T，在S中找到最小的滑动数组，时间复杂度为O(n)。
 *
 * <p>例如，S = " ADOBECODEBANC " T = " ABC "最小滑动数组是" BANC "。
 *
 * <p>注:如果S中没有包含T的所有字符的滑动数组，则返回空字符串""。假设在S中始终只有一个惟一的最小滑动数组(多种情况下返回任意一个即可)。
 *
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 *
 * <p>Date : 2017/10/13 0:17
 */
public class MinimumWindowSubstring_76 {
  public static void main(String[] args) {
    String S = "ADOBECODEBANC";
    String T = "ABC";
    System.out.println(minWindow(S, T));
  }

  public static String minWindow(String s, String t) {
      int[] freq = new int[128];
      for (char c : t.toCharArray()) freq[c]++;
      int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
      while (end < s.length()) {
          // 计数器默认为子串t的长度,初始化的时候,子串t中的元素频率默认为1,非t中的频率为0
          // 1.确定计数器什么时候怎样变化
          // 当遍历到子串t中的任意一个字母的时候,计数器要-1
          // 所以在这里当频率大于0或者说大于等于1的时候,证明遍历到了t中的字符,计数器要-1
          if (freq[s.charAt(end++)]-- > 0) counter--; // in t
          // 2.计数器修正,当counter == 0 的时候证明这个子串已经符合条件了,子串为[begin,end),长度为end-begin
          while (counter == 0) { // valid
              if (end - begin < d) d = end - (head = begin); // 此时记录下最小的d,并且记录此时的begin
              // 修正计数器,使其再度不平衡,以寻找后面的字符串
              // 计数器需要修正的条件是当begin kick掉的元素是子串t中的元素时,counter应该增加
              // 此时,[begin,end)这个子串中,t中的元素应该是0,非t元素应该是<0的,所以==0 意味着这个元素是t中的元素
              // 此时counter计数器应该-1
              if (freq[s.charAt(begin++)]++ == 0) counter++; // make it invalid
          }
      }
      // 最终根据d来确定,如果D没变,那么返回空,否则返回之前while里保存的那个字符串
      return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
  }
}
