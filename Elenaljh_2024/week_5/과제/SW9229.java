package 과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
한빈이와 Spot Mart
 */
public class SW9229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        //테스트케이스
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //과자봉지 수
            int m = Integer.parseInt(st.nextToken()); //무게합 최대
            int[] snacks = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int max = 0;
            for (int a = 0; a < n-1; a++) {
                for (int b = a+1; b < n; b++) {
                    if (snacks[a] + snacks[b] <= m) {
                        max = Integer.max(max, snacks[a] + snacks[b]);
                    }
                }
            }

            if (max == 0) {
                sb.append("#").append(i).append(" ").append(-1).append("\n");
            } else {
                sb.append("#").append(i).append(" ").append(max).append("\n");
            }
        }
        System.out.println(sb);

    }
}
