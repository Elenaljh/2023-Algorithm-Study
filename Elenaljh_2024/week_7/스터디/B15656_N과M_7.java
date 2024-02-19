package 스터디;

import java.io.*;
import java.util.*;
public class B15656_N과M_7 {
    static int N, M, nums[], selected[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N]; selected = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
        perm(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void perm(int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) sb.append(selected[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            selected[count] = nums[i];
            perm(count + 1);
        }
    }
}
