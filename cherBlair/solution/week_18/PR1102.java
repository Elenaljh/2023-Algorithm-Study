package week_18;

import java.util.ArrayList;
import java.util.List;

public class PR1102 {

    // 💛잘라서 배열로 저장하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120913
    // 문제 설명
    //문자열 my_str과 n이 매개변수로 주어질 때, my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    // 1 ≤ my_str의 길이 ≤ 100
    // 1 ≤ n ≤ my_str의 길이
    // my_str은 알파벳 소문자, 대문자, 숫자로 이루어져 있습니다.

    class Solution {
        public String[] solution(String my_str, int n) {
            List<String> answer = new ArrayList();

            for (int i = 0; i < (my_str.length() / n); i++) {
                answer.add(my_str.substring((n * i), (n * (i + 1))));
            }
            if (my_str.length() % n != 0) {
                answer.add(my_str.substring((my_str.length() / n) * n));
            }
            return answer.toArray(new String[0]);
        }
    }


    // 다른 풀이 1
    // class Solution {
    //    public String[] solution(String my_str, int n) {
    //        int resultCnt = (my_str.length() + n - 1) / n;
    //        String[] answer = new String[resultCnt];
    //
    //        for (int i = 0; i < resultCnt; i++) {
    //            int start = n * i;
    //            int end = start + n >= my_str.length()? my_str.length(): start + n;
    //            answer[i] = my_str.substring(start, end);
    //        }
    //
    //        return answer;
    //    }
    //}


    // 다른 풀이 2 - [ hp ]
    // import java.util.*;
    //import java.util.stream.IntStream;
    //
    //class Solution {
    //    public String[] solution(String myStr, int n) {
    //        return IntStream.range(0, myStr.length() / n + (myStr.length() % n > 0 ? 1 : 0))
    //                .mapToObj(i -> i == myStr.length() / n ? myStr.substring(i * n) : myStr.substring(i * n, (i + 1) * n))
    //                .toArray(String[]::new);
    //    }
    //}
}
