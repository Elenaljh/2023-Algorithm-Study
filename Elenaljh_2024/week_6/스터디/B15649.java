package 스터디;
/*
n과 m(1)
 */
import java.util.*;
import java.io.*;
public class B15649 {
    static int[] nums, selected;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //자연수
        int m = Integer.parseInt(st.nextToken()); //수열 길이
        nums = new int[n];
        selected = new int[m];
        isSelected = new boolean[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }
        makePerm(0, m, n);
        System.out.println(sb);
    }

    static void makePerm(int count, int m, int n) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                selected[count] = nums[i];
                makePerm(count+1, m, n);
                isSelected[i] = false;
            }
        }
    }
}
