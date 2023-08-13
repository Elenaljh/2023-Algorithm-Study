package week_07;

public class PR_level0_0814 {

    // ◼︎ 배열 두 배 만들기
    // 정수 배열 numbers가 매개변수로 주어집니다. numbers의 각 원소에 두배한 원소를 가진 배열을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  -10,000 ≤ numbers의 원소 ≤ 10,000
    //  1 ≤ numbers의 길이 ≤ 1,000

    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = {};
            int i = 0;

            for (int num : numbers) {
                numbers[i] = num * 2;
                i++;
            }
            answer = numbers;

            return answer;
        }
    }







// 다른 풀이 참고

//    import java.util.Arrays;
//
//    class Solution {
//        public int[] solution(int[] numbers) {
//            return Arrays.stream(numbers).map(i -> i * 2).toArray();
//        }
//    }


//    class Solution {
//        public int[] solution(int[] numbers) {
//            int[] answer = {};
//            answer = new int[numbers.length];
//            for(int i=0; i<answer.length; i++){
//                answer[i] = numbers[i]*2;
//            }
//            return answer;
//        }
//    }

}
