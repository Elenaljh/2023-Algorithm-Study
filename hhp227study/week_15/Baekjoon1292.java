/**
쉽게 푸는 문제
https://www.acmicpc.net/problem/1292
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt();
        long[] prefixSum = new long[b + 1];
        int[] array = {0, 1};

        for (int i = 1; i < prefixSum.length; i++) {
            if (array[0] == array[1]) {
                array[0] = 0;
                array[1]++;
            }
            prefixSum[i] = array[1] + (i > 1 ? prefixSum[i - 1] : 0);
            array[0]++;
        }
        System.out.println(prefixSum[b] - prefixSum[a - 1]);
        scanner.close();
    }
}
