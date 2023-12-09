import java.util.*;
import java.io.*;

public class B1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(pow(a, c, b));
    }

    public static long pow(long a, long c, long exponent) {

        // 지수가 1일 경우 a^1 이므로 a를 그대로 리턴
        if(exponent == 1) {
            return a % c;
        }

        // 지수의 절반에 해당하는 a^(exponent / 2) 을 구한다.
        long temp = pow(a, c, exponent / 2);

        /*
         * 현재 지수가 홀 수 였다면
         * a^(exponent / 2) * a^(exponent / 2) * a 이므로
         * a를 한 번 더 곱해주어야 한다.
         *
         * ex) a^9 = a^4 * a^4 * a
         */
        if(exponent % 2 == 1) {
            return (temp * temp % c) * a % c;
        }
        return temp * temp % c;

    }
}
