package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {
    public static class Node {
        public int vertex;
        public int weight;
        public Node next;

        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "vertex=" + vertex +
                    ", weight=" + weight +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); //정점 갯수
        int E = Integer.parseInt(st.nextToken()); //간선 갯수
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); //시작점 인덱스
        int end = Integer.parseInt(st.nextToken()); //도착점 인덱스
        final int INF = Integer.MAX_VALUE;

        Node[] adjList = new Node[V];
        int[] minDistance = new int[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, weight, adjList[from]);
        } //인접리스트 생성
        Arrays.fill(minDistance, INF);
        minDistance[start] = 0; //출발지에서 출발지로의 비용 0으로 초기화

        int min = 0, stopOver = 0;
        for (int i = 0; i < V; i++) { //모든 정점이 다 처리될때까지 반복
            //step1 : 미방문 정점 중 출발지에서 가장 가까운 정점 선택
            min = INF;
            stopOver = -1;

            for (int j = 0; j < V; j++) {
                if (!visited[j] && min > minDistance[j]) {
                    min = minDistance[j];
                    stopOver = j; //현재 정점을 경유지 정점으로 기억해둠
                }
            }

            if (stopOver == -1) break;
            visited[stopOver] = true;
//            if (stopOver == end) break; //도착점이면 끝내기!!


            //step2 : 미방문 정점들에 대해 선택된 경유지를 거쳐서 가는 비용과 기존 최소비용을 비교해서 업데이트
            for (Node temp = adjList[stopOver]; temp != null; temp = temp.next) {
                if (!visited[temp.vertex] && minDistance[temp.vertex] > minDistance[stopOver] + temp.weight) {
                    minDistance[temp.vertex] = minDistance[stopOver] + temp.weight;
                }
            }
        }

        System.out.println(Arrays.toString(minDistance));
        System.out.println("정답: " + (minDistance[end] != INF ? minDistance[end] : -1));
    }

}

/*
6 11
0 5
0 1 3
0 2 5
1 2 2
1 3 6
2 1 1
2 3 4
2 4 6
3 4 2
3 5 3
4 0 3
4 5 6

output==> 12


6 11
5 4
0 1 3
0 2 5
1 2 2
1 3 6
2 1 1
2 3 4
2 4 6
3 4 2
3 5 3
4 0 3
4 5 6


output==> -1


10 17
0 9
0 1 4
0 2 6
1 3 9
1 4 8
2 1 3
2 4 2
2 5 3
3 6 6
4 3 2
4 5 1
4 6 3
4 7 7
5 7 4
5 8 8
6 9 13
7 9 9
8 9 4

output ==>21
 */