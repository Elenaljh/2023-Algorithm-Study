import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class B1916 {
    //변수선언
    static int n, m; //도시, 버스
    static ArrayList<Node>[] list; //노드 저장할 리스트
    static int[] dist; //거리
    static boolean[] visit; //방문여부

    //메인함수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //변수받고 리스트 만들기
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        dist = new int[n+1];
        visit = new boolean[n+1];

        //list에 노드 입력, dist 무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Node>();
        }

        //리스트에 (시작노드, 목적지, 가중치) 넣기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());
        int result = dijkstra(startIndex, endIndex);
        System.out.println(result);

    }

    //함수
    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));
        dist[start] = 0;
        while (!q.isEmpty()) {
            Node current = q.poll();
            int now = current.targetNode;
            if(!visit[now]) {
                visit[now] = true;
                for (Node e : list[now]) {
                    if (!visit[e.targetNode] && dist[e.targetNode] > dist[now] + e.value) {
                        dist[e.targetNode] = dist[now] + e.value;
                        q.add(new Node(e.targetNode, dist[e.targetNode]));
                    }
                }
            }
        }
        return dist[end];
    }

}

//Node 클래스
class Node implements Comparable<Node> {

    int targetNode;
    int value;
    Node(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }
}