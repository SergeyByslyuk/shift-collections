package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
//        merge();
//        compute();
//        computeIfAbsent();
//        computeIfPresent();
    }

    private static void merge() {
        Map<String, Integer> itemCounts = new HashMap<>();

        itemCounts.merge("Apple", 1, Integer::sum);
        itemCounts.merge("Banana", 2, Integer::sum);
        itemCounts.merge("Apple", 3, Integer::sum);

        System.out.println(itemCounts);
    }

    private static void compute() {
        Map<String, Double> prices = new HashMap<>();
        prices.put("Shoes", 100.0);
        prices.put("Hat", 50.0);

        prices.compute("Shoes", (key, value) -> value - value * 0.10);

        prices.compute("Bag", (key, value) -> value == null ? 30.0 : value + 10.0);
//        prices.compute("Bag", (key, value) -> value + 10.0);

        System.out.println(prices);
    }

    private static void computeIfAbsent() {
        Map<String, List<String>> map = new HashMap<>();

        map.computeIfAbsent("Fruits", k -> new ArrayList<>()).add("Apple");
        map.computeIfAbsent("Fruits", k -> new ArrayList<>()).add("Banana");
        map.computeIfAbsent("Vegetables", k -> new ArrayList<>()).add("Carrot");

        System.out.println(map);
    }

    private static void computeIfPresent() {
        Map<String, Double> prices = new HashMap<>();
        prices.put("Shoes", 100.0);
        prices.put("Hat", 50.0);

        prices.computeIfPresent("Shoes", (key, value) -> value * 1.20);

        prices.computeIfPresent("Bag", (key, value) -> value * 1.10);

        System.out.println(prices);
    }
}
