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

        for (int i = 0; i < len; i++) {
            char c = shorter[i];

        }

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
    static int findLength(int index) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < index; i++) {
            if (dp[0][i] > max) {
                if ()
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
