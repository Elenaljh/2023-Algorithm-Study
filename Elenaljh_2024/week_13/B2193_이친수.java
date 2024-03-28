import java.io.*;
import java.util.*;
public class B2193_이친수 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n];
        dp[0] = 1;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n-1]);

    }
}
