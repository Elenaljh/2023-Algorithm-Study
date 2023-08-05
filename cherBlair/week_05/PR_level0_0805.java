package week_05;

public class PR_level0_0805 {

    // ◼︎ 배열의 유사도
    // 두 배열이 얼마나 유사한지 확인해보려고 합니다. 문자열 배열 s1과 s2가 주어질 때 같은 원소의 개수를 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  1 ≤ s1, s2의 길이 ≤ 100
    //  1 ≤ s1, s2의 원소의 길이 ≤ 10
    //  s1과 s2의 원소는 알파벳 소문자로만 이루어져 있습니다
    //  s1과 s2는 각각 중복된 원소를 갖지 않습니다.

    class Solution {
        public int solution(String[] s1, String[] s2) {
            int answer = 0;
            int s1L = s1.length;
            int s2L = s2.length;

            if (1 <= s1L && s1L <= 100 && 1 <= s2L && s2L <= 100) {
                for (String s : s1) {
                    for (String value : s2) {
                        if (s.equals(value)) {
                            answer++;
                        }
                    }
                }
            }

            return answer;
        }
    }

    // 다른 풀이 참고

    // 1. set을 사용한 경우
//    import java.util.*;
//    class Solution {
//        public int solution(String[] s1, String[] s2) {
//            Set<String> set = new HashSet<>(Arrays.asList(s1));
//            return (int)Arrays.stream(s2).filter(set::contains).count();
//        }
//    }


    // 2. map을 사용한 경우
//    import java.util.*;
//    import java.util.stream.Collectors;
//
//    class Solution {
//        public int solution(String[] s1, String[] s2) {
//            return (int) Arrays.stream(s1).map(s -> Arrays.stream(s2).collect(Collectors.toList()).contains(s)).filter(b -> b).count();
//        }
//    }
}
