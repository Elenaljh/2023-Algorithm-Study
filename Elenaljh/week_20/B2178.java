import java.io.*;
import java.util.*;

public class B2178 {
    static int n;
    static int m;
    static int miro[][];
    static int dist[][];
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        miro = new int[n][m];
        dist = new int[n][m]; //방문표시 + 거리측정 역할 동시에 수행

        for (int i = 0; i < n; i++) {
            miro[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(dist[i], -1);
        }
        bfs();
        System.out.println(dist[n-1][m-1]+1); //dist의 초기값이 -1이었으므로 +1 해서 출력
    }

    static void bfs() {
        Queue <int[]> q = new LinkedList<>();
        int x = 0;
        int y = 0;
        q.add(new int[]{x, y});
        dist[0][0] = 0;

        while(!q.isEmpty()) {
            int pair[] = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pair[0] + dx[i];
                int ny = pair[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (miro[nx][ny] == 1 && dist[nx][ny] == -1) { //길이 있고 방문하지 않았다면
                        q.add(new int[]{nx, ny});
                        dist[nx][ny] = dist[pair[0]][pair[1]] + 1; //dist의 (이전 블록값 + 1)을 해당 블록에 저장
                    }
                }
            }
        }
    }

}
