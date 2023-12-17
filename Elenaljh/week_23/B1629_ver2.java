import java.util.*;
import java.io.*;
public class B1629_ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        long result = multiply(a, b, 0, a) % c;
        System.out.println(result);
    }

    public static long multiply(long a, long b, long count, long mul) {
        if (count == b) return mul;
        return multiply(a, b, count+1, mul*a);
    }
}
