package array;

import java.util.Arrays;

/**
 * Single Number Given an array of integers, every element appears twice except for one. Find that
 * single one. Note: Your algorithm should have a linear runtime complexity. Could you implement it
 * without using extra memory? 翻译: 寻找单身数字 给定一个int类型的数组,除了一个数字,其余的每个数字都出现了两次,找到这个单身的数字 :) 提示
 * 你的算法应该拥有线性的复杂度,也就是说为O(n)或者O(1),你能不使用额外内存的空间下解决这个问题咩?
 */
@SuppressWarnings("unused")
public class SingleNumber_136 {

  /**
   * 这是使用异或操作的解法得
   *
   * @param A 给定的数组
   * @return 那个单身数字, 如果没有就返回0
   */
  public int singleNumber01(int[] A) {
    if (A == null) return 0; // 这里是非空判断123
    int result = 0;
    // 使用异或运算,根据 A^B = B^A , 0^A = A 因此 A ^ A = 0 ^ A ^ A = 0 ,这样所有个数为两个的数经过异或后都变成了0
    for (int aA : A) {
      result ^= aA;
    }
    return result;
  }

  /**
   * 这是正常思维的解法 正常思维遇见这类问题,排序会让问题简化许多
   *
   * @param A 给定的数组
   * @return 那个单身数字, 如果没有就返回
   */
  public int singleNumber02(int[] A) {
    if (A == null) return 0;
    Arrays.sort(A);//nlogn 级别的排序,这里省略具体实现,使用类库中的
    if (A[0] != A[1]) return A[0]; // 这里使用将A里的元素与前面的元素作比较,如果不同就返回该元素,这一行是对第一条数据特殊处理
    for (int i = 1; i < A.length; i++) {
      if (A[i] != A[i - 1]) return A[i];
    }
    return 0; // 如果都没找到的话,返回 0
  }
}
