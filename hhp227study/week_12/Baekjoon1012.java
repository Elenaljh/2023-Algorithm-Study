/**
유기농 배추
https://www.acmicpc.net/problem/1012
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            final int m = scanner.nextInt(), n = scanner.nextInt(), k = scanner.nextInt();
            int[][] arrays = new int[n + 2][m + 2];
            int count = 0;

            for (int j = 0; j < k; j++) {
                int x = scanner.nextInt() + 1, y = scanner.nextInt() + 1;
                arrays[y][x] = 1;
            }
            for (int y = 1; y <= n; y++) {
                for (int x = 1; x <= m; x++) {
                    if (arrays[y][x] == 1) {
                        count++;
                        dfs(arrays, new int[] {y, x});
                    }
                }
            }
            System.out.println(count);
        }
        scanner.close();
    }

    private static void dfs(int[][] array, int[] start) {
        Stack<int[]> stack = new Stack<>() { { push(start); } };
        array[start[0]][start[1]] = 3;

        while (!stack.isEmpty()) {
            int[] outed = stack.pop();

            for (int[] next : new int[][] {{outed[0] - 1, outed[1]}, {outed[0], outed[1] + 1}, {outed[0] + 1, outed[1]}, {outed[0], outed[1] - 1}}) {
                if (array[next[0]][next[1]] == 1) {
                    array[next[0]][next[1]] = 3;

                    stack.push(next);
                }
            }
        }
    }
}
