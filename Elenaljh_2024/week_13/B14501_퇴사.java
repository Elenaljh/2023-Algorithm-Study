import java.io.*;
import java.util.*;
public class B14501_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] array = new int[2][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            array[0][i] = Integer.parseInt(st.nextToken()); //일자
            array[1][i] = Integer.parseInt(st.nextToken()); //보수
        }

        int[] dp = new int[n+1];

        for (int i = 0; i < n; i++) {
            if (i+array[0][i] <= n) {
                dp[i+array[0][i]] = Math.max(dp[i+array[0][i]], dp[i]+array[1][i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]); 
        }
        System.out.println(dp[n]);
    }
}
