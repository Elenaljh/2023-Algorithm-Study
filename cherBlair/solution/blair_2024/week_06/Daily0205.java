package blair_2024.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Daily0205 {

    // 05-1 깊이 우선 탐색 DFS

    // 연결 요소의 개수 구하기
    // https://www.acmicpc.net/problem/11724

    static ArrayList<Integer>[] A;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        A = new ArrayList[nodeCount + 1];
        visited = new boolean[nodeCount + 1];

        // 인접 리스트 초기화
        for (int i = 1; i < nodeCount + 1; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 양방향 에지이므로 양쪽에 에지 더하기
            A[start].add(end);
            A[end].add(start);
        }
        int count = 0;
        for (int i = 1; i < nodeCount + 1; i++) {
            // 방문하지 않은 노드가 없을때까지 반복하기
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    private static void DFS(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : A[v]) {
            // 연결 노드 중 방문하지 않았던 노드만 탐색하기
            if (visited[i] == false) {
                DFS(i);
            }
        }
    }
}
