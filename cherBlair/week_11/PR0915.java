package week_11;

import java.util.Arrays;

public class PR0915 {

    // 💛문자열 정렬하기 (1)

    // 문제 설명
    //  문자열 my_string이 매개변수로 주어질 때,
    //  my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.

    // 제한사항
    //  1 ≤ my_string의 길이 ≤ 100
    //  my_string에는 숫자가 한 개 이상 포함되어 있습니다.
    //  my_string은 영어 소문자 또는 0부터 9까지의 숫자로 이루어져 있습니다.

    class Solution {
        public int[] solution(String my_string) {
            int[] answer = {};

            my_string = my_string.replaceAll("[^0-9]","");

            char[] chars = my_string.toCharArray();
            Arrays.sort(chars);
            my_string = new String(chars);

            String[] strArray = my_string.split("");

            answer = new int[strArray.length];
            int i = 0;

            for (String t : strArray) {
                answer[i] = Integer.parseInt(t);
                i++;
            }
            return answer;
        }
    }


    // 참고 코드
    // import java.util.*;
    //
    //class Solution {
    //    public int[] solution(String myString) {
    //        return Arrays.stream(myString.replaceAll("[A-Z|a-z]", "").split("")).sorted().mapToInt(Integer::parseInt).toArray();
    //    }
    //}
}
