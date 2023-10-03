/**
바이러스
https://www.acmicpc.net/problem/2606
*/

import java.util.*;

public class Main {
    private static final List<String> dfsResults = new ArrayList<>();

    private static final List<String> bfsResults = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>() {
            {
                for (int i = 0; i < n; i++) {
                    put(i + 1, new ArrayList<>());
                }
                for (int j = 0; j < m; j++) {
                    int[] inputs = new int[] {scanner.nextInt(), scanner.nextInt()};

                    get(inputs[0]).add(inputs[1]);
                    get(inputs[1]).add(inputs[0]);
                }
            }
        };

        dfs(map, 1, new Stack<>(), new HashSet<>(List.of(1)));
        bfs(map, 1, new LinkedList<>(), new HashSet<>(List.of(1)));
        if (dfsResults.size() == bfsResults.size()) {
            System.out.println(dfsResults.size() - 1);
        }
        scanner.close();
    }

    private static void dfs(Map<Integer, List<Integer>> edgeMap, int v, Stack<Integer> stack, Set<Integer> visited) {
        dfsResults.add(String.valueOf(v));
        for (int next : edgeMap.get(v)) {
            if (visited.contains(next)) {
                continue;
            }
            stack.push(next);
            visited.add(next);
            if (!stack.isEmpty()) {
                dfs(edgeMap, next, stack, visited);
            }
            stack.pop();
        }
    }

    private static void bfs(Map<Integer, List<Integer>> edgeMap, int v, Queue<Integer> queue, Set<Integer> visited) {
        queue.offer(v);
        while (!queue.isEmpty()) {
            int outed = queue.poll();

            bfsResults.add(String.valueOf(outed));
            visited.add(outed);
            for (int next : edgeMap.get(outed)) {
                if (!visited.contains(next) && !queue.contains(next)) {
                    queue.offer(next);
                }
            }
        }
    }
}
