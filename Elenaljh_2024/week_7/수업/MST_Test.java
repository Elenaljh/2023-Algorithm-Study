package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MST_Test {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int V;
    static Edge[] edgeList;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        edgeList = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(from, to, weight);
        } //간선 리스트 생성
        //인접리스트, 인접행렬같은 정점 중심 그래프 표현에서는 무향 그래프일 때 from과 to를 뒤집어서 저장
        //그러나 이건 간선리스트이기 때문에 굳이 from과 to를 뒤집어서 저장할 필요가 없다

        //전처리: 간선리스트 오름차순 정렬
        Arrays.sort(edgeList);

        //Union-Find알고리즘 이용

        //1. make-set 연산
        make();

        //2. 정렬된 간선을 하나씩 꺼내 신장트리를 생성함
        int weight = 0;
        int cnt = 0;
        for (Edge edge : edgeList) {
            if (!union(edge.from, edge.to)) continue; //간선 선택에 실패한 경우 (사이클 발생)
            weight += edge.weight;
            if(++cnt == V-1) break; //선택한 간선 수가 v-1개가 되면 작업 종료 (MST 완성)
        }

        System.out.println(weight);
    }

    static void make() {
        //정점이 0부터 시작함. 경로압축으로 인해 항상 조상이 부모가 되므로 배열에 부모를 저장할 수 있음
        parents = new int[V];
        for (int i = 0; i < V; i++) {
            parents[i] = i; //모든 정점을 자신의 대표자(루트)로 만듦
        }
    }

    static int find(int a) { //a가 속한 트리의 루트 찾기
        if (a == parents[a]) { //a가 자기 자신의 대표라면 (a가 루트)
            return a;
        }

        return parents[a] = find(parents[a]); //a의 루트를 찾아서 a의 부모로 바꾼 후 반환 (경로압축)
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false; //a와 b의 루트가 같은 경우 union 불필요

        parents[bRoot] = aRoot; //b루트의 부모를 a루트로 바꿈. 비용때문에 따로 랭크관리는 X
        return true;
    }

}
