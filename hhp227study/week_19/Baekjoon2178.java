/**
미로 탐색
https://www.acmicpc.net/problem/2178
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] array = new int[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            String row = scanner.next();

            for (int j = 1; j <= m; j++) {
                array[i][j] = Character.getNumericValue(row.charAt(j - 1));
            }
        }
        System.out.println(bfs(array, n, m));
    }

    private static int bfs(int[][] array, int n, int m) {
        Queue<int[]> queue = new LinkedList<>(List.of(new int[] {1, 1, 1}));

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int i = current[0];
            int j = current[1];
            int l = current[2];
            array[i][j] = 2;

            if (i == n && j == m) {
                return l;
            }
            for (int[] next : new int[][] {{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}}) {
                if (array[next[0]][next[1]] == 1) {
                    array[next[0]][next[1]] = 2;

                    queue.offer(new int[] {next[0], next[1], l + 1});
                }
            }
        }
        return 0;
    }
}
