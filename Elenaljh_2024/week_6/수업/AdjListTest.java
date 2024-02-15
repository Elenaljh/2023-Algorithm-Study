package 수업;

import java.util.Arrays;
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

        for (Node node : adjList) {
            System.out.println(node);
        }
    }
}
