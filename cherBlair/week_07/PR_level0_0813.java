package week_07;

public class PR_level0_0813 {

    // ◼︎ 순서 쌍의 개수
    // 순서쌍이란 두 개의 숫자를 순서를 정하여 짝지어 나타낸 쌍으로 (a, b)로 표기합니다.
    // 자연수 n이 매개변수로 주어질 때 두 숫자의 곱이 n인 자연수 순서쌍의 개수를 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  1 ≤ n ≤ 1,000,000

    class Solution {
        public int solution(int n) {
            int answer = 0;

            for(int i =1 ; i <= n ; i ++) {
                if (n % i == 0){
                    answer++;
                }
            }
            return answer;
        }
    }

    // 참고 답안
    // intStream 사용

//    import java.util.stream.IntStream;
//
//    class Solution {
//        public int solution(int n) {
//            return (int) IntStream.rangeClosed(1, n).filter(i -> n % i == 0).count();
//        }
//    }
}
