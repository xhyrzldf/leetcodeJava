package string;

/**
 * Description : Write a function that takes a string as input and returns the string reversed.
 *
 * <p>Example: Given s = "hello", return "olleh" . "good" , return "doog"
 *
 * <p>描述:编写一个函数，它以字符串作为输入，并将字符串返回。
 *
 * <p>示例:给定s = " hello "，返回" olleh "。“good”，返回“doog”
 *
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 *
 * <p>Date : 2017/10/10 23:43
 */
public class ReverseString_344 {
  public String reverseString(String s) {
    if (s == null || s.length() == 0) return s;

    char[] chars = s.toCharArray();
    int i = 0;
    int j = chars.length - 1;
    while (i < j) {
      chars[i] ^= chars[j];
      chars[j] ^= chars[i];
      chars[i++] ^= chars[j--];
    }
    return new String(chars);
  }

  public String reverseString01(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      sb.append(s.charAt(i));
    }
    return sb.toString();
  }
}
