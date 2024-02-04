/**
소수
https://www.acmicpc.net/problem/2581
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        int sum = 0, primeMin = 0;

        for (int i = m; i <= n; i++) {
            if (isPrimeNumber(i)) {
                sum += i;
                if (primeMin == 0) {
                    primeMin = i;
                }
            }
        }
        System.out.println(sum == 0 && primeMin == 0 ? -1 : sum + "\n" + primeMin);
    }

    private static boolean isPrimeNumber(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n > 1;
    }
}
