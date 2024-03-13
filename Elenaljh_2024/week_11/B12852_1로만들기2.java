import java.io.*;
import java.util.*;
public class B12852_1로만들기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] path = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            if (i%3 == 0) {
                if (dp[i] > dp[i/3]+1) {
                    dp[i] = dp[i/3]+1;
                    path[i] = i/3;
                }
            }
            if (i%2 == 0) {
                if (dp[i] > dp[i/2]+1) {
                    dp[i] = dp[i/2]+1;
                    path[i] = i/2;
                }
            }
            if (dp[i] > dp[i-1]+1) {
                dp[i] = dp[i-1]+1;
                path[i] = i-1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append("\n");
        while (n > 0) {
            sb.append(n).append(" ");
            n = path[n];
        }
        System.out.println(sb);
    }

}
