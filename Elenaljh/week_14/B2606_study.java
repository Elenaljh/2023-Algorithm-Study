import java.io.*;
import java.util.*;

public class B2606_study {
    static boolean[][] network;
    static boolean[] visited;
    static int com, pair;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        com = Integer.parseInt(br.readLine());
        pair = Integer.parseInt(br.readLine());

        network = new boolean[com+1][com+1]; //index때문
        visited = new boolean[com+1];

        StringTokenizer st;
        int x, y;
        for (int i = 0; i < pair; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            network[x][y] = network[y][x] = true;
        }

        dfs(1);
        System.out.println(count-1);
    }

    public static void dfs(int index) {
        count++;
        visited[index] = true;
        for (int i = 1; i <= com; i++) {
            if (!visited[i] && network[index][i]) {
                dfs(i);
            }
        }
    }
}
