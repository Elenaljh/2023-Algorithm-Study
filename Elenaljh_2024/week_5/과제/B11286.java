package 과제;
/*
절댓값 힙 - 우선순위 큐
https://www.acmicpc.net/problem/11286
 */
import java.io.*;
import java.util.*;
public class B11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> list = new PriorityQueue<>((o1, o2) -> {
            int a1 = Math.abs(o1); int a2 = Math.abs(o2);
            if (a1- a2 == 0) {
                return o1 - o2;
            } else {
                return a1 - a2;
            }
        });
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                list.add(num);
                continue;
            }
            if (list.isEmpty()) {
                sb.append(0).append("\n");
                continue;
            }
            sb.append(list.poll()).append("\n");
        }
        System.out.println(sb);
    }
}
