package 스터디;
/*
부분수열의 합
https://www.acmicpc.net/problem/1182
 */
import java.util.*;
import java.io.*;
public class B1182 {
    static int[] nums;
    static boolean[] isSelected;
    static int n, s, count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums = new int[n]; isSelected = new boolean[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
        powerSet(0);
        System.out.println(count);
    }
    static void powerSet(int depth) {
        if (depth == n) {
            if (!validate()) return; //공집합 방지
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (isSelected[i]) sum += nums[i];
            }
            if (sum == s) {
                count++;
            }
            return;
        }

        //선택
        isSelected[depth] = true;
        powerSet(depth+1);

        //선택X
        isSelected[depth] = false;
        powerSet(depth+1);
    }

    static boolean validate() {
        for (int i = 0; i < n; i++) {
            if (isSelected[i]) return true;
        }
        return false;
    }
}
