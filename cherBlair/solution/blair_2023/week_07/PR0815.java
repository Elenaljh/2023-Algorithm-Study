package blair_2023.week_07;

public class PR0815 {

    // ◼︎ 자릿수 더하기
    // 정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요

    // 제한사항
    //  0 ≤ n ≤ 1,000,000

    class Solution {
        public int solution(int n) {
            int answer = 0;

            while (n > 0) {
                answer += n % 10;
                n /= 10;
            }

            return answer;
        }
    }


    // 참고 -> stream 사용
    // import java.util.Arrays;
    //
    //class Solution {
    //    public int solution(int n) {
    //        return Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).sum();
    //    }
    //}

}
