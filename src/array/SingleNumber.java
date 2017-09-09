package array;

/**
 * Single Number
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using
 * extra memory?
 * 翻译: 寻找单身数字
 * 给定一个int类型的数组,除了一个数字,其余的每个数字都出现了两次,找到这个单身的数字 :)
 * 提示 你的算法应该拥有线性的复杂度,也就是说为O(n)或者O(1),你能不使用额外内存的空间下解决这个问题咩?
 */
public class SingleNumber {

    public static int singleNumber01(int[] A) {
        if (A == null) return 0;
        int result = 0;
        //使用异或运算,根据 A^B = B^A , 0^A = A 因此 A ^ A = 0 ^ A ^ A = 0 ,这样所有个数为两个的数经过异或后都变成了0
        for (int aA : A) {
            result ^= aA;
        }
        return result;
    }
}
