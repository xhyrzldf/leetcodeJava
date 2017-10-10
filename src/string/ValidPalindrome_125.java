package string;

/**
 * Description : Given a string, determine if it is a palindrome, considering only alphanumeric
 * characters and ignoring cases.
 *
 * <p>For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a
 * palindrome.
 *
 * <p>Note: Have you consider that the string might be empty? This is a good question to ask during
 * an interview.
 *
 * <p>For the purpose of this problem, we define empty string as valid palindrome.
 *
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 *
 * <p>Date : 2017/10/10 23:37
 */
public class ValidPalindrome_125 {
  public boolean isPalindrome(String s) {
    if (s.isEmpty()) {
      return true;
    }
    //利用正则直接替换,虽然速度相比于直接用unicode码来找会有些慢,但是在可以允许的时间房范围内这样我觉得代码和时间都是很好的
    s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    int n = s.length();
    for (int i = 0; i < n / 2; i++) {
      if (s.charAt(i) != s.charAt(n - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
