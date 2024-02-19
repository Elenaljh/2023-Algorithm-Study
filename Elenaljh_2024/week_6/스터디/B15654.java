package 스터디;

import java.io.*;
import java.util.*;
public class B15654 {
    static int n, m, nums[], selected[];
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n]; selected = new int[m]; isSelected = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
        perm(0);
    }

    static void perm(int count) {
        if (count == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isSelected[i]) {
                selected[count] = nums[i];
                isSelected[i] = true;
                perm(count + 1);
                isSelected[i] = false;
            }

        }
    }
}
