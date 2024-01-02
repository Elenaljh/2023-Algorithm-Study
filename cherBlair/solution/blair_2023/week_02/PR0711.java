package blair_2023.week_02;

public class PR0711 {

    // 두 수의 곱
//    class Solution {
//        public int solution(int num1, int num2) {
//            int answer = 0;
//            if (0 <= num1 && 100 >= num1 && 0 <= num2 && 100 >= num2) {
//                answer = num1 * num2;
//            }
//            return answer;
//        }
//    }


    // 나머지 구하기
//    class Solution {
//        public int solution(int num1, int num2) {
//            int answer = -1;
//            if (0 < num1 && 100 >= num1 && 0 < num2 && 100 >= num2) {
//                answer = num1 % num2;
//            }
//            return answer;
//        }
//    }


    // 두 수의 차
//    class Solution {
//        public int solution(int num1, int num2) {
//            int answer = 0;
//            if (-500000 <= num1 && 500000 >= num1 && -50000 <= num2 && 50000 >= num2) {
//                answer = num1 - num2;
//            }
//            return answer;
//        }
//    }


    // 숫자 비교하기
    class Solution {
        public int solution(int num1, int num2) {
            int answer = 0;
            if (0 <= num1 && 10000 >= num1 && 0 <= num2 && 10000 >= num2) {
                if (num1 == num2) {
                    answer = 1;
                } else {
                    answer = -1;
                }
            }
            return answer;
        }
    }
}
