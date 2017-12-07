package main.java.algorithm;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.pow;

/**
 * 斐波那契数列
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 45;
        long start = System.nanoTime();
        System.out.println(fibonacciIter(45));
        long end = System.nanoTime();
        System.out.printf("calc cost %.2f ms", (end - start) / pow(10, 6));

    }

    /* 递归解法 */
    public static long fibRecur(int n) {
        if (n <= 1) return 1;
        return fibRecur(n - 1) + fibRecur(n - 2);
    }

    public static long recurrence(int n) {
        return fibRecur(n);
    }

    private static final Map<Integer, Long> CACHE = new HashMap<>();

    /**
     * 使用备忘录模式来利用重复计算结果
     *
     * @param n
     * @return
     */
    public static long fibRecurOpt(int n) {
        if (n == 0 || n == 1) return n;

        Long exceptedNum = CACHE.get(n);

        if (exceptedNum == null) {
            synchronized (CACHE) {
                exceptedNum = CACHE.get(n);
                if (exceptedNum == null) {
                    exceptedNum = fibRecurOpt(n - 1) + fibRecurOpt(n - 2);
                    CACHE.put(n, exceptedNum);
                }
            }
        }

        return exceptedNum;
    }

    /**
     * 使用computeIfAbsent来优化备忘录模式
     *
     * @param n
     * @return
     */
    public static long fibRecurLambdaOpt(int n) {
        if (n == 0 || n == 1) return n;
        return CACHE.computeIfAbsent(n, key -> fibRecurLambdaOpt(n - 1) + fibRecurLambdaOpt(n - 2));
    }

    /* 迭代解法 */
    public static long fibonacciIter(int n) {
        long prev = 0;
        long next = 1;

        long accumulate = 0;
        for (int i = 2; i <= n; i++) {
            accumulate = prev + next;
            prev = next;
            next = accumulate;
        }
        return accumulate;
    }

    /* 迭代的优化 */
    public static long fibonacciIterOpt(int n) {
        long prev = 1;
        long next = 1;

        for (long i = 2; i <= n; i++) {
            if (i % 2 == 0) prev += next;
            else next += prev;
        }
        return Math.max(prev, next);
    }

  /*  */

    //    public static long fibonacci04(int n) {
    //    }
}
