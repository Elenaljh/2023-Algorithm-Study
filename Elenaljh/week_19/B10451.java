import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10451 {
    static int[] per;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0){
            int N = Integer.parseInt(br.readLine());
            per = new int[N+1];
            visited = new boolean[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int cnt = 0;

            for(int i=1; i<N+1; i++){
                per[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<N+1; i++){
                if(!visited[i]){
                    dfs(per[i]);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int start){
        visited[start] = true;

        int next = per[start];
        if(!visited[next]) dfs(next);
    }
}
