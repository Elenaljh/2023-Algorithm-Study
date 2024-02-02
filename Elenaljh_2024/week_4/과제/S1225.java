package 과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S1225 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> dq;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < 10; t++) {
            sb.append("#").append(Integer.parseInt(br.readLine())).append(" ");
            st = new StringTokenizer(br.readLine());
            dq = new ArrayDeque<>();
            for (int i = 0; i < 8; i++) {
                dq.addLast(Integer.parseInt(st.nextToken()));
            }

            int target = 0;
            int minus = 1;
            //작업
            while ((target = dq.pollFirst()-minus) > 0) {
                if (minus == 5) minus = 0;
                dq.addLast(target);
                minus++;
            }
            target = 0;
            dq.addLast(target);

            for (int i = 0; i < 8; i++) {
                sb.append(dq.pollFirst()).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
