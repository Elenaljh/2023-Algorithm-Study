import java.io.*;
import java.util.*;

public class B1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(sum(b)-sum(a-1));
    }

    static int sum(int x) {
        int count = 0;
        int i = x;
        int minus = 0;
        while(true) {
            count += i;
            minus++;
            i -= minus;
            if (i < 0) {
                break;
            }
        }
        return count;
    }
}
