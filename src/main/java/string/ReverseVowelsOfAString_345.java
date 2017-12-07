package main.java.string;

/**
 * Description : Write a function that takes a string as input and reverse only the vowels of a
 * string.
 * <p>
 * <p>Example 1: Given s = "hello", return "holle".
 * <p>
 * <p>Example 2: Given s = "leetcode", return "leotcede".
 * <p>
 * <p>Note: The vowels does not include the letter "y".
 * <p>
 * <p>描述:编写一个函数，它以字符串作为输入，只返回字符串的元音。
 * <p>
 * <p>示例1:给定s = " hello "，返回" holle "。
 * <p>
 * <p>示例2:给定s = " leetcode "，返回" leotcede"。
 * <p>
 * <p>注:元音不包括字母“y”。
 * <p>
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 * <p>
 * <p>Date : 2017/10/11 0:22
 */
public class ReverseVowelsOfAString_345 {
    public static void main(String[] args) {
        System.out.println('a' | 32);
    }

    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;

        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;

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
     * 96 = 64 + 32 = 2^6 + 2^5 = 0x 1100000
     * <96 0x 10????
     * 32 0x 010000
     * A  0x 11????
     * <p>
     * >96 0x 11?????
     * 32 0x 0100000
     * A  0x 11?????
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
