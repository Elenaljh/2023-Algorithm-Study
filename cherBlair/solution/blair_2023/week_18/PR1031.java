package blair_2023.week_18;

public class PR1031 {

    // 💛 7의 개수
    // https://school.programmers.co.kr/learn/courses/30/lessons/120912
    // 머쓱이는 행운의 숫자 7을 가장 좋아합니다.
    // 정수 배열 array가 매개변수로 주어질 때, 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.

    // 제한사항
    // 1 ≤ array의 길이 ≤ 100
    // 0 ≤ array의 원소 ≤ 100,000

    // class Solution {
    //    public int solution(int[] array) {
    //        int answer = 0;
    //        String str = "";
    //
    //        for (int i : array) {
    //            str = str.concat(String.valueOf(i));
    //        }
    //
    //        String[] strArray = str.split("");
    //
    //        for (String s : strArray) {
    //            if (s.equals("7")) {
    //                answer += 1;
    //            }
    //        }
    //        return answer;
    //    }
    //}

    // 다른 풀이 - [ HP ]
    // import java.util.*;
    //import java.util.stream.Collectors;
    //
    //class Solution {
    //    public int solution(int[] array) {
    //        return (int) Arrays.stream(
    //                        Arrays.stream(array)
    //                                .mapToObj(String::valueOf)
    //                                .collect(Collectors.joining())
    //                                .split("")
    //                )
    //                .filter(s -> s.equals("7"))
    //                .count();
    //    }
    //}

    // 다른 풀이 2
    // class Solution {
    //    public int solution(int[] array) {
    //        int answer = 0;
    //        for(int a : array){
    //            while(a != 0){
    //                if(a % 10 == 7){
    //                    answer++;
    //                }
    //                a /= 10;
    //            }
    //        }
    //        return answer;
    //    }
    //}
}
