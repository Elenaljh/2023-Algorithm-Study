package 과제;
/*
진기의 최고급 붕어빵
 */
import java.util.*;
import java.io.*;

public class SW1860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Loop1:
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //손님 수
            int m = Integer.parseInt(st.nextToken()); //k개 붕어빵 만드는 시간
            int k = Integer.parseInt(st.nextToken()); //m초동안 만들 수 있는 붕어빵 수
            int[] visitors = new int[n+1]; //각 사람이 몇초에 오는지
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                visitors[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(visitors);

            //로직
            int bread = 0;
            for (int i = 1; i <= n; i++) {
                int visitedTime = visitors[i];
                bread = (visitedTime/m)*k - (i-1);
                if (bread == 0) {
                    sb.append("#").append(t).append(" ").append("Impossible").append("\n");
                    continue Loop1;
                }
            }
            sb.append("#").append(t).append(" ").append("Possible").append("\n");
        }
        System.out.println(sb);
    }
}
