package algorithm;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.nonNull;

/**
 * <p>Description : dijkstra算法
 * <p>Date : 2017/12/6 16:38
 * <p>@author : Matrix [xhyrzldf@foxmail.com]
 */
public class Dijkstra {
    private static final Map<String, Optional<Map<String, Integer>>> GRAPH;
    private static final Map<String, Optional<Integer>> COSTS;
    private static final Map<String, Optional<String>> PARENTS;
    private static List<String> PROCESSED = new ArrayList<>();

    static {
        //分别初始化 GRAPH,COSTS,PARENTS 三个散列表
        GRAPH = ImmutableMap.of(
                "起点", Optional.of(ImmutableMap.of("A", 6, "B", 2)),
                "A", Optional.of(ImmutableMap.of("终点", 1)),
                "B", Optional.of(ImmutableMap.of("A", 3, "终点", 5)),
                "终点", Optional.empty());

        COSTS = ImmutableMap.of(
                "A", Optional.of(6),
                "B", Optional.of(2),
                "终点", Optional.of(Integer.MAX_VALUE));

        PARENTS = ImmutableMap.of(
                "A", Optional.of("起点"),
                "B", Optional.of("起点"),
                "终点", Optional.empty());


    }

    public static void main(String[] args) {
        dijkstra();
    }

    private static void dijkstra() {
        String node = findLowestCostNode(COSTS);
        while (nonNull(node)) {
            Integer cost = COSTS.get(node).get();
            Map<String, Integer> neighbor = GRAPH.get(node).get();
            for (String n : neighbor.keySet()) {
                Integer newCost = cost + neighbor.get(n);
                if (COSTS.get(n).get() > newCost) {
                    COSTS.replace(n, Optional.of(newCost));
                    PARENTS.replace(n, Optional.of(node));
                }
            }
            PROCESSED.add(node);
            node = findLowestCostNode(COSTS);
        }
    }

    private static String findLowestCostNode(Map<String, Optional<Integer>> costs) {
        Integer lowestCost = Integer.MAX_VALUE;
        Optional<String> lowestCostNode = Optional.empty();
        for (String node : costs.keySet()) {
            Integer cost = COSTS.get(node).get();
            if (cost < lowestCost && !PROCESSED.contains(node)) {
                lowestCost = cost;
                lowestCostNode = Optional.of(node);
            }
        }
        return lowestCostNode.orElse("notFindNode");
    }


    private static <T> List<T> listOf(T... params) {
        return Lists.newArrayList(params);
    }

}
