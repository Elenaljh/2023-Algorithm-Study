import java.util.*;
import java.io.*;
public class B1912_연속합 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.max(dp[i-1]+arr[i], arr[i]);
        }
        Arrays.sort(dp);
        System.out.println(dp[n-1]);

        /**
         * dp[i] = max(dp[i-1]+arr[i], arr[i]);
         *
         */
    }
}
