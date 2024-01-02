package blair_2023.week_18;

public class PR1030 {

    // 💛이진수 더하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120885
    // 문제 설명
    // 이진수를 의미하는 두 개의 문자열 bin1과 bin2가 매개변수로 주어질 때, 두 이진수의 합을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  return 값은 이진수를 의미하는 문자열입니다.
    //  1 ≤ bin1, bin2의 길이 ≤ 10
    //  bin1과 bin2는 0과 1로만 이루어져 있습니다.
    //  bin1과 bin2는 "0"을 제외하고 0으로 시작하지 않습니다.

    class Solution {
        public String solution(String bin1, String bin2) {
            String answer = "";

            int num1 = Integer.parseInt(bin1, 2);
            int num2 = Integer.parseInt(bin2, 2);
            int res = num1 + num2;
            answer = Integer.toBinaryString(res);

            return answer;
        }
    }

    // 다른 풀이
    // class Solution {
    //    public String solution(String bin1, String bin2) {
    //        return Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2));
    //    }
    //}
}
