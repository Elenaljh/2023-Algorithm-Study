package 숙제;

import java.io.*;
import java.util.*;
public class B1759 {
    static int L, C;
    static char[] container, candidate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); //암호 길이
        C = Integer.parseInt(st.nextToken()); //주어진 문자 길이
        container = new char[C];
        candidate = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) container[i] = st.nextToken().charAt(0);
        Arrays.sort(container);
        perm(0, 0);
    }

    static void perm(int count, int start) {
        if (count == L) {
            //검증
            if (!validate()) return;
            //출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < L; i++) sb.append(candidate[i]);
            System.out.println(sb);
            return;
        }

        for (int i = start; i < C; i++) {
            candidate[count] = container[i];
            perm(count+1, i+1);
        }
    }

    static boolean validate() {
        int numberOfVowel = 0;
        for (int i = 0; i < L; i++) {
            if (candidate[i] == 'a' || candidate[i] == 'e' || candidate[i] == 'i' || candidate[i] == 'o' || candidate[i] == 'u') {
                numberOfVowel++;
            }
        }
        if (numberOfVowel < 1) return false;
        if (L-numberOfVowel < 2) return false;
        return true;
    }

}
