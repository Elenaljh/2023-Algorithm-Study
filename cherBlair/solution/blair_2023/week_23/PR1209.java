package blair_2023.week_23;

public class PR1209 {

    // 겹치는 선분의 길이
    // https://school.programmers.co.kr/learn/courses/30/lessons/120876

    class Solution {
        public int solution(int[][] lines) {
            int answer = 0;
            int[] count = new int[201];

            for (int[] i : lines) {
                int s = i[0] + 100;
                int e = i[1] + 100;

                for (int k = s; k < e; k++) {
                    count[k] += 1;
                }
            }

            for (int i : count) {
                if (i > 1) {
                    answer++;
                }
            }
            return answer;
        }
    }

    // 다른 풀이
    // import java.util.*;
    //class Solution {
    //    public int solution(int[][] lines) {
    //        Map<Integer, Integer> map = new HashMap<>();
    //        for (int[] line : lines) {
    //            int from = Math.min(line[0], line[1]);
    //            int to = Math.max(line[0], line[1]);
    //            for (int i = from; i < to; i++) {
    //                map.merge(i, 1, Integer::sum);
    //            }
    //        }
    //
    //        return (int) map.values().stream().filter(i -> i > 1).count();
    //    }
    //}
}
