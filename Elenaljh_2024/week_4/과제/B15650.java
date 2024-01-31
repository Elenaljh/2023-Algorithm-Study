package 과제;

import java.io.*;
import java.util.*;

public class B15650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        work(0, 1, m, n, sb);

    }

    static void work(int cnt, int start, int m, int n,StringBuilder sb) {
        if (cnt == m) {
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
            sb.append(" ");
        } else {
            for (int i = start; i <= n; i++) {
                sb.append(i).append(" ");
                work(cnt+1, i+1, m, n, sb);
                sb.delete(sb.length()-2, sb.length());
            }
        }
    }
}
