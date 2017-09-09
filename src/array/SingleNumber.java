package array;

/**
 * Single Number
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using
 * extra memory?
 */
public class SingleNumber {

    public static int singleNumber01(int[] A) {
        if (A == null) return 0;
        int result = 0;
        //使用异或运算,根据 A^B = B^A , 0^A = A 因此 A ^ A = 0 ^ A ^ A = 0 ,这样所有个数为两个的数经过异或后都变成了0
        for (int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }
}
