package blair_2023.week_06;

public class PR0811 {

    // ◼︎ 피자 나눠 먹기 (3)
    // 머쓱이네 피자가게는 피자를 두 조각에서 열 조각까지 원하는 조각 수로 잘라줍니다.
    // 피자 조각 수 slice와 피자를 먹는 사람의 수 n이 매개변수로 주어질 때,
    // n명의 사람이 최소 한 조각 이상 피자를 먹으려면 최소 몇 판의 피자를 시켜야 하는지를 return 하도록 solution 함수를 완성해보세요.

    // 제한사항
    //  2 ≤ slice ≤ 10
    //  1 ≤ n ≤ 100

    class Solution {
        public int solution(int slice, int n) {
            int answer = 0;
            int cnt = n / slice;

            if (2 <= slice && slice <= 10
                    && 1 <= n && n <= 100) {
                answer = n % slice == 0 ? cnt : cnt + 1;
            }
            return answer;
        }
    }
}
