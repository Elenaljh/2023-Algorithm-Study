import java.io.*;
import java.util.*;
public class B1149_RGB거리 {

    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;
    static int[][] Cost;
    static int[][] Dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Cost = new int[N][3];
        Dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                Cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //Dp의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
        Dp[0][Red] = Cost[0][Red];
        Dp[0][Green] = Cost[0][Green];
        Dp[0][Blue] = Cost[0][Blue];

        int minimumCost = Math.min(paint(N-1, Red), Math.min(paint(N-1, Blue), paint(N-1, Green))); //배열 인덱스 때문
        System.out.println(minimumCost);
    }

    static int paint(int N, int color) {
        //탐색하지 않은 배열이면
        if (Dp[N][color] == 0) {
            //이전 집의 최솟값 재귀호출해서 현재 집의 비용을 더함. Dp에 저장
            if (color == Red) {
                Dp[N][Red] = Math.min(paint(N-1, Blue), paint(N-1, Green)) + Cost[N][Red];
            } else if (color == Green) {
                Dp[N][Green] = Math.min(paint(N-1, Red), paint(N-1, Blue)) + Cost[N][Green];
            } else {
                Dp[N][Blue] = Math.min(paint(N-1, Red), paint(N-1, Green)) + Cost[N][Blue];
            }
        }

        return Dp[N][color];
    }
}
