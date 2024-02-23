package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimTest {

    static class Vertex implements Comparable<Vertex> {
        int no, weight;

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine()); //정점 갯수
        int[][] adjMatrix = new int[V][V]; //인접행렬 준비
        boolean[] visited = new boolean[V]; //트리 정점 여부
        int[] minEdge = new int[V]; //비트리정점 기준으로 트리정점들과 연결했을 경우 최소 간선 비용

        StringTokenizer st;

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>(); //----------------추가된 내용

        Arrays.fill(minEdge, Integer.MAX_VALUE); //최소값 갱신 위해 max로 초기화
        minEdge[0] = 0; //임의의 시작점 0으로 초기화
        pq.offer(new Vertex(0, minEdge[0])); //---------------추가된 내용
        int result = 0; //최소신장트리 비용

        int c = 0;
        while (!pq.isEmpty()) {
            //step 1 : 비트리 정점 중 최소간선비용의 정점을 찾기
            Vertex minVertex = pq.poll();
            if (visited[minVertex.no]) continue; //이미 해당 정점이 트리에 포함되었다면

            result += minVertex.weight;
            visited[minVertex.no] = true; //해당 정점을 트리에 추가
            if(++c == V) break; //트리 정점에 포함될 때마다 카운트


            //step 2 : 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점들과의 간선비용 고려해서 최적으로 업데이트
            for (int i = 0; i < V; i++) {
                if (!visited[i] && adjMatrix[minVertex.no][i] != 0 && adjMatrix[minVertex.no][i] < minEdge[i]) { //비트리정점이면서 인접정점이고 간선비용이 기존 min비용보다 작은 경우
                    minEdge[i] = adjMatrix[minVertex.no][i]; //minEdge 갱신 (아직 트리로 편입하는 것은 아니다!)
                    pq.offer(new Vertex(i, minEdge[i]));
                }
            }

        }

        System.out.println(c == V?result:-1); //c가 정점 갯수와 같을 때 result찍고, 그렇지 않으면 중간에 break로 빠져나온 것이므로 불가능

    }
}
/*
5
0 5 10 8 7
5 0 5 3 6
10 5 0 1 3
8 3 1 0 1
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175

5
0 5 10 8 0
5 0 5 3 0
10 5 0 1 0
8 3 1 0 0
0 0 0 0 0

output ==> -1
 */