/**
끔찍한 수열
https://www.acmicpc.net/problem/1877
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int nMax, nMin, mMax, mMin;

        if (m <= 3) {
            nMax = nMin = 1;
        } else {
            int q = m / 3;
            int r = m % 3;
            nMin = q + (r <= 1 ? 0 : 1);
            nMax = q + (r == 0 ? 0 : 1);
        }
        if (m == 1) {
            mMax = mMin = 1;
        } else {
            Map<Integer, Integer> factorization = primeFactorizationSmall(m);
            mMax = 0;
            
            for (int value : factorization.values()) {
                mMax += value;
            }
            mMin = mMax - factorization.getOrDefault(2, 0) / 2;
        }
        System.out.println(nMax + " " + nMin + " " + mMax + " " + mMin);
    }

    public static Map<Integer, Integer> primeFactorizationSmall(int m) {
        Map<Integer, Integer> factorization = new HashMap<>();
        
        for (int i = 2; i * i <= m; i++) {
            while (m % i == 0) {
                factorization.put(i, factorization.getOrDefault(i, 0) + 1);
                m /= i;
            }
        }
        if (m > 1) {
            factorization.put(m, factorization.getOrDefault(m, 0) + 1);
        }
        return factorization;
    }
}
