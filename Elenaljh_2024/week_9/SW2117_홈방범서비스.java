import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class SW2117_홈방범서비스 {
    static int N, M, house, MAX;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //지도 크기
            M = Integer.parseInt(st.nextToken()); //하나의 집이 지불할 수 있는 비용
            map = new int[N][N];
            house = 0;
            MAX = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) house++;
                }
            }

            //홈방범서비스 범위
            int maxK = findMaxK();
            for (int K = 1; K <= maxK; K++) { ///????
                int localMax = findMaxHouses(K);
                MAX = Integer.max(MAX, localMax);
            }

            sb.append("#").append(test).append(" ").append(MAX).append("\n");

        }
        System.out.println(sb);
    }

    static int revenue(int K, int home) {
        int cost = K*K+(K-1)*(K-1);
        return home*M - cost;
    }

    static int[][] getSecurity(int K) {
        int length = 2*K-1;
        int[][] security = new int[length][length];
        for (int i = 0; i < length; i++) {
            int col = 0;
            for (int j = 0; j < Math.abs(K-1-i); j++) {
                security[i][j] = 0;
                col++;
            }
            if (i < length/2+1) {
                for (int j = 0; j < 2*i+1; j++) {
                    security[i][col+j] = 3;
                }
            } else {
                int a = length-i-1;
                for (int j = 0; j < 2*a+1; j++) {
                    security[i][col+j] = 3;
                }
            }
        }
        return security;
    }

    static int findMaxHouses(int K) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Integer.max(max, findNumberOfHouses(K, i, j));
            }
        }
        return max;
    }

    static int findNumberOfHouses(int K, int a, int b) { //a, b는 map상 좌표
        int length = 2*K-1;
        int houses = 0;
        int[][] security = getSecurity(K);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (a-K+i >= 0 && a-K+i < N && b-K+j >= 0 && b-K+j < N) {
                    if (security[i][j] == 3 && map[a-K+i][b-K+j] == 1) {
                        houses++;
                    }
                }
            }
        }

        //수익이 남는지 봐야함
        if (revenue(K, houses) < 0) {
            return 0;
        } else {
            return houses;
        }
    }

    static int findMaxK() {
        int max = 0;
        for (int i = 1; i <= 2*N; i++) {
            if (M*house - (i*i+(i-1)*(i-1)) < 0) break;
            max = i;
        }
        return max;
    }

}
