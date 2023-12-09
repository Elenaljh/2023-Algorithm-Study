package week_23;

public class PR1206 {

    // 연속된 수의 합
    // https://school.programmers.co.kr/learn/courses/30/lessons/120923

    class Solution {
        public int[] solution(int num, int total) {
            int[] answer = new int[num];
            int start = (total / num) - ((num - 1) / 2);

            for (int i = 0; i < num; i++) {
                answer[i] = start;
                start++;
            }
            return answer;
        }
    }

    // 다른 풀이
    // class Solution {
    //        public int[] solution(int num, int total) {
    //                int[] answer = new int[num];
    //                int check = num*(num+1) / 2;
    //                int start = (total - check) / num + 1;
    //                for (int i = 0; i < answer.length; i++) {
    //                        answer[i] = start + i ;
    //                }
    //                return answer;
    //        }
    //}
}
