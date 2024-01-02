package blair_2023.week_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PR0928 {

    // 💛369 게임
    // 문제 설명
    // 머쓱이는 친구들과 369게임을 하고 있습니다. 369게임은 1부터 숫자를 하나씩 대며
    // 3, 6, 9가 들어가는 숫자는 숫자 대신 3, 6, 9의 개수만큼 박수를 치는 게임입니다.
    // 머쓱이가 말해야하는 숫자 order가 매개변수로 주어질 때, 머쓱이가 쳐야할 박수 횟수를 return 하도록 solution 함수를 완성해보세요.

    // 제한사항
    // 1 ≤ order ≤ 1,000,000

    class Solution {
        public int solution(int order) {
            int answer = 0;

            List<String> game = Arrays.asList("3", "6", "9");
            List<String> strList = new ArrayList<>(Arrays.asList(Integer.toString(order).split("")));

            for (String s : strList) {
                if (game.contains(s)) {
                    answer++;
                }
            }
            return answer;
        }
    }


    // stream 참고
    // import java.util.Arrays;
    //
    //class Solution {
    //    public int solution(int order) {
    //        return (int) Arrays.stream(String.valueOf(order).split("")).map(Integer::parseInt).filter(i -> i == 3 || i == 6 || i == 9).count();
    //    }
    //}


    // ""로 문자열 변경 + char 활용
    // class Solution {
    //    public int solution(int order) {
    //        int answer = 0;
    //
    //        String str = order+"";
    //
    //        for(int i=0; i<str.length(); i++){
    //            char c = str.charAt(i);
    //            if(c=='3'||c=='6'||c=='9') answer++;
    //        }
    //
    //        return answer;
    //    }
    //}
}
