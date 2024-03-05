import java.io.*;
import java.util.*;
public class SW1949_등산로조성 {
    static int N, K, map[][], MAX;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            MAX = 0;

            int max = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Integer.max(max, map[i][j]);
                }
            }

            List<Integer[]> startPoints = findStart(max);
            for (Integer[] start : startPoints) {
                int x = start[0]; int y = start[1];
                boolean[][] visited = new boolean[N][N];
                visited[x][y] = true;
                dfs(0, x, y, visited, false);
            }

            sb.append("#").append(test).append(" ").append(MAX).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int x, int y, boolean[][] visited, boolean dig) {
        boolean foundPath = false;
        int currentH = map[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] < currentH) {
                    foundPath = true;
                    visited[nx][ny] = true;
                    dfs(depth+1, nx, ny, visited, dig);
                    visited[nx][ny] = false;
                } else if (!visited[nx][ny] && !dig && K >= (map[nx][ny]-currentH+1)) {
                    dig = true; foundPath = true;
                    int tmp = map[nx][ny];
                    map[nx][ny] = currentH-1;
                    visited[nx][ny] = true;
                    dfs(depth+1, nx, ny, visited, dig);
                    visited[nx][ny] = false;
                    map[nx][ny] = tmp;
                    dig = false;
                }
            }
        }
        if (!foundPath) {
            MAX = Integer.max(MAX, depth+1);
            return;
        }
    }

    static List<Integer[]> findStart(int max) {
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == max) list.add(new Integer[]{i, j});
            }
        }
        return list;
    }


}
