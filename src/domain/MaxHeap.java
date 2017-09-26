package domain;

import java.util.*;
import java.util.function.Consumer;

/**
 * @Description
 * @Author matrix[xhyrzldf@foxmail.com]
 * @Date 2017/9/26 18:25
 */
@SuppressWarnings({"unused", "unchecked", "WeakerAccess"})
public class MaxHeap<T extends Comparable> {

    protected T[] elementData;
    protected int size;

    public MaxHeap(int n) {
        elementData = (T[]) new Comparable[n + 1];
        size = 0;
    }

    /**
     * 构造函数, 通过一个给定数组创建一个最大堆
     * 该构造堆的过程, 时间复杂度为O(n)
     *
     * @param arr
     */
    public MaxHeap(T[] arr) {
        int n = arr.length;
        elementData = (T[]) new Comparable[n + 1];
        System.arraycopy(arr, 0, elementData, 1, n);
        size = n;

        for (int i = size / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public MaxHeap() {
        elementData = (T[]) new Comparable[16];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向最大堆添加元素
     *
     * @param t
     * @return
     */
    public int add(T t) {
        if (size > elementData.length / 4 * 3) expansion();
        elementData[++size] = t;
        shiftUp(size);
        return size;
    }

    /**
     * 从最大堆中取出堆顶元素
     *
     * @return
     */
    public T extracMax() {
        T t = elementData[1];
        swap(1, size--);
        shiftDown(1);
        return t;
    }

    /**
     * 获得数组最大元素
     *
     * @return
     */
    public T getMax() {
        if (size <= 0) throw new NoSuchElementException("数组里是空的!");
        return elementData[1];
    }

    /**
     * 实现java8 foreach方便循环遍历
     *
     * @param action
     */
    @SuppressWarnings("ConstantConditions")
    public void foreach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        final int expectedModCount = size;
        final T[] elementData = (T[]) this.elementData;
        final int size = this.size;
        for (int i = 0; size == expectedModCount && i < size; i++) {
            action.accept(elementData[i]);
        }
        if (size != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    /**
     * 将元素向上调整位置,使得整个二叉树仍然是一颗完全二叉树
     *
     * @param k
     */
    private void shiftUp(int k) {
        T e = elementData[k];
        while (k > 1 && e.compareTo(elementData[k / 2]) > 0) {
            elementData[k] = elementData[k / 2];
            k /= 2;
        }
        elementData[k] = e;
    }

    /**
     * 将元素向下调整位置,使得整个二叉树仍然是一颗完全二叉树
     *
     * @param k
     */
    private void shiftDown(int k) {
        T e = elementData[k];

        while (k * 2 <= size) {
            int j = k * 2;
            if (j + 1 <= size && elementData[j + 1].compareTo(elementData[j]) > 0) j++;
            if (e.compareTo(elementData[j]) >= 0) break;
            elementData[k] = elementData[j];
            k = j;
        }

        elementData[k] = e;
    }

    /**
     * 交换堆中数组的两个元素
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        T temp = elementData[i];
        elementData[i] = elementData[j];
        elementData[j] = temp;
    }

    /**
     * 数组扩容
     */
    private void expansion() {
        int n = elementData.length;
        Object[] exElementData = new Comparable[n / 2 * 3];
        System.arraycopy(elementData, 0, exElementData, 0, n);
        elementData = (T[]) exElementData;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        for (int i = 0; i < 50; i++) {
            maxHeap.add(new Random().nextInt(100));
        }

        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.extracMax() + " ");
        }
    }

}
