package week_13;

import java.util.ArrayDeque;
import java.util.Deque;

public class PR0925 {

    // 💛배열 회전시키기
    // 문제 설명
    // 정수가 담긴 배열 numbers와 문자열 direction가 매개변수로 주어집니다.
    // 배열 numbers의 원소를 direction방향으로 한 칸씩 회전시킨 배열을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    // 3 ≤ numbers의 길이 ≤ 20
    // direction은 "left" 와 "right" 둘 중 하나입니다.

    class Solution {
        public int[] solution(int[] numbers, String direction) {
            int[] answer = new int[numbers.length];
            Deque<Integer> deque = new ArrayDeque<>();

            for (int num : numbers) {
                deque.offer(num);
            }

            if (direction.equals("right")) {
                int num = deque.pollLast();
                deque.offerFirst(num);
            } else if (direction.equals("left")) {
                int num = deque.pollFirst();
                deque.offerLast(num);
            }

            for (int i = 0; i < answer.length; i++) {
                answer[i] = deque.poll();
            }

            return answer;
        }
    }


    // 다른 풀이 참고 (stream)
    // import java.util.Arrays;
    //import java.util.List;
    //import java.util.stream.Collectors;
    //
    //class Solution {
    //    public int[] solution(int[] numbers, String direction) {
    //        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
    //
    //        if (direction.equals("right")) {
    //            list.add(0, list.get(list.size() - 1));
    //            list.remove(list.size() - 1);
    //        } else {
    //            list.add(list.size(), list.get(0));
    //            list.remove(0);
    //        }
    //        return list.stream().mapToInt(Integer::intValue).toArray();
    //    }
    //}
}
