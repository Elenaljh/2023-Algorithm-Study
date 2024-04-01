import java.io.*;
import java.util.*;
public class B10815_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[m];
        for (int i = 0; i < m; i++) B[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i : B) {
            sb.append(binarySearch(A, i) ? 1 : 0).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static boolean binarySearch(int[] A, int target) {
        int start = 0;
        int end = A.length-1;

        while (start <= end) {
            int mid = (start+end)/2;

            if (A[mid] == target) return true;
            if (A[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return false;
    }
}
