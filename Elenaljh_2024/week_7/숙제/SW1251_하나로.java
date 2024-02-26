package 숙제;

import java.io.*;
import java.util.*;

public class SW1251_하나로 {
    static class Node implements Comparable<Node> {
        public int to;
        public long cost;

        public Node(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stx, sty;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int T = 1; T <= testCase; T++) {
            //변수 선언
            int N = Integer.parseInt(br.readLine());
            stx = new StringTokenizer(br.readLine());
            sty = new StringTokenizer(br.readLine());
            long[] X = new long[N];
            long[] Y = new long[N];
            for (int i = 0; i < N; i++) {
                X[i] = Integer.parseInt(stx.nextToken());
                Y[i] = Integer.parseInt(sty.nextToken());
            }
            boolean[] visit = new boolean[N];
            double E = Double.parseDouble(br.readLine());

            //섬 사이 거리 저장 (출발지: i, 도착지: j, 거리: distance)
            ArrayList<Node>[] list = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    long distance = ((X[i]-X[j])*(X[i]-X[j]) + (Y[i]-Y[j])*(Y[i]-Y[j]));
                    list[i].add(new Node(j, distance));
                }
            }

            //Prim 알고리즘 사용 -> Priority Queue에 넣고 출발지에서 가장 가까운 섬 찾기
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, 0)); //list 맨 첫번째부터 탐색 시작
            long answer = 0; int count = 0; //answer에는 비용 저장, count에는 탐색한 섬의 수 저장

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                if (visit[node.to]) continue; //만약 방문한 적 있는 곳이라면 패스
                visit[node.to] = true;
                answer += node.cost;
                if (++count == N) break; //N개의 섬을 모두 탐색한 경우 중단
                for (Node n : list[node.to]) { //다음 섬으로 건너가서 그 섬에 연결된 섬 목록을 모두 pq에 넣음
                    if (!visit[n.to]) pq.add(n); //해당 섬은 방문한 적 없는 섬 이어야 함
                }
            }

            String round = String.format("%.0f", answer*E);

            sb.append("#").append(T).append(" ").append(round).append("\n");
        }
        System.out.println(sb);
    }
}
