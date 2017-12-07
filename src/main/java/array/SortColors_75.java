package array;

/**
 * Description : leetcodeJava
 * <p>
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 * <p>
 * <p>Date : 2017/10/10 17:09
 */
public class SortColors_75 {
    /**
     * 使用三路快排的思想来解决
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
    /* nums[0,zero] == 0 , nums[two,nums.length - 1] */
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) i++;
            else if (nums[i] == 0) swap(nums, i++, ++zero);
            else swap(nums, i, --two);
        }
    }

    /**
     * 交换数组元素的辅助函数
     *
     * @param nums
     * @param x
     * @param y
     */
    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    /**
     * 计数排序的思路
     *
     * @param nums
     */
    public void sortColors02(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int[] count = new int[3];
        for (int i : nums) {
            count[i]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < count[0]) {
                nums[i] = 0;
            } else if (i < count[0] + count[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
