package 과제;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class B2164 {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            dq.addLast(i);
        }

        while (dq.size() > 1) {
            dq.pollFirst();
            dq.addLast(dq.pollFirst());
        }

        System.out.println(dq.poll());
    }
}
