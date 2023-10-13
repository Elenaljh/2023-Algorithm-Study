package week_15;

public class PR1013 {

    // 💛k의 개수
    // https://school.programmers.co.kr/learn/courses/30/lessons/120887
    // 문제 설명
    // 1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장합니다.
    // 정수 i, j, k가 매개변수로 주어질 때, i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  1 ≤ i < j ≤ 100,000
    //  0 ≤ k ≤ 9

    static class Solution {
        public int solution(int i, int j, int k) {
            int answer = 0;
            String numString = "";

            for (int num = i; num <= j; num++) {
                numString = numString.concat(String.valueOf(num));
            }
            String[] numList = numString.split("");

            for (String ks : numList) {
                if (ks.equals(String.valueOf(k))) {
                    answer++;
                }
            }
            return answer;
        }
    }
    

    // 다른 풀이 1 [ HP ]
    // import java.util.*;
    //import java.util.stream.Collectors;
    //import java.util.stream.IntStream;
    //
    //class Solution {
    //    public int solution(int i, int j, int k) {
    //        return (int) Arrays.stream(IntStream.rangeClosed(i, j)
    //                        .mapToObj(String::valueOf)
    //                        .flatMap(String::lines)
    //                        .collect(Collectors.joining())
    //                        .split(""))
    //                .filter(s -> s.equals(String.valueOf(k)))
    //                .count();
    //    }
    //}

    // class Solution {
    //    public int solution(int i, int j, int k) {
    //        String str = "";
    //        for(int a = i; a <= j; a++) {
    //            str += a+"";
    //        }
    //
    //        return str.length() - str.replace(k+"", "").length();
    //    }
    //}
}
