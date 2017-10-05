package array;

/**
 * RemoveDuplicatesFromSortedArray_26
 * Given a sorted array, remove the duplicates in place such that each element appear only once
 * and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * 翻译 从有序数组中移出重复的元素
 * 给定一个排序的数组,移除里面重复的元素这样每一个元素只出现一次,并且返回新的长度
 * 不要使用为新的数组开辟额外的内存空间,你必须在原数组的内存空间上操作
 * 局格子里,给定一个输入数组[1,1,2]
 * 你的方法应该返回 2 ,并且A数组时[1,2]
 * ps：对于java语言来说,在不使用额外的内存空间的情况下数组长度是不能改变滴,所以这道题
 * 可以转变为例如给定数组为[1,2,3,3,5,5],返回结果长度应该为4,数组可以变为[1,2,3,5,x,x] x代表任意字符即可
 */
@SuppressWarnings("unused")
public class RemoveDuplicatesFromSortedArray_26 {

    public int removeDuplicates01(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return 1;
        int count = 1; //用于统计非重复数字的数量,长度大于1,所以就从1开始计,便于理解
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[count - 1]) { //理解这段可以理解为i是数组的一个标记,count也是一个标记,i是遍历的标记,count是非重复数字的标记
                A[count] = A[i]; //如果判断过了,说明当前遍历的A[i]是一个独立的数字(因为数字是有序的),将A[count]的值变为A[i]
                count++;//同时count标记往后推一位
            }
        }
        return count;
    }

    //02方法呢就是对01方法的一些简化写法,可以对比一下
    public int removeDuplicates02(int[] A) {
        if (A == null || A.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (count == 0 || A[i] != A[count - 1]) {
                A[count++] = A[i];
            }
        }
        return count;
    }
}
