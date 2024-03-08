import java.util.*;
import java.io.*;
public class B7795_먹을것인가먹힐것인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] A = new int[n];
            int[] B = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) B[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(A);
            Arrays.sort(B);

            int s = 0;
            int pointer = n-1;
            for(int i = m-1; i > -1; i--) {
                while (pointer > -1 && B[i] < A[pointer]) pointer--;
                s += (n - 1) - pointer;
            }
            System.out.println(s);
        }
    }
}
