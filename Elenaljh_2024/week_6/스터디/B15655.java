package 스터디;

import java.io.*;
import java.util.*;
public class B15655 {
    static int n, m, nums[], selected[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n]; selected = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
        perm(0, 0);
    }

    static void perm(int count, int start) {
        if (count == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
            return;
        }

        for (int i = start; i < n; i++) {
            selected[count] = nums[i];
            perm(count+1, i+1);
        }
    }
}
