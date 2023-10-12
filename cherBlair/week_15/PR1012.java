package week_15;

import java.util.Arrays;

public class PR1012 {

    // A로 B만들기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120886
    // 문제 설명
    // 문자열 before와 after가 매개변수로 주어질 때,
    // before의 순서를 바꾸어 after를 만들 수 있으면 1을,
    // 만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.

    // 제한사항
    //0 < before의 길이 == after의 길이 < 1,000
    //before와 after는 모두 소문자로 이루어져 있습니다.

    class Solution {
        public int solution(String before, String after) {
            int answer = 0;

            char[] bArray = before.toCharArray();
            Arrays.sort(bArray);
            String bSortString = new StringBuilder(new String(bArray)).toString();

            char[] aArray = after.toCharArray();
            Arrays.sort(aArray);
            String aSortString = new StringBuilder(new String(aArray)).toString();

            if (bSortString.equals(aSortString)) {
                answer = 1;
            }
            return answer;
        }
    }

    // 다른 풀이 1
    // import java.util.Arrays;
    //class Solution {
    //    public int solution(String before, String after) {
    //        char[] a = before.toCharArray();
    //        char[] b = after.toCharArray();
    //        Arrays.sort(a);
    //        Arrays.sort(b);
    //
    //        return new String(a).equals(new String(b)) ? 1 :0;
    //    }
    //}

    // 다른 풀이 2 [ HP ]
    // import java.util.*;
    //import java.util.stream.Collectors;
    //
    //class Solution {
    //    public int solution(String before, String after) {
    //        return isCheck(getList(before), getList(after)) ? 1 : 0;
    //    }
    //
    //    private boolean isCheck(List<Integer> first, List<Integer> second) {
    //        for (int i = 0; i < first.size(); i++) {
    //            if (first.get(i) != second.get(i)) {
    //                return false;
    //            }
    //        }
    //        return true;
    //    }
    //
    //    private List<Integer> getList(String str) {
    //        return Arrays.stream(str.split(""))
    //                .collect(Collectors.groupingBy(s -> s))
    //                .values()
    //                .stream()
    //                .map(List::size)
    //                .collect(Collectors.toList());
    //    }
    //}
}
