package 스터디;

import java.io.*;
import java.util.*;
public class B1260 {
    static int N, M, V;
    static StringBuilder dfs = new StringBuilder();
    static StringBuilder bfs = new StringBuilder();

    static class Node implements Comparable<Node> {
        int to;
        Node next; //다음 노드 연결을 위한 링크 포인터

        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return this.to - o.to;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수
        V = Integer.parseInt(st.nextToken()); //시작 정점 번호

        Node[] adjList = new Node[N+1]; //각 정점 인접리스트의 헤드 저장
        Node[] tmp = new Node[2*M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
//            adjList[from] = new Node(to, adjList[from]);
//            adjList[to] = new Node(from, adjList[to]);

        }
        dfs(adjList, new boolean[N+1], V);
        bfs(adjList, V);

        System.out.println(dfs);
        System.out.println(bfs);
    }
    static void dfs(Node[] adjList, boolean[] visited, int current) {
        visited[current] = true; //현재 노드 방문표시
        dfs.append(current).append(" "); //스트링빌더에 저장
        for (Node temp = adjList[current]; temp != null; temp = temp.next) {
            if (!visited[temp.to]) {
                dfs(adjList, visited, temp.to); //간선으로 연결된 노드를 방문하지 않았다면 방문ㄱ
            }
        }
    }

    static void bfs(Node[] adjList, int start) {
        int Length = adjList.length;

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[Length];

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            bfs.append(current).append(" ");

            for (Node temp = adjList[current]; temp != null; temp = temp.next) {
                if (!visited[temp.to]) {
                    queue.offer(temp.to);
                    visited[temp.to] = true;
                }
            }
        }
    }
}
