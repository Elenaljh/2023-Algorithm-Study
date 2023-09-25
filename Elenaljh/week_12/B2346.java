import java.io.*;
import java.util.*;

public class B2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //덱에 [풍선순서, 풍선에 적힌 숫자] 저장
        Deque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            int[] arr = {i, Integer.parseInt(st.nextToken())};
            deque.offerFirst(arr);
        }

        //문제풀이
        int[] pick = deque.pollLast();
        int turn = pick[1];
        System.out.print(pick[0] + " ");

        while (!deque.isEmpty()) {
            if (turn > 0) {
                for (int i = 0; i < turn-1; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                pick = deque.pollLast();
                turn = pick[1];
                System.out.print(pick[0] + " ");
            } else {
                turn = -turn;
                for (int i = 0; i < turn-1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                pick = deque.pollFirst();
                turn = pick[1];
                System.out.print(pick[0] + " ");
            }
        }
    }
}
