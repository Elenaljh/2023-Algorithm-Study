package blair_2023.week_05;

import java.util.regex.Pattern;

public class PR0806 {

    // ◼︎ 문자열 안에 문자열
    // 문자열 str1, str2가 매개변수로 주어집니다. str1 안에 str2가 있다면 1을 없다면 2를 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  1 ≤ str1의 길이 ≤ 100
    //  1 ≤ str2의 길이 ≤ 100
    //  문자열은 알파벳 대문자, 소문자, 숫자로 구성되어 있습니다.

    class Solution {
        public int solution(String str1, String str2) {
            int answer = 0;

            int str1L = str1.length();
            int str2L = str2.length();
            String pattern = "^[a-zA-Z0-9]*$";

            if (1 <= str1L && str1L <= 100 && 1 <= str2L && str2L <= 100) {
                if (Pattern.matches(pattern, str1) && Pattern.matches(pattern, str2)
                        && str1.contains(str2)) {
                    answer = 1;
                } else {
                    answer = 2;
                }
            }
            return answer;
        }
    }
}