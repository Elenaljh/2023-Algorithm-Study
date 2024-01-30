package week_14;

import java.util.Arrays;

public class PR1003 {

    // 💛문자열 정렬하기 (2)
    // 문제 설명
    // 영어 대소문자로 이루어진 문자열 my_string이 매개변수로 주어질 때,
    // my_string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.

    // 제한사항
    // 0 < my_string 길이 < 100

    class Solution {
        public String solution(String my_string) {
            String answer = my_string.toLowerCase();
            char[] charArr = answer.toCharArray();
            Arrays.sort(charArr);
            return new String(charArr);
        }
    }

    // 다른 풀이 1
    // import java.util.*;
    //class Solution {
    //    public String solution(String my_string) {
    //        char[] c = my_string.toLowerCase().toCharArray();
    //        Arrays.sort(c);
    //        return new String(c);
    //    }
    //}

    // 다른 풀이 2 [ HP ]
    // import java.util.*;
    //import java.util.stream.Collectors;
    //
    //class Solution {
    //    public String solution(String myString) {
    //        return Arrays.stream(myString.toLowerCase(Locale.ROOT).split("")).sorted().collect(Collectors.joining());
    //    }
    //}
}
