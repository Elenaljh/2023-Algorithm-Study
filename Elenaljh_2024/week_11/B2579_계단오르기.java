import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579_계단오르기 {
    static final int one = 0, two = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }
        int[][] dp = new int[2][n+1];
        dp[one][1] = stairs[1];
        dp[two][1] = stairs[1];
        dp[one][2] = stairs[1] + stairs[2];
        dp[two][2] = stairs[2];


        for (int i = 3; i <= n; i++) {
			dp[one][i] = dp[two][i-1] + stairs[i];
            dp[two][i] = Integer.max(dp[one][i-2] + stairs[i], dp[two][i-2] + stairs[i]);
        }

        System.out.println(Integer.max(dp[one][n], dp[two][n]));
    }
}
