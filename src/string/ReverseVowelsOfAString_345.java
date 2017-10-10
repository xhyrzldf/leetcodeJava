package string;

/**
 * Description : Write a function that takes a string as input and reverse only the vowels of a
 * string.
 *
 * <p>Example 1: Given s = "hello", return "holle".
 *
 * <p>Example 2: Given s = "leetcode", return "leotcede".
 *
 * <p>Note: The vowels does not include the letter "y".
 *
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 *
 * <p>Date : 2017/10/11 0:22
 */
public class ReverseVowelsOfAString_345 {
  public static void main(String[] args) {
    String input = "hello";
    System.out.println(reverseVowels01(input));
  }

  public static String reverseVowels(String s) {
    if (s == null || s.length() == 0) return s;

    char[] chars = s.toCharArray();
    int i = 0;
    int j = chars.length - 1;
    char temp;

    while (i < j) {
      while (!arrayContains01(chars[i]) && i < j) i++;
      while (!arrayContains01(chars[j]) && i < j) j--;
      chars[i] ^= chars[j];
      chars[j] ^= chars[i];
      chars[i++] ^= chars[j--];
    }

    return new String(chars);
  }

  /**
   * 建立布尔类型的128位数组,空间换时间
   *
   * @param s
   * @return
   */
  public static String reverseVowels01(String s) {
    if (s == null || s.length() == 0) return s;

    boolean[] vowel = new boolean[128];
    vowel['a'] = true;
    vowel['e'] = true;
    vowel['i'] = true;
    vowel['o'] = true;
    vowel['u'] = true;
    vowel['A'] = true;
    vowel['E'] = true;
    vowel['I'] = true;
    vowel['O'] = true;
    vowel['U'] = true;

    char[] chars = s.toCharArray();
    int i = 0;
    int j = chars.length - 1;

    while (i < j) {
      while (!vowel[chars[i]] && i < j) i++;
      while (!vowel[chars[j]] && i < j) j--;
      if (chars[i] != chars[j]) {
        chars[i] ^= chars[j];
        chars[j] ^= chars[i];
        chars[i] ^= chars[j];
      }
      i++;
      j--;
    }
    return new String(chars);
  }

  private static boolean arrayContains(char[] chars, char s) {
    for (char c : chars) if (c == s) return true;
    return false;
  }

  /**
   * 大小写英文字母直接和`32`进行或运算可以大写转小写,因为大写字母从65~90,小于64+32,所以32那位一定是0,
   *
   * <p>而小写的字母是97~122,32那位上一定是1,与32进行或运算,小写字母不变,大写字母转小写
   *
   * @param s
   * @return
   */
  private static boolean arrayContains01(char s) {
    s |= 32;
    return s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u';
  }
}
