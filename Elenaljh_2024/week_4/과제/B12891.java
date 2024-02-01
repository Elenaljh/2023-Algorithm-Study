package 과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
DNA 비밀번호
 */
public class B12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()); //전체 문자 길이
        int p = Integer.parseInt(st.nextToken()); //부분문자열 길이
        String dna = br.readLine();
        int[] rule = new int[4];
        int[] password = new int[4];
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            rule[i] = Integer.parseInt(st.nextToken());
        }

        //초기 비밀번호
        for (int i = 0; i < p; i++) {
            password[match(dna.charAt(i))]++;
        }
        boolean good = true;
        for (int j = 0; j < 4; j++) {
            if (password[j] < rule[j]) {
                good = false;
                break;
            }
        }
        if (good) cnt++;

        //슬라이딩윈도우
        //a=0, c=1, g=2, t=3
        Loop1:
        for(int i = p; i < s; i++) {
            password[match(dna.charAt(i-p))]--;
            password[match(dna.charAt(i))]++;

            for (int j = 0; j < 4; j++) {
                if (password[j] < rule[j]) {
                    continue Loop1;
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }

    static int match(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        if (c=='T') return 3;
        return 0;
    }
}
