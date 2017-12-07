package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * <p>Description : leetcodeJava
 * <p>Date : 2017/10/28 13:37
 * <p>@author : Matrix [xhyrzldf@foxmail.com]
 */
public class bagProblem01 {


/*    static int search(int idx,int selectedWeight) {
        int[] inits = {idx,selectedWeight};
        return callMemo((fun, params) ->{
            int tempIdx =  params[0];
            int tempSelectedWeight = params[1];

            if (tempSelectedWeight > bagWeight) return 0;
            if (tempIdx >= w.length) return 0;

            return Math.max(fun.apply(new int[]{tempIdx+1,tempSelectedWeight + w[tempIdx]}) + v[tempIdx],
                    fun.apply(new int[]{tempIdx+1,tempSelectedWeight}));

        },inits);

    }*/

    private static final Integer[] w = Stream
            .iterate(0, t -> new Random().nextInt(10))
            .limit(1000)
            .toArray(Integer[]::new);

    private static final Integer[] v = Stream
            .iterate(0, t -> new Random().nextInt(10) * 100)
            .limit(1000)
            .toArray(Integer[]::new);

    private static final int bagWeight = 200;
    private static final Map<String, Integer> DP_CACHE = new HashMap<>(131072);

    public static int search(int idx, int S) {

        if (idx >= w.length) return 0;
        if (S + w[idx] > bagWeight) return 0;

        String key = String.valueOf(idx) + S;
        return DP_CACHE.computeIfAbsent(key, s ->
                Math.max(search(idx + 1, S + w[idx]) + v[idx], search(idx + 1, S)));
//        return Math.max(search(idx + 1, S + w[idx]) + v[idx], search(idx + 1, S));
    }

/*    static int bagSolve(final int bagWeight) {
        return callMemo(bagProblem01::searchMemo, new int[]{0, 0, bagWeight});
    }

    private static int searchMemo(Function<int[], Integer> function, int[] params) {
        int idx = params[0];
        int S = params[1];
        final int[] W = {7, 8, 9};
        final int[] V = {100, 200, 500};
        final int BAG_WEIGHT = params[2];


        if (idx >= W.length) return 0;
        if (S + W[idx] > BAG_WEIGHT) return 0;

        return Math.max(
                function.apply(new int[]{idx + 1, S + W[idx], BAG_WEIGHT}) + V[idx],
                function.apply(new int[]{idx + 1, S, BAG_WEIGHT}));

    }*/


    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int i = 0; i < 100; ++i) {
            search(0, 0);
            DP_CACHE.clear();
        }
        long end = System.nanoTime();
        System.out.printf("DP CACHE length : %d %n", DP_CACHE.size());
        System.out.printf("calculation 100 times average cost %.2f ms", (end - start) / Math.pow(10, 6) / 100);
    }


    /**
     * 备忘录模式 函数封装
     *
     * @param function 递归策略算法
     * @param input    输入值
     * @param <T>      输出值类型
     * @param <R>      返回值类型
     * @return 将输入值输入递归策略算法，计算出的最终结果
     */
    public static <T, R> R callMemo(final BiFunction<Function<T, R>, T, R> function, final T input) {
        Function<T, R> memo = new Function<T, R>() {
            private final Map<T, R> cache = new HashMap<>(64);

            @Override
            public R apply(final T input) {
                return cache.computeIfAbsent(input, key -> function.apply(this, key));
            }
        };

        return memo.apply(input);
    }

}
