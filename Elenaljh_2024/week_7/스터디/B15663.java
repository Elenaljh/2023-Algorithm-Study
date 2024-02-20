package 스터디;

import java.io.*;
import java.util.*;
public class B15663 {
    static int N, M, nums[], selected[];
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N]; selected = new int[M]; isSelected = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
        perm(0);
        System.out.println(sb);
    }

    static void perm(int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) sb.append(selected[i]).append(" ");
            sb.append("\n");
            return;
        }
        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (isSelected[i] || nums[i] == prev) continue;
            prev = nums[i];
            isSelected[i] = true;
            selected[count] = nums[i];
            perm(count+1);
            isSelected[i] = false;
        }
    }
}
