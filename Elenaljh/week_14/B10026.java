import java.io.*;
import java.util.*;

public class B10026 {
    static int N;
    static char[][] picture;
    static boolean[][] visit;
    static int countA, countB;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];
        visit = new boolean[N][N];
        countA = 0;
        countB = 0;

        //picture 저장
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                picture[i][j] = s.charAt(j);
            }
        }

        //적록색맹X bfs 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == false) {
                    bfs(i, j); //색맹X
                    countA++;
                }
            }
        }

        visit = new boolean[N][N];

        //적록색맹O bfs 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (picture[i][j] == 'R') {
                    picture[i][j] = 'G';
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == false) {
                    bfs(i, j);
                    countB++;
                }
            }
        }

        System.out.println(countA + " " + countB);

    }

    static void bfs (int x, int y) {
        char color = picture[x][y];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});

        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1];
            visit[x][y] = true;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < N && cy < N) {
                    if (visit[cx][cy] == false && picture[cx][cy] == color) {
                        q.add(new int[] {cx, cy});
                        visit[cx][cy] = true;
                    }
                }
            }
        }


    }
}
