package blair_2024.week_08;

import java.util.ArrayList;
import java.util.Scanner;

public class Daily0219 {

    // 05-1 깊이 우선 탐색 DFS

    // 친구 관계 파악하기
    // https://www.acmicpc.net/problem/13023

    static boolean visited[];
    static ArrayList<Integer>[] A;
    static boolean arrive;

    public static void main(String[] args) {
        int N;  // 노드 개수
        int M;  // 에지 개수
        arrive = false;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            int S = scan.nextInt();
            int E = scan.nextInt();
            A[S].add(E);
            A[E].add(S);
        }
        for (int i = 0; i < N; i++) {  // depth 1부터 시작
            DFS(i, 1);
            if (arrive)
                break;
            ;
        }
        if (arrive)
            System.out.println("1");
        else
            System.out.println("0");  // 5의 깊이가 없다면 0 출력
    }

    public static void DFS(int now, int depth) {  // DFS 구현
        if (depth == 5 || arrive) {  // depth가 5가 되면 프로그램 종료
            arrive = true;
            return;
        }
        visited[now] = true;
        for (int i : A[now]) {
            if (!visited[i]) {
                DFS(i, depth + 1);  // 재귀 호출이 될 때마다 depth를 1씩 증가
            }
        }
        visited[now] = false;
    }
}
