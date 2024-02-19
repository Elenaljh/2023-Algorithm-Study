package 스터디;

import java.io.*;
import java.util.*;

public class B15652 {
    static int[] selected;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        perm(0, 1);
    }

    static void perm(int count, int start) {
        if (count == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
            return;
        }

        for (int i = start; i <= N; i++) {
            selected[count] = i;
            perm(count + 1, selected[count]);
        }
    }
}
