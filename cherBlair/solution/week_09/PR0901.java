package week_09;

public class PR0901 {
    // 💛 제곱수 판별하기

    // 문제 설명
    //  어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다.
    //  정수 n이 매개변수로 주어질 때, n이 제곱수라면 1을 아니라면 2를 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  1 ≤ n ≤ 1,000,000

    class Solution {
        public int solution(int n) {
            int answer = 0;

            for (int i = 1; i <= n; i += 2) {
                n = n - i;
            }
            return answer = n == 0 ? 1 : 2;
        }
    }

    // 참고 코드
    // class Solution {
    //    public int solution(int n) {
    //        int answer = 0;
    //        return Math.sqrt(n) % 1 == 0 ? 1 : 2;
    //    }
    //}
}
