package 과제;

/*
노답
https://www.acmicpc.net/problem/15876
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15876 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        StringBuilder print = new StringBuilder();
        int count = 0;

        while(sb.length() < 5*n) {
            String tmp = Integer.toBinaryString(count);
            sb.append(tmp);
            count++;
        }

        for (int i = 0; i < 5; i++) {
            print.append(sb.charAt(i*n+k-1)).append(" ");
        }
        print.deleteCharAt(print.length()-1);
        System.out.println(print);

    }
}
