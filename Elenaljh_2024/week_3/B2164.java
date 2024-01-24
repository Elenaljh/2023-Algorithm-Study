import java.io.*;
import java.util.*;
/*
https://www.acmicpc.net/problem/2164
 */
public class B2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();

        for (int i = n; i >= 1; i--) {
            dq.addFirst(i);
        }

        while (dq.size() > 1) {
            dq.pollFirst();
            dq.addLast(dq.pollFirst());
        }

        System.out.println(dq.poll());
    }
}
