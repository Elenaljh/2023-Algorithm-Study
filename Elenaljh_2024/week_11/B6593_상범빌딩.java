import java.io.*;
import java.util.*;
public class B6593_상범빌딩 {
    static int[] dx = new int[] {-1, 1, 0, 0, 0, 0}; //상, 하, 좌, 우, up, down
    static int[] dy = new int[] {0, 0, -1, 1, 0, 0};
    static int[] dz = new int[] {0, 0, 0, 0, 1, -1};
    static int L, R, C, ans;
    static Queue<Integer[]> q; //x, y, z, time
    static boolean visit[][][];
    static char[][][] map;
    public static void main(String[] args) throws IOException {
//        System.out.println("안녕 내 이름은 고난 함정이죠 ㅋㅋㅎㅋㅎㅋㅎㅋㅎㅋㅎㅋㅎㅋㅎㅋ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken()); //층
            R = Integer.parseInt(st.nextToken()); //행
            C = Integer.parseInt(st.nextToken()); //열
            if (L==0 && R==0 && C==0) {
                System.out.println(sb);
                return;
            }
            q = new ArrayDeque<>();
            map = new char[L][R][C];
            visit = new boolean[L][R][C];

            for (int k = 0; k < L; k++) {
                for (int i = 0; i < R; i++) {
                    String str = br.readLine();
                    for (int j = 0; j < C; j++) {
                        map[k][i][j] = str.charAt(j);
                        if (map[k][i][j] == 'S') {
                            q.add(new Integer[]{i, j, k, 0});
                            visit[k][i][j] = true;
                        }
                    }
                }
                br.readLine();
            }

            ans = -1;
            bfs();

            if (ans == -1) {
                sb.append("Trapped!").append("\n");
                continue;
            }
            sb.append("Escaped in ").append(ans).append(" minute(s).\n");
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Integer[] now = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int nz = now[2] + dz[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && nz >= 0 && nz < L) {
                    if (!visit[nz][nx][ny] && (map[nz][nx][ny] == '.' || map[nz][nx][ny] == 'E')) {
                        if (map[nz][nx][ny] == 'E') {
                            ans = now[3] + 1;
                            return;
                        }
                        q.add(new Integer[]{nx, ny, nz, now[3]+1});
                        visit[nz][nx][ny] = true;
                    }
                }
            }
        }
    }
}
