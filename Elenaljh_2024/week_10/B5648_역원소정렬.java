import java.util.*;
import java.io.*;
public class B5648_역원소정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Long> list = new ArrayList<>();
        int cnt = 0;
        int n = 0;
        while (true) {
            if (cnt == 0) {
                n = Integer.parseInt(st.nextToken());
            }
            while (st.hasMoreTokens()) {
                long x = Long.parseLong(st.nextToken());
                list.add(reverse(x));
                cnt++;
            }
            if (cnt == n) break;
            st = new StringTokenizer(br.readLine());
        }
        Collections.sort(list);
        for (long i : list) {
            System.out.println(i);
        }
    }

    static long reverse(long a) {
        String str = String.valueOf(a);
        StringBuilder sb = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            if (i==str.length()-1 && str.charAt(i) == '0') continue;
            sb.append(str.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }
}
