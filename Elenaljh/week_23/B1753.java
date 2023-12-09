import java.io.*;
import java.util.*;
public class B1753 {
    //변수 선언
    public static int v, e, k;
    public static int[] distance;
    public static boolean[] visited;
    public static ArrayList<Edge>[] list;
    public static PriorityQueue<Edge> q = new PriorityQueue<Edge>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken()); //정점의 개수 (노드)
        e = Integer.parseInt(st.nextToken()); //간선의 개수 (에지)
        k = Integer.parseInt(br.readLine()); //시작 정점 번호

        distance = new int[v + 1];
        visited = new boolean[v + 1];
        list = new ArrayList[v + 1];

        //데이터 입력
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i <= v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        //가중치가 있는 인접 리스트 초기화
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }

        //k를 시작점으로 설정
        q.add(new Edge(k, 0));
        distance[k] = 0;
        while(!q.isEmpty()) {
            Edge current = q.poll();
            int c_v = current.vertex;
            if (visited[c_v]) continue; //이미 방문한 적이 있는 노드는 큐에 넣지 않음
            visited[c_v] = true;
            for (int i = 0; i < list[c_v].size(); i++) {
                Edge tmp = list[c_v].get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                if(distance[next] > distance[c_v]+value) { // 타깃 노드 최단 거리 > 현재 노드 최단 거리 + 비용
                    distance[next] = value + distance[c_v]; //타깃 노드 최단 거리 업데이트 (현재 노드 최단 거리 + 비용으로)
                    q.add(new Edge(next, distance[next])); //우선순위 큐에 타깃 노드 추가
                }
            }
        }

        //출력
        for (int i = 1; i <= v; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }



    }
}

// 가중치가 있는 그래프를 담기 위한 클래스
class Edge implements Comparable<Edge> {
    int vertex, value;
    Edge(int vertex, int value) {
        this.vertex = vertex; //가리키는 노드
        this.value = value; //가중치
    }

    //우선순위 큐 정렬 기준을 위해 compareTo 함수 구현
    @Override
    public int compareTo(Edge o) {
        if (this.value > o.value) return 1;
        else return -1;
    }
}
