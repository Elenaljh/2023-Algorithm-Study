package blair_2023.week_21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PR1125 {

    // 💛 등수 매기기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120882

    class Solution {
        public int[] solution(int[][] score) {
            List<Integer> scoreList = new ArrayList<>();
            for (int[] t : score) {
                scoreList.add(t[0] + t[1]);
            }
            scoreList.sort(Comparator.reverseOrder());

            int[] answer = new int[score.length];
            for (int i = 0; i < score.length; i++) {
                answer[i] = scoreList.indexOf(score[i][0] + score[i][1]) + 1;
            }
            return answer;
        }
    }

    // 다른 풀이 - [ HP ]
    // import java.util.Arrays;
    //import java.util.Comparator;
    //import java.util.stream.Collectors;
    //
    //class Solution {
    //    public int[] solution(int[][] score) {
    //        return Arrays.stream(score).map(ints -> Arrays.stream(ints).average().orElse(0)).mapToInt(d -> Arrays.stream(score).map(ints -> Arrays.stream(ints).average().orElse(0)).sorted(Comparator.reverseOrder()).collect(Collectors.toList()).indexOf(d) + 1).toArray();
    //    }
    //}
}
