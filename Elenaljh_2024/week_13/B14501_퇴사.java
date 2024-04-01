import java.io.*;
import java.util.*;
public class B14501_퇴사 {
    static final int revenue = 0, days = 1, end = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[days][i] = Integer.parseInt(st.nextToken());
            arr[revenue][i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[2][n];
        dp[end][0] = arr[days][0]-1;
        dp[revenue][0] = arr[revenue][0];

        for (int i = 1; i < n; i++) {
            if (dp[end][i-1] >= i || arr[days][i] + i > n) {
                if (dp[revenue][i-1] > arr[revenue][i] || arr[days][i] + i > n) {
                    dp[revenue][i] = dp[revenue][i-1];
                    dp[end][i] = dp[end][i-1];
                } else {
                    dp[revenue][i] = arr[revenue][i];
                    dp[end][i] = arr[days][i] + i - 1;
                }
            } else {
                dp[revenue][i] = dp[revenue][i-1] + arr[revenue][i];
                dp[end][i] = arr[days][i] + i - 1;
            }
        }

        int[] result = dp[revenue];
        Arrays.sort(result);
        System.out.println(result[n-1]);
    }


}
