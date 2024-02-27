import java.io.*;
import java.util.*;
public class B1149_RGB거리 {
    static int N, colors[], costs[][], MIN, COUNT;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        colors = new int[N];
        costs = new int[N][3];
        MIN = Integer.MAX_VALUE;
        COUNT = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(0);

        System.out.println(MIN);
        System.out.println("함수 호출 수 : " + COUNT);
    }

    static void perm(int count) {
        COUNT++;
        if (count == N) {
            //비용계산
            int cost = 0;
            for (int i = 0; i < N; i++) {
                cost += costs[i][colors[i]];
            }
            //MIN 업데이트
            MIN = Integer.min(MIN, cost);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (count == 0) {
                colors[count] = i;
                perm(count+1);
            } else if (colors[count-1] != i) {
                colors[count] = i;
                perm(count+1);
            }
        }
    }
}
