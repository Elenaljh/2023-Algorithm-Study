import java.io.*;
import java.util.*;

public class B1012 {
    static int M, N, K; //배추밭 가로길이, 세로길이, 배추가 심어져있는 위치의 개수
    static int[][] cabbage; //배추가 심어져있는 땅의 좌표 저장
    static boolean[][] visit; //체크한 장소 좌표 저장
    static int count; //필요한 지렁이 수
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //테스트케이스 개수

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //땅 가로길이
            N = Integer.parseInt(st.nextToken()); //땅 세로길이
            K = Integer.parseInt(st.nextToken()); //배추 개수
            cabbage = new int[M][N]; //M*N 크기의 2차원 배열
            visit = new boolean[M][N]; //M*N 크기의 2차원 배열
            count = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                cabbage[p1][p2] = 1; //배추가 심어져 있는 땅의 좌표에 1 저장
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {  //양배추가 심어져있고 체크하지 않은 모든 좌표에 대해 bfs(i, j) 실시
                    if (cabbage[i][j] == 1 && !visit[i][j]) {
                        bfs(i, j); //따로 함수로 빼놓음
                        count++; //bfs가 끝나면 count +1 하기
                    }
                }
            }
            System.out.println(count); //각 테스트케이스마다 결과 출력 (줄바꿈O)
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>(); //큐 하나 만들기
        q.add(new int[] {x, y}); //큐에 인자로 들어온 (x, y) 저장 -> (x, y)는 체크하지 않은 땅 & 양배추가 심긴 땅

        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1]; //큐 안에 저장된 (선입) 배열을 x, y에 저장
            visit[x][y] = true; //해당 좌표에 방문표시 함
            q.poll(); //해당 좌표 큐에서 꺼냄
            for (int i = 0; i < 4; i++) { //해당 좌표의 동, 서, 남, 북 방향의 좌표 확인
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < M && cy < N) { // 값의 유효성 검사
                    if (!visit[cx][cy] && cabbage[cx][cy] == 1) { //만약 해당 좌표를 체크하지 않았고, 해당 좌표에 양배추가 있으면
                        q.add(new int[] {cx, cy}); //해당 좌표를 큐에 저장
                        visit[cx][cy] = true; //방문표시 하기
                    }
                }
            }
        }
    }
}