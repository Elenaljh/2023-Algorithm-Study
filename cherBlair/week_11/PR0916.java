package week_11;

public class PR0916 {
    // 💛가장 큰 수 찾기

    // 문제 설명
    //  정수 배열 array가 매개변수로 주어질 때, 가장 큰 수와 그 수의 인덱스를 담은 배열을 return 하도록 solution 함수를 완성해보세요.

    // 제한사항
    //  1 ≤ array의 길이 ≤ 100
    //  0 ≤ array 원소 ≤ 1,000
    //  array에 중복된 숫자는 없습니다.

    class Solution {
        public int[] solution(int[] array) {
            //int[] answer = {};
            int b = 0;
            int t = 0;

            for (int i = 1; i < array.length; i ++) {
                b = array[i - 1] < array[i] ? array[i] : array[i -1];
            }

            for (int c : array) {
                if (c == b) {
                    break;
                } else {
                    t ++;
                }
            }

            int[] answer = {b, t};

            return answer;
        }
    }

    // 코드 참고 [ HP ]
    // import java.util.*;
    //import java.util.stream.Collectors;
    //
    //class Solution {
    //    public int[] solution(int[] array) {
    //        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
    //        int max = list.stream().max(Integer::compareTo).orElse(0);
    //        int index = list.indexOf(max);
    //        return new int[] {max, index};
    //    }
    //}


    // 참고2
    // class Solution {
    //    public int[] solution(int[] array) {
    //        int[] answer = new int[2];
    //
    //        for(int i=0;i<array.length;i++) {
    //            if(array[i] > answer[0]) {
    //                answer[0] = array[i];
    //                answer[1] = i;
    //            }
    //        }
    //
    //        return answer;
    //    }
    //}
}
