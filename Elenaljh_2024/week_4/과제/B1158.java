package 과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int turn = 0;

        LinkedList<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            turn = (turn + k - 1) % q.size();
            sb.append(q.get(turn)).append(", ");
            q.remove(turn);
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
