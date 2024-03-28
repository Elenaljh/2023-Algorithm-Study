import java.io.*;
import java.util.*;

class B4485_녹색옷입은애가젤다지 {
    // 다익스트라 써보자
    static int[][] map, cost;
    static int n;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int test = 0;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            map = new int[n][n];
            cost = new int[n][n];
            for (int i = 0; i < n; i++)
                Arrays.fill(cost[i], Integer.MAX_VALUE);

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();

            sb.append("Problem ").append(++test).append(": ").append(cost[n - 1][n - 1]).append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        // 초기 처리
        pq.add(new Integer[] { 0, 0, map[0][0] }); // x, y, (x, y)까지의 비용
        cost[0][0] = map[0][0];

        // 반복문
        while (!pq.isEmpty()) {
            Integer[] now = pq.poll();

            // 기록된 비용이 지금 비용보다 작다면 pass
            if (cost[now[0]][now[1]] < now[2]) {
                continue;
            }

            // 선택한 셀의 주변 셀을 고려
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (cost[nx][ny] > now[2] + map[nx][ny]) { // 해당 셀로 가는 원래 비용 > 새로운 비용
                        cost[nx][ny] = now[2] + map[nx][ny]; // 새로운 비용으로 갱신
                        pq.add(new Integer[] { nx, ny, cost[nx][ny] }); // 큐에 넣음
                    }
                }

            }
        }
    }

}