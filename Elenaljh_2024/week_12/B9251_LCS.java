import java.util.*;
import java.io.*;
public class B9251_LCS {
    static int end = 0, length = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        int len = 0; char[] shorter = null; char[] longer = null;
        if (arr1.length > arr2.length) {
            len = arr2.length;
            shorter = arr2;
            longer = arr1;
        } else {
            len = arr1.length;
            shorter = arr1;
            longer = arr2;
        }

        int[][] dp = new int[2][len];

        for (int i = 0; i < len; i++) {

        }


    }

    static int setDp(int index, int[][] dp, char[] shorter, char[] longer) {
        char now = shorter[index];
        for (int i = dp[end][index-1])
    }

    static int check(int endIndex, char now, char[] longer) {
        for (int i = endIndex+1; i < longer.length; i++) {
            if (longer[i] == now) return i;
        }
        return -1;
    }
}
