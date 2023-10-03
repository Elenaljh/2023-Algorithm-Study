/**
섬의 개수
https://www.acmicpc.net/problem/4963
*/

import java.util.*;

public class Main {
    private static void bfs(int startI, int startJ, int[][] array) {
        Queue<int[]> queue = new LinkedList<>(List.of(new int[]{startI, startJ}));

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int i = current[0];
            int j = current[1];
            array[i][j] = 2;

            for (int[] next : new int[][] {{i - 1, j}, {i - 1, j + 1}, {i, j + 1}, {i + 1, j + 1}, {i + 1, j}, {i + 1, j - 1}, {i, j - 1}, {i - 1, j - 1}}) {
                int nextI = next[0];
                int nextJ = next[1];

                if (array[nextI][nextJ] == 1) {
                    array[nextI][nextJ] = 2;

                    queue.offer(new int[]{nextI, nextJ});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            int[][] array = new int[h + 2][w + 2];
            int answer = 0;

            if (w == 0 && h == 0) break;
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (array[i][j] == 1) {
                        answer++;
                        bfs(i, j, array);
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
