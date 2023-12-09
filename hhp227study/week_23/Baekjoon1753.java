/**
최단경로
https://www.acmicpc.net/problem/1753
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt(), e = scanner.nextInt();
        int k = scanner.nextInt();
        Map<Integer, List<AbstractMap.SimpleEntry<Integer, Integer>>> graph = new HashMap<>() {
            {
                for (int i = 0; i < e; i++) {
                    int u = scanner.nextInt(), v = scanner.nextInt(), w = scanner.nextInt();

                    computeIfAbsent(u, integer -> new ArrayList<>()).add(new SimpleEntry<>(v, w));
                }
            }
        };
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(AbstractMap.SimpleEntry::getValue)) {
            {
                offer(new AbstractMap.SimpleEntry<>(k, 0));
            }
        };
        Map<Integer, Integer> map = new HashMap<>() { { put(k, 0); } };

        while (!priorityQueue.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> outed = priorityQueue.poll();

            if (outed.getValue() > map.getOrDefault(outed.getKey(), Integer.MAX_VALUE)) continue;
            map.put(outed.getKey(), outed.getValue());
            for (AbstractMap.SimpleEntry<Integer, Integer> next : graph.getOrDefault(outed.getKey(), Collections.emptyList())) {
                if (map.containsKey(next.getKey())) continue;
                priorityQueue.offer(new AbstractMap.SimpleEntry<>(next.getKey(), outed.getValue() + next.getValue()));
            }
        }
        for (int key = 1; key <= v; key++) {
            int value = map.getOrDefault(key, Integer.MAX_VALUE);

            System.out.println(value != Integer.MAX_VALUE ? value : "INF");
        }
        scanner.close();
    }
}
