package 과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class B23300 {
    static Stack<Integer> back = new Stack<>();
    static Stack<Integer> front = new Stack<>();
    static Stack<Integer> compressTmp = new Stack<>();
    static int now = 0;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //웹페이지 종류 수
        int q = Integer.parseInt(st.nextToken()); //수행 작업 개수

        for (int i = 0; i < q; i++) {
            work(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(now);
        if (back.isEmpty()) {
            System.out.println(-1);
        } else {
            while(!back.isEmpty()) sb.append(back.pop()).append(" ");
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
        }
        if (front.isEmpty()) {
            System.out.println(-1);
        } else {
            sb.delete(0, sb.length());
            while(!front.isEmpty()) sb.append(front.pop()).append(" ");
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
        }
    }

    static void work(String str) {
        st = new StringTokenizer(str);
        String command = st.nextToken();
        int pageNum = 0;
        if (command.equals("A")) {
            pageNum = Integer.parseInt(st.nextToken());
        }

        switch (command) {
            case "A":
                if (!front.isEmpty()) front.clear();
                if (now != 0) back.push(now);
                now = pageNum;
                break;
            case "B":
                if (back.isEmpty()) return;
                front.push(now);
                now = back.pop();
                break;
            case "F":
                if (front.isEmpty()) return;
                back.push(now);
                now = front.pop();
                break;
            case "C":
                while (!back.isEmpty()) {
                    if (!compressTmp.isEmpty() && Objects.equals(compressTmp.peek(), back.peek())) {
                        back.pop();
                    } else {
                        compressTmp.push(back.pop());
                    }
                }
                while (!compressTmp.isEmpty()) back.push(compressTmp.pop());
        }
    }
}
