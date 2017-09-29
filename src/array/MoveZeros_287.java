package array;


import sun.java2d.pipe.AAShapePipe;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * <p>
 * 1.You must do this in-place without making a copy of the array.
 * <p>
 * 2.Minimize the total number of operations.
 * <p>
 * <p>
 * <p>
 * 给定一个数组nums，编写一个函数将所有0移动到它的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 例如，给定nums =[0,1,0,3,12]，在调用函数后，nums应该是[1,3,12,0,0]。
 * <p>
 * 注意:
 * <p>
 * 1。您必须在不需要复制数组的情况下这样做。
 * <p>
 * 2。最小化操作的总数。
 */
public class MoveZeros_287 {
    public void moveZeroes(int[] nums) {

        int k = 0; //nums[0,k)范围内元素都不等于0

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (k != i) {
                    nums[k++] = nums[i];
                    nums[i] = 0;
                } else k++;
            }
        }
    }


}
