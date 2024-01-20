package blair_2023.week_13;

import java.util.ArrayList;
import java.util.List;

public class PR0927 {

    // 💛약수 구하기

    // 문제 설명
    // 정수 n이 매개변수로 주어질 때, n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  1 ≤ n ≤ 10,000

    class Solution {
        public int[] solution(int n) {
            int[] answer;

            List<Integer> list = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    list.add(i);
                }
            }

            answer = list.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            return answer;
        }
    }

    // 다른 풀이 참고 [ HP ]
    // import java.util.stream.IntStream;
    // import java.util.Arrays;
    //
    //class Solution {
    //    public int[] solution(int n) {
    //        return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).toArray();
    //    }
    //}
}
