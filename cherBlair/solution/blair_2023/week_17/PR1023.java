package blair_2023.week_17;

import java.util.Arrays;

public class PR1023 {

    // 💛 진료 순서 정하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120835
    // 문제 설명
    // 외과의사 머쓱이는 응급실에 온 환자의 응급도를 기준으로 진료 순서를 정하려고 합니다.
    // 정수 배열 emergency가 매개변수로 주어질 때 응급도가 높은 순서대로 진료 순서를 정한 배열을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  중복된 원소는 없습니다.
    //  1 ≤ emergency의 길이 ≤ 10
    //  1 ≤ emergency의 원소 ≤ 100

    class Solution {
        public int[] solution(int[] emergency) {
            int[] asc = emergency.clone();
            int[] answer = new int[emergency.length];

            Arrays.sort(asc);

            for (int i = 0; i <= emergency.length - 1; i++) {
                for (int j = 0; j <= emergency.length - 1; j++) {
                    if (asc[i] == emergency[j]) {
                        answer[j] = emergency.length - i;
                    }
                }
            }
            return answer;
        }
    }


    // 참고 코드 [ hp ]
    // import java.util.Arrays;
    //import java.util.Comparator;
    //import java.util.stream.Collectors;
    //
    //class Solution {
    //    public int[] solution(int[] e) {
    //        return Arrays.stream(e).map(i -> Arrays.stream(e).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).indexOf(i) + 1).toArray();
    //    }
    //}


    // 다른 풀이 2
    // class Solution {
    //    public int[] solution(int[] emergency) {
    //        int[] answer = new int[emergency.length];
    //
    //        for(int i = 0; i < answer.length; i++){
    //            if(answer[i] != 0){
    //                continue;
    //            }
    //            int idx = 1;
    //            for(int j = 0; j < answer.length; j++){
    //                if(emergency[i] < emergency[j]){
    //                    idx++;
    //                }
    //            }
    //            answer[i] = idx;
    //        }
    //        return answer;
    //    }
    //}

}
