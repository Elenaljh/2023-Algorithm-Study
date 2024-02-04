package week_04;

public class PR0728 {
    // ◼︎ 양꼬치
    // 머쓱이네 양꼬치 가게는 10인분을 먹으면 음료수 하나를 서비스로 줍니다.
    // 양꼬치는 1인분에 12,000원, 음료수는 2,000원입니다.
    // 정수 n과 k가 매개변수로 주어졌을 때, 양꼬치 n인분과 음료수 k개를 먹었다면 총얼마를 지불해야 하는지 return 하도록 solution 함수를 완성해보세요.
    // 제한사항
    // 0 < n < 1,000
    // n / 10 ≤ k < 1,000
    // 서비스로 받은 음료수는 모두 마십니다.

//    class Solution {
//        public int solution(int n, int k) {
//            int answer = 0;
//            if (n > 0 && n < 1000 && k >= n / 10 && n < 1000) {
//                answer = n * 12000 + k * 2000 - (n / 10 * 2000);
//            }
//            return answer;
//        }
//    }


    // ◼︎ 피자 나눠 먹기 (1)
    // 머쓱이네 피자가게는 피자를 일곱 조각으로 잘라 줍니다.
    // 피자를 나눠먹을 사람의 수 n이 주어질 때, 모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를 return 하는 solution 함수를 완성해보세요

    public int solution(int n) {
        int answer = 0;
        if (1 <= n && n <= 100) {
            if (n % 7 == 0) {
                answer = n / 7;
            } else {
                answer = n / 7 + 1;
            }
        }
        return answer;
    }
}
