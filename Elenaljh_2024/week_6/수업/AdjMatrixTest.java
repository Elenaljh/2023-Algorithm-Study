package 수업;

import java.util.Arrays;
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

        for (int[] row : adjMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
