package blair_2023.week_02;

import java.util.Arrays;

public class PR0712 {

    // 몫 구하기
//    class Solution {
//        public int solution(int num1, int num2) {
//            int answer = 0;
//            if (0 < num1 && num1 <= 100 && 0 < num2 && num2 <= 100) {
//                answer = num1 / num2;
//            }
//            return answer;
//        }
//    }


    // 나이 출력
//    class Solution {
//        public int solution(int age) {
//            int answer = 0;
//            if (0 < age && age <= 120) {
//                answer = 2022 - age + 1;
//            }
//            return answer;
//        }
//    }


    // 두 수의 합
//    class Solution {
//        public int solution(int num1, int num2) {
//            int answer = -1;
//            if (-50000 <= num1 && num1 <= 50000 && -50000 <= num2 && num2 <= 50000) {
//                answer = num1 + num2;
//            }
//            return answer;
//        }
//    }


    // 두 수의 나눗셈
//    class Solution {
//        public int solution(int num1, int num2) {
//            double answer = 0;
//            if(0 < num1 && num1 <= 100 && 0 < num2 && num2 <= 100) {
//                answer = (double) num1 / num2 * 1000;
//            }
//            return (int) answer;
//        }
//    }


    // 각도기
//    class Solution {
//        public int solution(int angle) {
//            int answer = 0;
//            if (angle == 90) {answer = 2;}
//            else if (angle == 180) {answer = 4;}
//            else if (0 < angle && angle < 90) {answer = 1;}
//            else if (90 < angle && angle < 180) {answer = 3;}
//            return answer;
//        }
//    }


    // 짝수의 합
//    class Solution {
//        public int solution(int n) {
//            int answer = 0;
//            if (0 < n && n <= 1000) {
//                for (int even = 2; even <= n; even += 2) {
//                    answer += even;
//                }
//            }
//            return answer;
//        }
//    }


    // 배열의 평균값
//    class Solution {
//        public double solution(int[] numbers) {
//            double answer = 0;
//            int length = numbers.length;
//            double sum = 0;
//
//            if (1 <= length && length <= 100) {
//                for (int i = 0; i < length; i++) {
//                    sum += numbers[i];
//                }
//            }
//            answer = sum / length;
//            return answer;
//        }
//    }

    // 배열의 평균값 - 참고 ⭐️stream 활용 [ HP ]
    class Solution {
        public double solution(int[] numbers) {
            return Arrays.stream(numbers).average().orElse(0);
        }
    }
}
