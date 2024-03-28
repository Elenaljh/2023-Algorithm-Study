import java.io.*;
import java.util.*;
public class B9251_LCS {
    static int[][] dp;
    static char[] shorter, longer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c1 = br.readLine().toCharArray();
        char[] c2 = br.readLine().toCharArray();
        shorter = c1.length > c2.length ? c2 : c1;
        longer = c1.length > c2.length ? c1 : c2;
        int len = shorter.length;
        dp = new int[2][len];
        Arrays.fill(dp[0], 1);

        for (int i = 0; i < len; i++) {
            char c = shorter[i];
            findLength(i, c);
        }

        int[] result = dp[0];
        Arrays.sort(result);

        System.out.println(result[len-1]);


        /**
         * AABDXDS
         * ABCDE
         * dp -> [길이][끝 인덱스]
         *       [1][0]
         *       [][]
         *
         *
         *
         */
    }
    static void findLength(int index, char c) {
        for (int i = 0; i < index; i++) {
            int place = -1;
            if ((place = checkExistence(dp[1][i], c)) != -1) {
                dp[0][index] = dp[0][i] + 1;
                dp[1][index] = place;
            }
        }
    }

    static int checkExistence(int index, char c) {
        for (int i = index + 1; i < longer.length; i++) {
            if (longer[i] == c) return i;
        }
        return -1;
    }
}
