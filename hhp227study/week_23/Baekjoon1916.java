/**
최소비용 구하기
https://www.acmicpc.net/problem/1916
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, List<int[]>> graph = new HashMap<>() {
            {
                for (int i = 0; i < m; i++) {
                    int u = scanner.nextInt(), v = scanner.nextInt(), w = scanner.nextInt();

                    computeIfAbsent(u, integer -> new ArrayList<>()).add(new int[] {v, w});
                }
            }
        };
        int start = scanner.nextInt(), end = scanner.nextInt();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])) { { offer(new int[] {start, 0}); } };
        Map<Integer, Integer> map = new HashMap<>() { { put(start, 0); } };

        while (!queue.isEmpty()) {
            int[] outed = queue.poll();

            if (outed[1] > map.getOrDefault(outed[0], Integer.MAX_VALUE)) continue;
            map.put(outed[0], outed[1]);
            for (int[] next : graph.getOrDefault(outed[0], Collections.emptyList())) {
                if (map.containsKey(next[0])) continue;
                queue.offer(new int[] {next[0], outed[1] + next[1]});
            }
        }
        System.out.println(map.getOrDefault(end, 0));
        scanner.close();
    }
}
