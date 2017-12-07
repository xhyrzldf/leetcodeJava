package main.java.string;

/**
 * Description : Given a string, determine if it is a palindrome, considering only alphanumeric
 * characters and ignoring cases.
 * <p>
 * <p>For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a
 * palindrome.
 * <p>
 * <p>Note: Have you consider that the string might be empty? This is a good question to ask during
 * an interview.
 * <p>
 * <p>For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * <p>描述:给定一个字符串，确定它是否是一个回文，只考虑字母数字字符和并且忽略大小写的情况。
 * <p>
 * <p>例如:“A man, a plan, a canal: Panama" is a palindrome.”是一个回文。“race a car”不是一个回文。
 * <p>
 * <p>注意:你是否考虑过字符串可能是空的?
 * <p>
 * <p>为了解决这个问题，我们将空字符串定义为有效的回文。
 * <p>
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 * <p>
 * <p>Date : 2017/10/10 23:37
 */
public class ValidPalindrome_125 {
    public static void main(String[] args) {
        String input = "0123456789";
        System.out.println(input.substring(3));

    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        // 利用正则直接替换,虽然速度相比于直接用unicode码来找会有些慢,但是在可以允许的时间房范围内这样我觉得代码和时间都是很好的
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
