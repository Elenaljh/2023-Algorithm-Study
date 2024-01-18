import java.io.*;
import java.util.*;
public class B17478 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.addFirst(i);
        }

        int count = 1;
        while (dq.size() > 1) {
            for (int i = 0; i < count*count-1; i++) {
                dq.addFirst(dq.pollLast());
            }
            dq.pollLast();
            count++;
        }
        if (dq.size() == 1) {
            System.out.println(dq.poll());
        } else {
            System.out.println("망했쥬ㅋㅋ");
        }

        /**
         * 3 -> 2
         * 6 -> 6
         * 10 -> 8
         */

    }
}
