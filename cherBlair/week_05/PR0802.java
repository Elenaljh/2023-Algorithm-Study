package week_05;

public class PR0802 {

    // 편지
    // 머쓱이는 할머니께 생신 축하 편지를 쓰려고 합니다.
    // 할머니가 보시기 편하도록 글자 한 자 한 자를 가로 2cm 크기로 적으려고 하며,
    // 편지를 가로로만 적을 때, 축하 문구 message를 적기 위해 필요한 편지지의 최소 가로길이를 return 하도록 solution 함수를 완성해주세요.
//    class Solution {
//        public int solution(String message) {
//            int answer = 0;
//
//            if (1 <= message.length() && message.length() <= 50) {
//                answer = message.length() * 2;
//            }
//            return answer;
//        }
//    }


    // 배열 원소의 길이
    // 문자열 배열 strlist가 매개변수로 주어집니다. strlist 각 원소의 길이를 담은 배열을 retrun하도록 solution 함수를 완성해주세요.
//    class Solution {
//        public int[] solution(String[] strlist) {
//            int[] answer = new int[strlist.length];
//
//            for (int i = 0; i < answer.length; i++) {
//                int strLength = strlist[i].length();
//                if (1 <= strLength && strLength <= 100) {
//                    answer[i] = strLength;
//                }
//            }
//            return answer;
//        }
//    }


    // 분수의 덧셈
    // 첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
    // 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
    class Solution {
        public int[] solution(int numer1, int denom1, int numer2, int denom2) {

            int[] answer = new int[2];

            if (0 < numer1 && numer1 < 1000
                    && 0 < denom1 && denom1 < 1000
                    && 0 < numer2 && numer2 < 1000
                    && 0 < denom2 && denom2 < 1000) {

                int numer = numer1 * denom2 + numer2 * denom1;
                int denom = denom1 * denom2;

                int max = 1;

                for (int i = 1; i <= numer && i <= denom; i ++) {
                    if (numer % i == 0 && denom % i == 0) {
                        max = i;
                    }
                }
                answer[0] = numer / max;
                answer[1] = denom / max;
            }
            return answer;
        }
    }
}
