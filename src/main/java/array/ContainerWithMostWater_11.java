package main.java.array;

/**
 * Description : Given n non-negative integers a1, a2, ..., an, where each represents a point at
 * coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i,
 * ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the
 * container contains the most water.
 * <p>
 * <p>Note: You may not slant the container and n is at least 2.
 * <p>
 * <p>Author : Matrix [xhyrzldf@foxmail.com]
 * <p>
 * <p>Date : 2017/10/11 1:30
 */
public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;

        while (i < j) {
            int lower = Math.min(height[j], height[i]);
            maxArea = Math.max((j - i) * lower, maxArea);
            //容器的面积是由比较短的那条边决定的,可以理解为木桶效应,所以比短边还要小的边就直接过滤掉,以此反复比较
            while (i < j && height[i] <= lower) i++;
            while (i < j && height[j] <= lower) j--;
        }

        return maxArea;
    }
}
