import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class B14889 {
    static int min = 100000;
    static int[][] power;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n];
        visited[0] = true;

        power = new int[n][n];
        for (int i = 0; i < n; i++) {
            power[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        combination(visited, 1, n, n/2-1);

        System.out.println(min);

    }

    static void combination(boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int ssum = 0;
            int lsum = 0;
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    if (visited[i]==true && visited[j]==true) {
                        ssum += power[i][j] + power[j][i];
                    } else if (visited[i]==false && visited[j]==false) {
                        lsum += power[i][j] + power[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(ssum - lsum));
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(visited, i+1, n, r-1);
            visited[i] = false;
        }
    }

}
