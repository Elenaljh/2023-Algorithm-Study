/**
체스판 다시 칠하기
https://www.acmicpc.net/problem/1018
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] array = initArray(n, m, scanner);
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                answer = Math.min(answer, compare(i, j, array));
            }
        }
        System.out.println(answer);
        scanner.close();
    }

    private static int[][] initArray(int n, int m, Scanner scanner) {
        int[][] result = new int[n][m];

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'B') {
                    result[i][j] = 1;
                }
            }
        }
        return result;
    }

    private static int[][] initArrayToCompare(int element) {
        int[][] result = new int[8][8];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        result[i][j] = element != 0 ? 1 : 0;
                    } else {
                        result[i][j] = element != 0 ? 0 : 1;
                    }
                } else {
                    if (j % 2 == 0) {
                        result[i][j] = element != 0 ? 0 : 1;
                    } else {
                        result[i][j] = element != 0 ? 1: 0;
                    }
                }
            }
        }
        return result;
    }

    private static int[][] initArrayToCompareReverse(int element) {
        int[][] result = new int[8][8];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        result[i][j] = element != 0 ? 0 : 1;
                    } else {
                        result[i][j] = element != 0 ? 1 : 0;
                    }
                } else {
                    if (j % 2 == 0) {
                        result[i][j] = element != 0 ? 1: 0;
                    } else {
                        result[i][j] = element != 0 ? 0 : 1;
                    }
                }
            }
        }
        return result;
    }

    private static int compare(int n, int m, int[][] array) {
        int[] counts = new int[2];
        int[][] arrayToCompare = initArrayToCompare(array[n][m]);
        int[][] arrayToCompareReversed = initArrayToCompareReverse(array[n][m]);

        for (int i = n; i < n + 8; i++) {
            for (int j = m; j < m + 8; j++) {
                if (array[i][j] != arrayToCompare[i - n][j - m]) {
                    counts[0]++;
                }
                if (array[i][j] != arrayToCompareReversed[i - n][j - m]) {
                    counts[1]++;
                }
            }
        }
        return Math.min(counts[0], counts[1]);
    }
}
