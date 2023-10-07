import java.util.*;
import java.io.*;

public class B4963 {
    static String[] strs;
    static int w, h = 0;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] graph;
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        strs = br.readLine().split(" ");
        w = Integer.parseInt(strs[0]);
        h = Integer.parseInt(strs[1]);

        while (w != 0 && h != 0) {
            graph = new int[h][w];
            int sumCnt = 0;
            //지도 초기화
            for (int i = 0; i < h; i++) {
                strs = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(strs[j]);
                }
            }
            //bfs 수행
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j] != 0) {
                        sumCnt++;
                        bfs(i, j);
                    }
                }
            }

            sb.append(sumCnt + "\n");

            strs = br.readLine().split(" ");
            w = Integer.parseInt(strs[0]);
            h = Integer.parseInt(strs[1]);
        }
        System.out.println(sb.toString());
    }

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        graph[x][y] = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int cx = node.x + dx[i];
                int cy = node.y + dy[i];
                if (cx >= 0 && cy >= 0 && cx < h && cy < w) {
                    if (graph[cx][cy] == 1) {
                        graph[cx][cy] = 0;
                        q.offer(new Node(cx, cy));
                    }
                }
            }
        }
    }
}
