package week_06;

import java.util.Arrays;

public class PR0809 {

    // ◼︎ 최댓값 만들기
    // 정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  0 ≤ numbers의 원소 ≤ 10,000
    //  2 ≤ numbers의 길이 ≤ 100

    class Solution {
        public int solution(int[] numbers) {
            int answer = 0;

            Arrays.sort(numbers);
            answer = numbers[numbers.length - 1] * numbers[numbers.length - 2];

            return answer;
        }
    }
}
