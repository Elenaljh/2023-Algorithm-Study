package week_16;

public class PR1018 {

    // 가까운 수
    // https://school.programmers.co.kr/learn/courses/30/lessons/120890
    // 문제 설명
    //  정수 배열 array와 정수 n이 매개변수로 주어질 때, array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.

    // 제한사항
    //1 ≤ array의 길이 ≤ 100
    //1 ≤ array의 원소 ≤ 100
    //1 ≤ n ≤ 100
    //가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.

    class Solution {
        public int solution(int[] array, int n) {
            int answer = 0;
            int diff = 0;
            int min = Integer.MAX_VALUE;

            for (int j : array) {
                diff = Math.abs(n - j);
                if (diff < min) {
                    min = diff;
                    answer = j;
                } else if (diff == min && j < answer) {
                    answer = j;
                }
            }
            return answer;
        }
    }

    // 다른 풀이 [ HP ]
    // import java.util.Arrays;
    //import java.util.stream.Collectors;
    //
    //class Solution {
    //    public int solution(int[] array, int n) {
    //        return Math.min(array[Arrays.stream(array).map(operand -> Math.abs(n - operand)).boxed().collect(Collectors.toList()).indexOf(Arrays.stream(array).map(operand -> Math.abs(n - operand)).min().orElse(0))], array[Arrays.stream(array).map(operand -> Math.abs(n - operand)).boxed().collect(Collectors.toList()).lastIndexOf(Arrays.stream(array).map(operand -> Math.abs(n - operand)).min().orElse(0))]);
    //    }
    //}


    // 다른 풀이 2
    // import java.util.*;
    //
    //class Solution {
    //    public int solution(int[] array, int n) {
    //        int answer = 0;
    //        Arrays.sort(array);
    //        for(int i = 1 ; i < array.length ; i++){
    //            if(Math.abs(n-array[0]) > Math.abs(n-array[i])){
    //                array[0] = array[i];
    //            }
    //        }
    //        answer = array[0];
    //        return answer;
    //    }
    //}
}
