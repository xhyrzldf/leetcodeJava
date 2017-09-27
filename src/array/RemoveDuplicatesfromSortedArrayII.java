package array;

/**
 * Follow up for ”Remove Duplicates”:
 * What if duplicates are allowed at most twice?For example, Given sorted array A = [1,1,1,2,2,3]
 * Your function should return length = 5, and A is now [1,1,2,2,3]
 * 翻译:承接移出重复的数字
 * 如果每个数字要求保留最多出现两次呢?例如,给定一个排序好的数组 A=[1,1,1,2,2,3]
 * 你的方法应该返回长度为5 , 并且A 是 [1,1,2,2,3]
 */
@SuppressWarnings("unused")
public class RemoveDuplicatesfromSortedArrayII {

    public static int RemoveDuplicatesfromSortedArrayII01(int[] A) {
        if (A == null) return 0;
        int index = 0;
        int count = 1;//思路与移出重复数字I的题目一样,只是这里多加一个变量用于计数
        for (int i = 0; i < A.length; i++) {
            if (index == 0 || A[i] != A[index - 1]) {
                A[index++] = A[i];
                count = 1;//每次寻找到新的数字的时候重置这个统计数字变量,这样保证每个数字最多可以出现2次
            } else {
                if (count >= 2) {//允许重复的数字出现2次,如果超过2次了,就跳过
                    continue;
                }
                A[index++] = A[i];
                count++;
            }
        }
        return index;
    }
}
