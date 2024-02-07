package 재귀;
/*
https://www.acmicpc.net/problem/1074
Z
 */
import java.util.*;
import java.io.*;
public class B1074 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        count(r, c, N);
        System.out.println(count);
    }
    static void count(int r, int c, int N) {
        //기저조건
        if (N == 0) {
            return;
        }
        int half = (int)Math.pow(2, N-1);
        if (r < half && c < half) { //1
            count(r, c, N-1);
        } else if (r < half && c >= half) { //2
            count += half * half;
            count(r, c-half, N-1);
        } else if (r >= half && c < half) { //3
            count += 2* half * half;
            count(r-half, c, N-1);
        } else { //4
            count += 3*half*half;
            count(r-half, c-half, N-1);
        }
    }

}
