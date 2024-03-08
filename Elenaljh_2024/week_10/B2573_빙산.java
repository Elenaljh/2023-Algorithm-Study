import java.util.*;
import java.io.*;
public class B2573_빙산 {
    static int N, M, map[][];
    static boolean visited[][];
    static List<Integer[]> list;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) list.add(new Integer[]{i, j});
            }
        }

        //1년에 빙하 얼마나 녹는지 bfs 돌리기
        int result = 0;
        int count = 0;
        while (result == 0) {
            result = bfs();
            count++;
        }

        if (result == 1) {
            System.out.println(0);
        } else if (result == 2) {
            System.out.println(count);
        }
    }

    static int bfs() {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) newMap[i] = map[i].clone();
        Queue<Integer[]> q = new ArrayDeque<>(list);
        boolean melted = false;
        while (!q.isEmpty()) {
            Integer[] now = q.poll();
            int count = 0;
            if (map[now[0]][now[1]] != 0) {
                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) count++;
                }
                newMap[now[0]][now[1]] -= count;
                if (newMap[now[0]][now[1]] <= 0) {
                    newMap[now[0]][now[1]] = 0;
                    melted = true;
                }
            }
        }

        map = newMap;

        if (melted) {
            int numOfGlacier = countNumberOfGlacier();
            if (numOfGlacier == 1) {
                return 0;
            } else if (numOfGlacier == 0) {
                return 1;
            } else if (numOfGlacier > 1) {
                return 2;
            }
        }
        return 0;
    }

    static int countNumberOfGlacier() {
        visited = new boolean[N][M];
        Queue<Integer[]> q = new ArrayDeque<>();
        int count = 0;
        Loop1:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    q.add(new Integer[]{i, j});
                    check(q);
                    count++;
                    if (count > 1) break Loop1;
                }
            }
        }
        return count;
    }

    static void check(Queue<Integer[]> q) {
        while(!q.isEmpty()) {
            Integer[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] != 0 && !visited[nx][ny]) {
                        q.add(new Integer[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

}
