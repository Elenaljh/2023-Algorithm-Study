/**
요세푸스 문제
https://www.acmicpc.net/problem/1158
*/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        Queue<Integer> queue = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toCollection(LinkedList::new));
        List<Integer> answer = new ArrayList<>();

        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }
            answer.add(queue.poll());
        }
        System.out.println("<" + answer.stream().map(String::valueOf).collect(Collectors.joining(", ")) + ">");
        scanner.close();
    }
}
