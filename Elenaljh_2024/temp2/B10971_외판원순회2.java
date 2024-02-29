import java.io.*;
import java.util.*;
public class B10971_외판원순회2 {
    static int N, adjMatrix[][], MIN;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //도시의 수
        adjMatrix = new int[N][N]; //인접행렬
        MIN = Integer.MAX_VALUE;

        //인접행렬 작성
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            int[] selected = new int[N];
            visited[i] = true;
            selected[0] = i;
            dfs(1, selected, visited, 0, i);
        }

        System.out.println(MIN);
    }

    static void dfs(int count, int[] selected, boolean[] visited, int cost, int start) {
        int prev = selected[count-1];
        if (count == N) {
            if (adjMatrix[prev][start] == 0) return;
            cost += adjMatrix[prev][start];
            MIN = Integer.min(MIN, cost);
            return;
        }

        if (cost >= MIN) return; //가지치기

        for (int i = 0; i < N; i++) {
            if (!visited[i] && adjMatrix[prev][i] != 0) {
                visited[i] = true;
                selected[count] = i;
                dfs(count+1, selected, visited, cost+adjMatrix[prev][i], start);
                visited[i] = false;
            }
        }
    }
}
