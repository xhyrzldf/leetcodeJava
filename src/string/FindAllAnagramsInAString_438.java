package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s. Strings consists of lowercase English letters only and the length of both strings
 * s and p will not be larger than 20,100. The order of output does not matter.
 *
 * <p>
 *
 * <p>Example 1: Input: s: "cbaebabacd" p: "abc"
 *
 * <p>
 *
 * <p>Output: [0, 6]
 *
 * <p>
 *
 * <p>Explanation: The substring with start index = 0 is "cba", which is an anagram of "abc". The
 * substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * <p>
 *
 * <p>描述:给定一个字符串s和一个非空字符串p，查找所有p 的异序词(即字符元素相同,顺序可以不同)的起始索引。
 * 字符串由小写的英文字母组成，字符串s的长度和p的长度不会大于20,100,输出的顺序无关紧要。
 *
 * <p>
 *
 * <p>示例1:输入:s:“cbaebabacd” p:“abc”
 *
 * <p>
 *
 * <p>输出:(0,6)
 *
 * <p>
 *
 * <p>解释: 下标= 0开始的子字符串是“cba”,这是一种“abc”的异序词。带有start index = 6的子字符串是“bac”，它也是“abc”的一个异序词。
 *
 * <p>
 *
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 *
 * <p>
 *
 * <p>Date : 2017/10/11 23:25
 */
public class FindAllAnagramsInAString_438 {
  public static void main(String[] args) {
    String s = "dabc";
    String p = "abc";

    System.out.println(findAnagrams(s, p).toString());
  }

  public static List<Integer> findAnagrams(String s, String p) {

    // 0.初始化一些变量,subString为[begin,end）
    List<Integer> list = new ArrayList<>();
    // null和空的判断,简单的写一下 null
    if (s == null || s.length() == 0 || p ==null|| p.length() == 0) return list;
    int begin = 0, end = 0, counter = p.length();
    int[] freq = new int[128];
    for (char c : p.toCharArray()) freq[c]++;
    // 1.确定计数器在什么条件下进行怎么样的变化
    // 这里是当碰到子串p中的元素的时候,计数器要-1
    // 而子串P中元素的频率初始化为1,所以这里条件应该是 > 0 , 不管怎么样, 碰到的元素频率都要-1
    while (end < s.length()) {
      if (freq[s.charAt(end++)]-- > 0) counter--;
      // 2.当计数器条件满足的时候,要进行怎么样的操作,然后通过修正计数器跳出这个while
      // 2-1,当counter == 0 的时候,意味着当前子串是符合条件的,加入list集合
      // 2-2,修正计数器,这里有点变化,这里不能直接在while里修正,因为要保证子串里所有的元素都要是p子串中的
      // 因此修正步骤要先判断,如果当前子串的长度等于了p的长度,那么就要进行修正了,因为counter==0的情况下
      // 有可能是例如abdc这种字符串,长度已经大于p了,但是counter也为0,所以这里的计数器修正要变化一下
      // counter变化的条件就是begin kick掉的元素是属于p字符串的,特征是freq频率>=0 因为默认至少为1,所以-1了之后至少为0
      if (counter == 0) list.add(begin);
      if (end - begin == p.length() && freq[s.charAt(begin++)]++ >= 0) counter++;
    }
    // 3.返回结果.
    return list;
  }

  public List<Integer> findAnagrams01(String s, String p) {
    List<Integer> list = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
    int[] hash = new int[256];
    for (char c : p.toCharArray()) hash[c]++;

    // 滑动数组为arr[left,right],count为需要达到的数组长度
    int left = 0, right = -1, count = p.length();
    while (right + 1 < s.length()) {
      if (hash[s.charAt(++right)]-- >= 1) count++;
      if (count == p.length()) list.add(left);
      if (right - left + 1 == p.length() && hash[s.charAt(left++)]++ >= 0) count--;
    }

    return list;
  }
}
