import java.io.*;
import java.util.*;
public class B9205_맥주마시면서걸어가기 {

    //BFS
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        ArrayList<Integer[]> nodes;
        ArrayList<ArrayList<Integer>> graph;

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            nodes = new ArrayList<>();

            for (int i = 0; i < N+2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                nodes.add(new Integer[]{x, y});
            }

            graph = new ArrayList<>();
            for (int i = 0; i < N+2; i++) {
                graph.add(new ArrayList<>());
            }

            //1000m 이하를 만족하는 두 정점을 찾고 양방향 그래프로 이어줌
            for (int i = 0; i < N+2; i++) {
                for (int j = i+1; j < N+2; j++) {
                    if (length(nodes.get(i), nodes.get(j)) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            //BFS 이용해 집에서 페스티벌까지 갈 수 있는지 탐색
            sb.append((BFS(graph, N) ? "happy" : "sad") + '\n');
        }
        System.out.println(sb);
    }
    static int length(Integer[] a, Integer[] b) {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }

    static boolean BFS(ArrayList<ArrayList<Integer>> graph, int N) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        boolean[] visited = new boolean[N+2];
        visited[0] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == N+1) { //목적지 도착
                return true;
            }
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return false;
    }

}
