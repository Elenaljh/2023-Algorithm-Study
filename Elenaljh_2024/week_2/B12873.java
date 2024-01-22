import java.io.*;
import java.util.*;
public class B12873 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.addFirst(i);
        }

        int count = 1;
        while (dq.size() > 1) {
            int num = (count * count * count -1) % dq.size();
            for (int i = 0; i < num; i++) {
                dq.addFirst(dq.pollLast());
            }
            dq.pollLast();
            count++;
        }
        if (dq.size() == 1) {
            System.out.println(dq.poll());
        } else {
            System.out.println("실패");
        }

        /**
         * 3 -> 2
         * 6 -> 6
         * 10 -> 8
         */

    }


}
