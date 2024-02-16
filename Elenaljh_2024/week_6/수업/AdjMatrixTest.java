package 수업;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

//무향 그래프
public class AdjMatrixTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] adjMatrix = new int[V][V];
        for (int i = 0; i < E; i++) { //간선수만큼 돈다
            int from = sc.nextInt();
            int to = sc.nextInt();
            //무향 그래프
            adjMatrix[from][to] = adjMatrix[to][from] = 1; //무향이므로 간선 양방향 처리
        }

        bfs2(adjMatrix, 0);
    }


    static void bfs(int[][] adjMatrix, int start) {
        int V = adjMatrix.length;

        // 1. 큐와 방문관리 배열 준비
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[V];

        // 2. 시작 임의의 정점(정점 start) 큐에 넣고 방문체크
        queue.offer(start);
        visited[start] = true;

        // 3. 큐로 방문관리
        while (!queue.isEmpty()) {
            int current = queue.poll(); //4. 탐색해야하는 정점 꺼내기
            //탐색정점에 관련된 로직 처리
            System.out.println((char)(current+65));

            // 5. 탐색정점의 주변 인접정점들 탐색될 수 있도록 처리하기
            for (int i = 0; i < V; i++) {
                if (adjMatrix[current][i] != 0 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    static void bfs2(int[][] adjMatrix, int start) { //나와서 방문처리
        int V = adjMatrix.length;

        // 1. 큐와 방문관리 배열 준비
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[V];

        // 2. 시작 임의의 정점(정점 start) 큐에 넣고 방문체크
        queue.offer(start);
//        visited[start] = true;

        // 3. 큐로 방문관리
        while (!queue.isEmpty()) {
            int current = queue.poll(); //4. 탐색해야하는 정점 꺼내기
            //탐색정점에 관련된 로직 처리
            visited[current] = true; //나와서 방문처리!!!
            System.out.println((char)(current+65));

            // 5. 탐색정점의 주변 인접정점들 탐색될 수 있도록 처리하기
            for (int i = 0; i < V; i++) {
                if (adjMatrix[current][i] != 0 && !visited[i]) {
                    queue.offer(i);
//                    visited[i] = true;
                }
            }
        }
    }
}
/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
 */


