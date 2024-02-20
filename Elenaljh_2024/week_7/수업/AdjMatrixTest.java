package 수업;

import java.util.Scanner;

public class AdjMatrixTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] adjMatrix = new int[V][V];
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjMatrix[to][from] = adjMatrix[from][to] = 1;
        }

        dfs(adjMatrix, new boolean[V], 0);

    }

    //인접 행렬
    static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
        int V = adjMatrix.length;
        visited[current] = true;
        System.out.println((char)(current+65));
        for (int i = 0; i < V; i++) {
            if (adjMatrix[current][i] != 0 && !visited[i]) {
                dfs(adjMatrix, visited, i);
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