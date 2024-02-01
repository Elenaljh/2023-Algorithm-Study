import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
그림(실버1)
https://www.acmicpc.net/problem/1926
 */
public class B1926 {
    static int n, m;
    static int[][] paint;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        //초기 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paint = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paint[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //좌표 돌면서 그림 있는지 탐색
        int numOfPicts = 0;
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && paint[i][j] == 1) {
                    numOfPicts++;
                    maxSize = Math.max(maxSize, bfs(i, j));
                }
            }
        }
        System.out.println(numOfPicts);
        System.out.println(maxSize);
    }

    static int bfs(int x, int y) {
        Queue<Integer[]> q = new LinkedList<>();
        int size = 0;

        //초기 설정
        q.add(new Integer[]{x, y});
        visited[x][y] = true;

        //탐색
        while (!q.isEmpty()) {
            Integer[] now = q.poll();
            size++;

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (paint[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Integer[]{nx, ny});
                    }
                }
            }
        }
        return size;
    }
}
