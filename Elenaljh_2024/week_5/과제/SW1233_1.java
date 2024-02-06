package 과제;

import java.io.*;
import java.util.*;

public class SW1233_1 {
    static int res;
    static int[][] graph;
    static String[] nodeShape;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            res = 1;
            graph = new int[N+1][2];
            nodeShape = new String[N+1];
            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int now = Integer.parseInt(st.nextToken());
                nodeShape[now] = st.nextToken();
                if (st.hasMoreTokens()) {
                    graph[now][0] = Integer.parseInt(st.nextToken());
                }
                if (st.hasMoreTokens()) {
                    graph[now][1] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(1);
            System.out.println(String.format("#%d %d", t, res));        }
    }
    public static void dfs(int nowNode) {

        for (int i = 0; i < 2; i++) {
            int nextNode = graph[nowNode][i];
            if (isInteger(nodeShape[nowNode]) && nextNode != 0) res = 0;
            if (nextNode != 0) {
                dfs(nextNode);
            }
        }
        if (!isInteger(nodeShape[nowNode]) && graph[nowNode][0] == 0 && graph[nowNode][1] == 0) {
            res = 0;
        }
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
