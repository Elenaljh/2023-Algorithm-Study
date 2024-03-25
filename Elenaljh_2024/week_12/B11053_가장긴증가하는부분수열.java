import java.io.*;
import java.util.*;
public class B11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[find(i, arr, dp)] + 1;
        }
        Arrays.sort(dp);
        System.out.println(dp[n]);
    }

    static int find(int index, int[] arr, int[] dp) {
        int max = 0;
        int maxIndex = 0;
        for (int i = index-1; i >= 1; i--) {
            if (arr[i] < arr[index] && dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
