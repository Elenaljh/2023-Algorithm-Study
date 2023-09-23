/**
풍선 터뜨리기
https://www.acmicpc.net/problem/2346
*/

import java.util.*;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Deque<AbstractMap.SimpleEntry<Integer, Integer>> deque = new ArrayDeque<>() {
            {
                for (int i = 0; i < n; i++) {
                    offer(new AbstractMap.SimpleEntry<>(scanner.nextInt(), i + 1));
                }
            }
        };
        List<String> list = new ArrayList<>();
        BiConsumer<Integer, Runnable> biConsumer = (integer, runnable) -> {
            for (int i = 0; i < integer; i++) {
                runnable.run();
            }
        };

        while (!deque.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> outed = deque.pollFirst();

            list.add(String.valueOf(outed.getValue()));
            if (deque.isEmpty()) break;
            if (outed.getKey() > 0) {
                biConsumer.accept(outed.getKey() - 1, () -> deque.offerLast(deque.pollFirst()));
            } else {
                biConsumer.accept(-outed.getKey(), () -> deque.offerFirst(deque.pollLast()));
            }
        }
        System.out.println(String.join(" ", list));
        scanner.close();
    }
}
