package blair_2023.week_23;

public class PR1205 {

    // 다음에 올 숫자
    // https://school.programmers.co.kr/learn/courses/30/lessons/120924

    class Solution {
        public int solution(int[] common) {
            int answer = 0;

            if ((common[1] - common[0]) == (common[2] - common[1])) {
                answer = common[common.length - 1] + (common[1] - common[0]);
            } else {
                answer = common[common.length - 1] * (common[1] / common[0]);
            }
            return answer;
        }
    }
}
