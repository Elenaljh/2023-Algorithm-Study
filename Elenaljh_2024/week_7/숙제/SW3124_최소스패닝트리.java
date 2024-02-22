package 숙제;

import java.util.*;
import java.io.*;
public class SW3124_최소스패닝트리 {
    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
//        int testCase = 2;
        for (int T = 1; T <= testCase; T++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            parent = new int[V+1];
            make();
            Edge[] edgeList = new Edge[E];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(first, second, weight);
            }
            Arrays.sort(edgeList);

            long weight = 0; //간선 개수가 엄청 많고 weight 절댓값 범위도 크기 때문에 long타입으로 해야 한다!!!
            int count = 0;
            for (Edge edge : edgeList) {
                if (!union(edge.start, edge.end)) continue;
                weight += edge.weight;
                if (++count == V-1) break;
            }

            sb.append("#").append(T).append(" ").append(weight).append("\n");
        }
        System.out.println(sb);
    }

    static void make() { //단위트리 만들기
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]); //경로축소
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        parent[bRoot] = aRoot;
        return true;
    }
}
