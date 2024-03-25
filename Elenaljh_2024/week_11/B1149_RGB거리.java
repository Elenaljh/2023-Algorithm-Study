import java.io.*;
import java.util.*;
public class B1149_RGB거리 {
    static int RED=0, GREEN=1, BLUE=2;
    static int[][] dp, price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        price = new int[n][3];
        dp = new int[n][3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    static void dp(int N, int color) {
        
    }
}
