import java.util.*;
import java.io.*;
public class B14442_벽부수고이동하기2 {
    static class Node {
        int x, y, dist, destroy;

        public Node(int x, int y, int dist, int destroy) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.destroy = destroy;
        }
    }

    static int N, M, K, answer, map[][];
    static boolean visited[][][];
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); //벽 부술 수 있는 범위

        map = new int[N][M];
        visited = new boolean[N][M][K+1];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        answer = -1;
        bfs();

        System.out.println(answer);
    }

    static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == N-1 && now.y == M-1) {
                answer = now.dist;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny][now.destroy] && map[nx][ny] == 0) {
                        q.add(new Node(nx, ny, now.dist+1, now.destroy));
                        visited[nx][ny][now.destroy] = true;
                    } else if (now.destroy < K && !visited[nx][ny][now.destroy+1]) {
                        q.add(new Node(nx, ny, now.dist+1, now.destroy+1));
                        visited[nx][ny][now.destroy+1] = true;
                    }
                }
                
            }
        }
    }
}
