package week_15;

public class PR1010 {

    // 2차원으로 만들기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120842

    class Solution {
        public int[][] solution(int[] num_list, int n) {
            int[][] answer = new int[num_list.length / n][n];
            int count = 0;
            for (int i = 0; i < answer.length; i++) {
                for (int j = 0; j < answer[i].length; j++, count++) {
                    answer[i][j] = num_list[count];
                }
            }
            return answer;
        }
    }

}
