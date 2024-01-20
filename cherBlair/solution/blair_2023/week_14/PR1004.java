package blair_2023.week_14;

import java.util.ArrayList;

public class PR1004 {

    // 합성 수 찾기
    // 문제 설명
    //  약수의 개수가 세 개 이상인 수를 합성수라고 합니다.
    //  자연수 n이 매개변수로 주어질 때 n이하의 합성수의 개수를 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  1 ≤ n ≤ 100

    class Solution {
        public int solution(int n) {
            int answer = 0;

            for (int i = 1; i <= n; i++) {
                if (getDivisor(i) >= 3) {
                    answer++;
                }
            }
            return answer;
        }

        public int getDivisor(int n) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    list.add(i);
                }
            }
            list.add(n);

            return list.size();
        }
    }


    // 다른 풀이 [ HP ]
    // import java.util.stream.IntStream;
    //
    //class Solution {
    //    public int solution(int n) {
    //        return (int) IntStream.rangeClosed(1, n).filter(i -> (int) IntStream.rangeClosed(1, i).filter(i2 -> i % i2 == 0).count() > 2).count();
    //    }
    //}
}
