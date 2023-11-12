import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class B7576 {
    static int n;
    static int m;
    static int[][] days;
    static int[][] tomatoes;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();
    static int unripe = 0, result = 0; //안익은 토마토 개수, 결과
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        days = new int[n][m]; //방문여부 확인, 토마토 익은 날짜 저장
        tomatoes = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                days[i][j] = -1;
                tomatoes[i][j] = Integer.parseInt(st.nextToken());

                if (tomatoes[i][j] == 1) {
                    q.add(new int[]{i, j}); //익은 토마토가 있는 곳은 큐에 넣는다 (시작점 세팅_
                    days[i][j] = 0; //방문표시
                } else {
                    unripe++; //익지 않은 토마토 개수
                }
            }
        }

        if (unripe == 0) { //모두 익은 상태면 0 출력
            System.out.println(0);
            return;
        } else {
            bfs();
        }

        if (unripe > 0) {
            System.out.println(-1); //익을 수 없는 토마토가 있으므로 -1 출력
        } else {
            System.out.println(result);
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] pair = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pair[0] + dx[i];
                int ny = pair[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (tomatoes[nx][ny] != -1 && days[nx][ny] == -1) {
                        q.add(new int[]{nx, ny}); //익은 토마토는 큐에 넣음
                        unripe--; //안익은 토마토 개수 -1
                        days[nx][ny] = days[pair[0]][pair[1]] + 1; //날짜에 +1 (날짜가 계속 누적됨)
                        if (result < days[nx][ny]) { //result = 바로 전 토마토의 날짜 +1
                            result = days[nx][ny];
                        }
                    }
                }
            }
        }

    }
}
