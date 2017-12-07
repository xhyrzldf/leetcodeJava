package sort;

/**
 * @Description @Author matrix[xhyrzldf@foxmail.com] @Date 2017/9/16 22:17
 */
@SuppressWarnings("WeakerAccess")
public class BucketSort {
    /**
     * 桶排序
     *
     * @param array ok
     */
    public static void bucketSort(int[] array) {
        // 获得数组中的最大值,确定桶的数量
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        // 构建出这样一个桶数组,长度为最大值+12
        int[] bucketArray = new int[array[maxIndex] + 1];
        // 统计原数组,将统计到的数字放到桶数组里
        for (int anArray : array) {
            bucketArray[anArray]++;
        }
        // 将桶数组里的数字放入原数组替换
        for (int i = 0, j = 0; i < bucketArray.length; i++) {
            while (bucketArray[i] > 0) {
                array[j] = i;
                j++;
                bucketArray[i]--;
            }
        }
    }
}
