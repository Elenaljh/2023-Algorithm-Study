package 과제;

import java.io.*;
import java.util.*;
public class SW1233_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] graph = new int[N + 1][2];
            char[] nodeShape = new char[N + 1];
            for (int i = 1; i < N + 1; i++ ) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int now = Integer.parseInt(st.nextToken());
                nodeShape[now] = st.nextToken().charAt(0);
                if (st.hasMoreTokens()) {
                    graph[now][0] = Integer.parseInt(st.nextToken());
                }
                if (st.hasMoreTokens()) {
                    graph[now][1] = Integer.parseInt(st.nextToken());
                }
            }
            char[] shape = new char[] { '+', '-', '/', '*' };
            int res = 1;
            for (int i = 1; i < N + 1; i++) {
                boolean flag = false;
                for (char v : shape) {
                    if (nodeShape[i] == v) flag = true;
                }
                if (flag && graph[i][0] == 0 && graph[i][1] == 0) {
                    res = 0;
                } else if (!flag && (graph[i][0] != 0 || graph[i][1] != 0)) {
                    res = 0;
                }
            }
            System.out.println(String.format("#%d %d", t, res));
        }
    }
}
