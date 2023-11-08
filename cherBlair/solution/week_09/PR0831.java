package week_09;

public class PR0831 {

    // 💛 짝수는 싫어요

    // 문제 설명
    //  정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  1 ≤ n ≤ 100

    class Solution {
        public int[] solution(int n) {
            int[] answer = {};

            int count = n % 2 == 0 ? n / 2 : n / 2 + 1;
            answer = new int[count];

            for (int i = 1, j = 0; i <= n; i += 2, j++) {
                answer[j] = i;
            }
            return answer;
        }
    }


    // 참고 코드 [ HP ]
    // import java.util.stream.IntStream;
    //
    //class Solution {
    //    public int[] solution(int n) {
    //        return IntStream.rangeClosed(0, n).filter(value -> value % 2 == 1).toArray();
    //    }
    //}
}
