package blair_2023.week_11;

import java.util.Arrays;

public class PR0911 {

    // 💛 최댓값 만들기 (2)
    // 문제 설명
    //  정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  -10,000 ≤ numbers의 원소 ≤ 10,000
    //  2 ≤ numbers 의 길이 ≤ 100

    class Solution {
        public int solution(int[] numbers) {
            Arrays.sort(numbers);
            int res1 = numbers[0] * numbers[1];
            int res2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];

            return res1 > res2 ? res1 : res2;
        }
    }


    // 참고 코드
    // import java.util.*;
    //
    //class Solution {
    //    public int solution(int[] numbers) {
    //        int len = numbers.length;
    //        Arrays.sort(numbers);
    //        return Math.max(numbers[0] * numbers[1], numbers[len - 2] * numbers[len - 1]);
    //    }
    //}
}
