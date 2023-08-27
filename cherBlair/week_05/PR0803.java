package week_05;
import java.util.Arrays;
public class PR0803 {

    // ◼︎ 배열 자르기
    // 정수 배열 numbers와 정수 num1, num2가 매개변수로 주어질 때,
    // numbers의 num1번 째 인덱스부터 num2번째 인덱스까지 자른 정수 배열을 return 하도록 solution 함수를 완성해보세요.

    // 제한사항
    //  2 ≤ numbers의 길이 ≤ 30
    //  0 ≤ numbers의 원소 ≤ 1,000
    //  0 ≤num1 < num2 < numbers의 길이

    class Solution {
        public int[] solution(int[] numbers, int num1, int num2) {
            int[] answer = {};
            int numLength = numbers.length;

            if (2 <= numLength && numLength <= 30) {
                for (int number : numbers) {
                    if (0 <= number && number <= 1000) {
                        if (0 <= num1
                                && num1 < num2
                                && num2 < numLength) {
                            answer = Arrays.copyOfRange(numbers, num1, num2 + 1);
                        }
                    }
                }
            }
            return answer;
        }
    }
}
