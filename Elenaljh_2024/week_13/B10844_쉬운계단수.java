import java.io.*;
import java.util.*;

public class B10844_쉬운계단수 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = 1_000_000_000;
        long[][] dp = new long[101][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1L;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                int minus = j-1;
                int plus = j+1;
                if (minus >= 0) dp[i][minus] = (dp[i][minus]+dp[i-1][j]) % mod;
                if (plus <= 9) dp[i][plus] = (dp[i][plus]+dp[i-1][j]) % mod;
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + dp[n][i]) % mod;
        }
        System.out.println(result);
    }
}
