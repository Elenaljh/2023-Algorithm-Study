package 스터디;
/*
m과 n(2)
https://www.acmicpc.net/problem/15650
 */
import java.io.*;
import java.util.*;
public class B15650 {
    static int[] nums, selected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nums = new int[n]; selected = new int[m];
        for (int i = 0; i < n; i++) nums[i] = i+1;
        perm(n, m, 0, 0);
        System.out.println(sb);
    }

    static void perm(int n, int m, int count, int start) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            selected[count] = nums[i];
            perm(n, m, count+1, nums[i]);
        }
    }
}
