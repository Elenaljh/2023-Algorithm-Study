import java.io.*;
import java.util.*;

public class B1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] order = new int[n+1];
        order = z(n, r, c, order);
        int result = 0;
        for (int i = n; i >= 1; i--) {
            result += (order[i]-1) * (int)Math.pow(2, i-1) * (int)Math.pow(2, i-1);
        }

        System.out.println(result);
    }


    public static int[] z(int n, int r, int c, int[] order) {
        if (n < 0) {
            return order;
        }

        if (r < Math.pow(2, n-1)) {
            if (c < Math.pow(2, n-1)) {
                order[n] = 1;
                return z(n-1, r, c, order);
            }
            if (c >= Math.pow(2, n-1)) {
                order[n] = 2;
                return z(n-1, r, c-(int)Math.pow(2, n-1), order);
            }
        }
        if (r >= Math.pow(2, n-1)) {
            if (c < Math.pow(2, n-1)) {
                order[n] = 3;
                return z(n-1, r-(int)Math.pow(2, n-1), c, order);
            }
            if (c >= Math.pow(2, n-1)) {
                order[n] = 4;
                return z(n-1, r-(int)Math.pow(2, n-1), c-(int)Math.pow(2, n-1), order);
            }
        }

        return order;

    }
}
