package blair_2023.week_19;


public class PR1108 {

    // 💛삼각형의 완성 조건
    // https://school.programmers.co.kr/learn/courses/30/lessons/120868
    // 문제 설명
    // 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
    // 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
    // 삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다.
    // 나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    // sides의 원소는 자연수입니다.
    // sides의 길이는 2입니다.
    // 1 ≤ sides의 원소 ≤ 1,000

    class Solution {
        public int solution(int[] sides) {
            int answer = 0;

            int bigValue = Math.max(sides[0], sides[1]);
            int smallValue = Math.min(sides[0], sides[1]);

            int lowLimit = bigValue - smallValue;
            int highLimit = bigValue + smallValue;
            answer = highLimit - lowLimit - 1;

            return answer;
        }
    }

    // 다른 풀이
    // class Solution {
    //    public int solution(int[] sides) {
    //        int answer = 0;
    //        int max = Math.max(sides[0], sides[1]);
    //        int min = Math.min(sides[0], sides[1]);
    //
    //        answer += min * 2 - 1;
    //
    //        return answer;
    //    }
    //}

    public static void main(String[] args) {
        /* 1. 주어진 두 변이 최대 길이의 변이 아닌 경우
         *   - 가장 긴 변(주어지지 않은 변)의 길이는
         *   - 다른 두 변(주어진 두 변)의 길이의 합보다 작아야 한다.
         *
         *   unknown < sum(sides)
         *
         * 2. 주어진 두 변 중에 최대 길이의 변이 있는 경우
         *   - 가장 긴 변(주어진 두 변 중 더 긴 변)의 길이는
         *   - 다른 두 변(주어진 두 변 중 더 짧은 변, 주어지지 않은 변)의 길이의 합보다 작아야 한다.
         *
         *   max(sides) < min(sides) + unknown
         *   =  max(sides) - min(sides) < unknown
         *
         *   👉🏻 max(sides) - min(sides) < unknown < sum(sides)
         * */

        int[] sides = {11, 7};

        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        int sum = sides[0] + sides[1];
        int answer = sum - (max - min) - 1;

        System.out.println(answer);
    }
}
