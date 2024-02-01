package 과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
도영이가 만든 맛있는 음식
 */
public class B2961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long[][] ingredient = new long[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }

        long min = Long.MAX_VALUE;
        for (int i = 1; i < (1<<n); i++) {
            long sour = 1;
            long salty = 0;
            for (int j = 0; j < n; j++) {
                if ((i & 1<<j) != 0) {
                    sour *= ingredient[j][0];
                    salty += ingredient[j][1];
                }
            }
            long diff = Math.abs(sour - salty);
            min = Math.min(min, diff);
        }

        System.out.println(min);
    }
}
