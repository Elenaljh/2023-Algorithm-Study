package 숙제;

import java.io.*;
import java.util.*;
public class B15961_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //초밥 접시 수
        int d = Integer.parseInt(st.nextToken()); //초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 초밥 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰번호
        int[] dishes = new int[N];
        int[] ate = new int[d+1];
        for (int i = 0; i < N; i++) dishes[i] = Integer.parseInt(br.readLine());

        int index;
        int count = 0;
        for (int i = 0; i < k; i++) {
            index = i%N;
            if (ate[dishes[index]] == 0) {
                ate[dishes[index]]++;
                count++;
            } else {
                ate[dishes[index]]++;
            }
        }
        if (ate[c] == 0) count++;
        int max = count;
        if (ate[c] == 0) count--;

        for (int i = 1; i < N; i++) {
            if (ate[dishes[i-1]] - 1 == 0) {
                ate[dishes[i-1]]--;
                count--;
            } else {
                ate[dishes[i-1]]--;
            }
            index = (i+k-1)%N;
            if (ate[dishes[index]] == 0) {
                ate[dishes[index]]++;
                count++;
            } else {
                ate[dishes[index]]++;
            }
            if (ate[c] == 0) {
                count++;
            }
            max = Integer.max(count, max);
            if (ate[c] == 0) count--;
        }

        System.out.println(max);
    }
}
