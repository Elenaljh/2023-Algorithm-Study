package week_06;

public class PR0808 {

    // 짝수 홀수 개수
    // 정수가 담긴 리스트 num_list가 주어질 때, num_list의 원소 중 짝수와 홀수의 개수를 담은 배열을 return 하도록 solution 함수를 완성해보세요.

    // 제한사항
    //  1 ≤ num_list의 길이 ≤ 100
    //  0 ≤ num_list의 원소 ≤ 1,000

    class Solution {
        public int[] solution(int[] num_list) {
            int[] answer = {};
            int even = 0;
            int odd = 0;

            for (int num : num_list) {
                if (num % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            answer = new int[] { even, odd };

            return answer;
        }
    }


    // 참고
    // stream 사용 코드 - [ HP ]

//    import java.util.stream.IntStream;
//    import java.util.Arrays;
//
//    class Solution {
//        public int[] solution(int[] numList) {
//            return IntStream.of((int) Arrays.stream(numList).filter(i -> i % 2 == 0).count(), (int) Arrays.stream(numList).filter(i -> i % 2 == 1).count()).toArray();
//        }
//    }
}
