package 수업;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

//무향 그래프 : 연결리스트 버전!
public class AdjListTest {
    static class Node{
        int to;
        Node next; //다음 노드 연결을 위한 링크 포인터

        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }

        public Node(int to) {
            this.to = to;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "to=" + to +
                    ", next=" + next +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        Node[] adjList = new Node[V]; //각 정점의 인접리스트의 헤드 저장
        for (int i = 0; i < E; i++) { //간선수만큼 돈다
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjList[from] = new Node(to, adjList[from]); //맨 앞으로 삽입하는 알고리즘
            adjList[to] = new Node(from, adjList[to]); //무향이기 때문에 뒤집어서도 저장한다
        }
//        bfs(adjList, 0);
        dfs(adjList, new boolean[V], 0);
    }

    static void bfs(Node[] adjList, int start) {
        int V = adjList.length;

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
            for (Node temp = adjList[current]; temp != null; temp = temp.next) {
                if (!visited[temp.to]) {
                    queue.offer(temp.to);
                    visited[temp.to] = true;
                }
            }
        }
    }

    static void dfs(Node[] adjList, boolean[] visited, int current) {
        visited[current] = true;
        System.out.println((char)(current+65));
        for (Node temp = adjList[current]; temp != null; temp = temp.next) {
            if (!visited[temp.to]) {
                dfs(adjList, visited, temp.to);
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