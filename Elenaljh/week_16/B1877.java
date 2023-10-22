import java.io.*;
import java.util.*;

public class B1877 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        //문제A : 합이 m이고 곱이 가장 큰 정수들 -> 길이 max, 길이 min
        int min_A = Integer.MAX_VALUE;
        int max_A = -1;
        double max = -1;
        /**
         * {(a1+...+an)/n}^n >= a1*...*an (등호조건: a1=a2=...=an)
         */

        for (int i = 1; i <= m; i++) {
            int div = (int) m/i;
            int cal = (int) (Math.pow(div, m-m%i) * Math.pow(div+1, m%i));
            if (max == cal) {
                min_A = Math.min(min_A, i);
                max_A = Math.max(max_A, i);
            } else if (max < cal) {
                min_A = i;
                max_A = i;
                max = cal;
            }
        }

        //문제B : 곱이 m이고 합이 가장 작은 정수들 -> 길이 max, 길이 min
        int min_B = Integer.MAX_VALUE;
        int max_B = -1;
        int min = Integer.MAX_VALUE;

        /**
         * a1+...+an >= (a1*..*an)^(1/n)*n (등호조건: a1=a2=...=an)
         */
        for (int i = 1; i <= m; i++) {

            if (cal == min) {
                min_B = Math.min(min_B, i);
                max_B = Math.max(max_B, i);
            } else if (cal < min) {
                min_B = i;
                max_B = i;
                min = cal;
            }
        }

        //출력:  A에서 구한 수열의 최대/최소 길이 n과 문제 B에서 구한 수열의 최대/최소 길이
        System.out.println(max_A + " " + min_A + " " + max_B + " " + min_B);

    }
}
