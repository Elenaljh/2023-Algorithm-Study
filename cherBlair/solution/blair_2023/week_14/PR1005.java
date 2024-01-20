package blair_2023.week_14;

public class PR1005 {

    // 중복된 문자 제거
    // 문제 설명
    //  문자열 my_string이 매개변수로 주어집니다.
    //  my_string에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  1 ≤ my_string ≤ 110
    //  my_string은 대문자, 소문자, 공백으로 구성되어 있습니다.
    //  대문자와 소문자를 구분합니다.
    //  공백(" ")도 하나의 문자로 구분합니다.
    //  중복된 문자 중 가장 앞에 있는 문자를 남깁니다.

    class Solution {
        public String solution(String my_string) {
            String answer = "";
            for (int i = 0; i < my_string.length(); i++) {
                if (!answer.contains(String.valueOf(my_string.charAt(i)))) {
                    answer += my_string.charAt(i);
                }
            }
            return answer;
        }
    }

    // 다른 풀이 1 - stream.Collectors [ HP ]
    // import java.util.stream.Collectors;
    //
    //class Solution {
    //    public String solution(String my_string) {
    //        return my_string.chars()
    //                .mapToObj(Character::toString)
    //                .distinct()
    //                .collect(Collectors.joining());
    //    }
    //}


    // 다른 풀이 2 - [ HP ]
    // import java.util.*;
    //import java.util.stream.Collectors;
    //
    //class Solution {
    //    public String solution(String myString) {
    //        return Arrays.stream(myString.split("")).distinct().collect(Collectors.joining());
    //    }
    //}


    // 다른 풀이 3 - LinkedHashSet
    // import java.util.*;
    //class Solution {
    //    public String solution(String my_string) {
    //        String[] answer = my_string.split("");
    //        Set<String> set = new LinkedHashSet<String>(Arrays.asList(answer));
    //
    //        return String.join("", set);
    //    }
    //}
}
