package 재귀;
/*
https://www.acmicpc.net/problem/1629
곱셈
 */
import java.util.*;
import java.io.*;
public class B1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        /*
        1. A^B mod C = (A mod C)^B mod C
        2. B = 111000110011011_(2)라고 하자
        3.
        3. B의 비트를 하나씩 오른쪽으로 밀어가면서 B==0이 될때까지 더해준다.
         */
        long result = calc(a, c, b);
        System.out.println(result);
    }

    static long calc(long a, long c, long exponent) {
        if (exponent == 1) {
            return a%c;
        }
        long temp = calc(a, c, exponent/2);
        if (exponent%2==1) {
            return (temp * temp % c) * a%c;
        } else {
            return temp * temp % c;
        }
    }
}
