/**
 * https://www.acmicpc.net/problem/15649
 * 과제
 */
import java.io.*;
import java.util.*;
public class B15649 {
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //1부터 n까지 자연수 중에서 중복 없이 m개를 고른 수열을 오름차순으로 정렬해서 출력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        isSelected = new boolean[n+1];
        StringBuilder sb = new StringBuilder();

        work(0, n, m, sb);
    }

    static void work(int count, int n, int m, StringBuilder sb) {
        if (count == m) {
            System.out.println(sb.toString().trim());
        } else {
            for (int i = 1; i <= n; i++) {
                if (!isSelected[i]) {
                    isSelected[i] = true;
                    sb.append(i).append(" ");
                    work(count+1, n, m, sb);
                    isSelected[i] = false;
                    sb.delete(sb.length()-2, sb.length());
                }
            }
        }
    }
}
