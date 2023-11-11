/**
토마토
https://www.acmicpc.net/problem/7576
*/

import java.util.*;

public class Main {
    private static final List<int[]> startList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        int[][] array = initArray(n, m, scanner);
        int answer = 0;

        bfs(array);
        for (int i = 1; i < array.length - 1; i++) {
            Arrays.sort(array[i]);
            if (Arrays.binarySearch(array[i], 0) > -1) {
                System.out.println(-1);
                return;
            } else {
                answer = Math.max(answer, array[i][array[i].length - 1]);
            }
        }
        System.out.println(answer - 1);
        scanner.close();
    }

    private static void bfs(int[][] array) {
        Queue<int[]> queue = new LinkedList<>(startList);

        while (!queue.isEmpty()) {
            int[] outed = queue.poll();

            for (int[] next : new int[][]{{outed[0] - 1, outed[1]}, {outed[0], outed[1] + 1}, {outed[0] + 1, outed[1]}, {outed[0], outed[1] - 1}}) {
                if (array[next[0]][next[1]] == 0) {
                    array[next[0]][next[1]] = array[outed[0]][outed[1]] + 1;

                    queue.offer(new int[]{next[0], next[1]});
                }
            }
        }
    }

    private static int[][] initArray(int n, int m, Scanner scanner) {
        int[][] array = new int[n + 2][m + 2];

        Arrays.setAll(array, value -> {
            int[] row = new int[array[value].length];

            Arrays.fill(row, -1);
            if (value > 0 && value <= n) {
                Arrays.setAll(row, operand -> {
                    if (operand > 0 && operand <= m) {
                        int element = scanner.nextInt();

                        if (element == 1) startList.add(new int[] {value, operand});
                        return element;
                    } else {
                        return -1;
                    }
                });
            }
            return row;
        });
        return array;
    }
}
