package string;

/**
 * <p>Description : Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * <p>
 * For example, Given s = “eceba”,
 * <p>
 * T is "ece" which its length is 3.
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 * <p>Date : 2017/10/13 2:26
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters_159 {

    public static void main(String[] args) {
        String input = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(input));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[128];
        int counter = 0, begin = 0, end = 0, d = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++)]++ == 0)  counter++;//end 每次碰到新元素 counter就+1

            //下面这个循环使得子串再度满足题目条件
            while (counter > 2) {//当counter > 2的时候,意味着此时子串里有三个不一样的元素,counter 应该是要<= 2的,因为题目中要求最多出现2个不重复的元素
                if (map[s.charAt(begin)] == 1) {//只有某一个元素被彻底删除完了,counter才--,因为counter记录的是里面的元素种类
                    counter--;
                }
                map[s.charAt(begin)]--;
                begin++;
            }

            //最大值就在while循环外面更新
            d = Math.max(d, end - begin);
        }
        return d;

    }

}

