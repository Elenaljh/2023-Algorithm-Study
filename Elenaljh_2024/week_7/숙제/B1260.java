package 숙제;
/*
DFS와 BFS
 */
import java.io.*;
import java.util.*;
public class B1260 {
    static int N, M, V;
    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list[first].add(second);
            list[second].add(first);
        }

        for (int i = 1; i < N+1; i++) {
            Collections.sort(list[i]);
        }

        dfs(V, new boolean[N+1]);
        sb.deleteCharAt(sb.length()-1);
        sb.append("\n");
        bfs(V);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

    }

    static void dfs(int current, boolean[] visited) {
        visited[current] = true;
        sb.append(current).append(" ");
        ArrayList<Integer> children = list[current];
        for (int i = 0; i < children.size(); i++) {
            if (!visited[children.get(i)]) {
                dfs(children.get(i), visited);
            }
        }
    }

    static void bfs(int current) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        q.add(current);
        visited[current] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            ArrayList<Integer> children = list[now];
            for (int i = 0; i < children.size(); i++) {
                if (!visited[children.get(i)]) {
                    q.add(children.get(i));
                    visited[children.get(i)] = true;
                }
            }

        }
    }

}
