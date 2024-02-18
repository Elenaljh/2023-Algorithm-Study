package blair_2024.week_07;

import java.util.Scanner;

public class Daily0212 {

    // 05-1 깊이 우선 탐색 DFS

    // 신기한 소수 찾기
    // https://www.acmicpc.net/problem/2023

    static int num;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        num = in.nextInt();

        DFSF(2, 1); // 일의 자리 소수는 2, 3, 5, 7이므로 4개 수에서만 시작
        DFSF(3, 1);
        DFSF(5, 1);
        DFSF(7, 1);
    }

    private static void DFSF(int number, int position) {
        if (position == num) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) { // 짝수라면 더 이상 탐색할 필요 없음
                continue;
            }
            if (isPrime(number * 10 + i)) { // 소수라면 재귀 함수로 자릿수 늘림
                DFSF(number * 10 + i, position + 1);
            }
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
