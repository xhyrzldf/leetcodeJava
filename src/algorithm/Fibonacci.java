package algorithm;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Math.*;

/**
 * 斐波那契数列
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 80;
        double root5 = sqrt(5);
        System.out.println(fibRecurOpt(n));
        System.out.println(fibRecurLambdaOpt(n));
//        System.out.println(fibonacciIterOpt(n));
        // System.out.println(Math.round(((pow((1 + root5) / 2, n)) - (pow((1 - root5), n) / 2)) / root5));


    }


    /* 递归解法 */
    public static long fibRecur(int n) {
        if (n == 0 || n == 1) return n;
        return fibRecur(n - 1) + fibRecur(n - 2);
    }

    private static final Map<Integer, Long> cache = new HashMap<>();

    /* 递归优化 */
    public static long fibRecurOpt(int n) {
        if (n == 0 || n == 1) return n;

        Long exceptedNum = cache.get(n);

        if (exceptedNum == null) {
            synchronized (cache) {
                exceptedNum = fibRecurOpt(n - 1) + fibRecurOpt(n - 2);
                cache.put(n, exceptedNum);
            }
        }

        return exceptedNum;

    }

    /* 使用java8的lambda简化语法 */
    public static long fibRecurLambdaOpt(int n) {
        if (n == 0 || n == 1) return n;
        return cache.computeIfAbsent(n, key -> fibRecurLambdaOpt(n - 1) + fibRecurLambdaOpt(n - 2));
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
        long prev = 0;
        long next = 1;

        for (long i = 2; i <= n; i++) {
            if (i % 2 == 0) prev += next;
            else next += prev;
        }
        return n < 2 ? n : Math.max(prev, next);
    }

    /*  */

//    public static long fibonacci04(int n) {
//    }
}
