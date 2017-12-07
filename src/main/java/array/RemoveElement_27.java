package array;

/**
 * Given an array and a value, remove all instances of that value in place and return the new
 * length.
 * <p>
 * <p>Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * <p>The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * <p>Example: Given input array nums = [3,2,2,3], val = 3
 * <p>
 * <p>Your function should return length = 2, with the first two elements of nums being 2.
 * <p>
 * <p>翻译: 给定一个数组一个目标值,移除那个数组中所有等于这个目标值的元素,然后返回剩下元素的个数
 * 不要分配额外的空间给另一个数组,你需要在常数级别的内存空间完成这些操作,元素的顺序可以被改变并且在你留下什么元素并不重要 只要在你返回的元素的个数前面就好 举个例子, 给定的数组是
 * [3,2,2,3],目标值是 3 ,那么返回的元素个数就应该是2,原来数组的前2位页应该是2
 */
public class RemoveElement_27 {
    // 这类题目使用一个标记来标记正确的答案应该放入的位置,效果会好
    // i表示正在遍历的元素的位置,j表示下一个正确元素应该插入的位置的位置
    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val && i != j++) {
                nums[j - 1] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {2};
        int target = 3;
        System.out.println(removeElement(arr, target));
        System.out.println("print array elements ");
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
