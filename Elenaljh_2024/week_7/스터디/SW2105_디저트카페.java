package 스터디;

import java.io.*;
import java.util.*;

public class SW2105_디저트카페 {
    static int dx[] = new int[]{1, 1, -1, -1}; //좌측 아래, 우측 아래, 우측 위, 좌측 위 (반시계방향)
    static int dy[] = new int[]{-1, 1, 1, -1};
    static int MAX, map[][], N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            MAX = -1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    selectLength(i, j);
                }
            }

            sb.append("#").append(testCase).append(" ").append(MAX).append("\n");

        }
        System.out.println(sb);
    }

    static void selectLength(int x, int y) {
        for (int i = 1; i < N-1; i++) { //우상향 대각선 한 변: i
            for (int j = 1; j < N-1; j++) { //우하향 대각선의 한 변: j
                findPath(x, y, i, j);
            }
        }
    }

    static void findPath(int x, int y, int length1, int length2) {
        List<Integer> desserts = new ArrayList<>();
        //좌하향 이동
        for (int i = 0; i < length1; i++) {
            x = x + dx[0]; y = y + dy[0];
            if (x < 0 || x >= N || y < 0 || y >= N) return;
            if (desserts.contains(map[x][y])) return;
            desserts.add(map[x][y]);
        }
        //우하향 이동
        for (int i = 0; i < length2; i++) {
            x = x + dx[1]; y = y + dy[1];
            if (x < 0 || x >= N || y < 0 || y >= N) return;
            if (desserts.contains(map[x][y])) return;
            desserts.add(map[x][y]);
        }
        //우상향 이동
        for (int i = 0; i < length1; i++) {
            x = x + dx[2]; y = y + dy[2];
            if (x < 0 || x >= N || y < 0 || y >= N) return;
            if (desserts.contains(map[x][y])) return;
            desserts.add(map[x][y]);
        }
        //좌상향 이동
        for (int i = 0; i < length2; i++) {
            x = x + dx[3]; y = y + dy[3];
            if (x < 0 || x >= N || y < 0 || y >= N) return;
            if (desserts.contains(map[x][y])) return;
            desserts.add(map[x][y]);
        }
        MAX = Integer.max(MAX, desserts.size());
    }

}
