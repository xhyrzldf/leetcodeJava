package main.java.string;

/**
 * Description : Given two strings A and B, find the minimum number of times A has to be repeated
 * such that B is a substring of it. If no such solution, return -1.
 * <p>
 * <p>For example, with A = "abcd" and B = "cdabcdab".
 * <p>
 * <p>Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B
 * is not a substring of A repeated two times ("abcdabcd").
 * <p>
 * <p>Note: The length of A and B will be between 1 and 10000.
 * <p>
 * <p>描述:给定两个字符串A和B，找到A必须重复的最小次数，这样B就是它的子串。如果没有这样的解决方案，返回- 1。
 * <p>
 * <p>例如 A = " abcd " , B = " cdabcdab "。
 * <p>
 * <p>返回3，因为重复了3次(“abcdabcdabcd”)，B是它的子串;B不是重复两次的子串(“abcdabcd”)。
 * <p>
 * <p>注:A和B的长度在1到10000之间。
 * <p>
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 * <p>
 * <p>Date : 2017/10/13 23:25
 */
public class RepeatedStringMatch_686 {
    public static void main(String[] args) {
        String inputA = "ab";
        String inputB = "a";
        System.out.println(repeatedStringMatch(inputA, inputB));
    }

    public static int repeatedStringMatch(String A, String B) {
        int count = 0;
        StringBuilder repeatSB = new StringBuilder();
        while (repeatSB.length() < B.length()) {
            repeatSB.append(A);
            count++;
        }
        if (repeatSB.toString().contains(B)) return count;
        if (repeatSB.append(A).toString().contains(B)) return count + 1;
        return -1;
    }

}
