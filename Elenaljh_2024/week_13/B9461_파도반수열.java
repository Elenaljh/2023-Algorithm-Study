import java.io.*;
import java.util.*;
public class B9461_파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Long> arr = new ArrayList<>();
            arr.add(1L); arr.add(1L); arr.add(1L); arr.add(2L); arr.add(2L); arr.add(3L); arr.add(4L);
            arr.add(5L); arr.add(7L); arr.add(9L);
            for (int i = 10; i < n; i++) {
                long a = arr.get(i-1);
                long b = arr.get(i-5);
                arr.add(a+b);
            }
            sb.append(arr.get(n-1)).append("\n");
        }
        System.out.println(sb);
    }
}
