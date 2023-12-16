import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class B11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 수열 길이
        int m = Integer.parseInt(st.nextToken()); // 반복 횟수
        int[] arr = new int[n+1]; //누적합 저장할 배열 -> 나중에 뺄거 생각해서 0 a a+b a+b+c a+b+c+d ... 형식으로 저장

        arr[0] = 0; //맨 첫번째에 0 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken()); //누적합 저장
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //인덱스
            int b = Integer.parseInt(st.nextToken()); //인덱스

            sb.append(arr[b]-arr[a-1]).append('\n'); //StringBuilder에 결과 저장
        }
        System.out.println(sb);

    }
}
