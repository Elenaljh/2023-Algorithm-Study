package week_22;

public class PR1127 {

    // 💛유한 소수 판별하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120878

    class Solution {
        public int solution(int a, int b) {
            int num = b / gcd(a, b);

            while (num != 1) {
                if (num % 2 == 0) {
                    num /= 2;
                } else if (num % 5 == 0) {
                    num /= 5;
                } else {
                    return 2;
                }
            }
            return 1;
        }

        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            } else {
                return gcd(b, a % b);
            }
        }
    }
}
