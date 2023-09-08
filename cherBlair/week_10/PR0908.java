package week_10;

public class PR0908 {

    // 💛대문자와 소문자
    // 문제 설명
    //  문자열 my_string이 매개변수로 주어질 때, 대문자는 소문자로 소문자는 대문자로 변환한 문자열을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  1 ≤ my_string의 길이 ≤ 1,000
    //  my_string은 영어 대문자와 소문자로만 구성되어 있습니다.

    class Solution {
        public String solution(String my_string) {
            String answer = "";

            char[] arry = my_string.toCharArray();

            String temp ="";
            for(int i = 0; i <arry.length; i++) {
                if( arry[i] >= 97 && arry[i] <= 122 ) {
                    temp = arry[i] + "";
                    answer += temp.toUpperCase();
                } else if( arry[i] >=65 && arry[i] <= 90){
                    temp = arry[i] + "";
                    answer += temp.toLowerCase();
                }
            }
            return answer;
        }
    }

    // 참고 코드
    // import java.util.stream.Collectors;
    //
    //class Solution {
    //    public String solution(String myString) {
    //        return myString.chars().mapToObj(operand -> String.valueOf((char) (Character.isLowerCase(operand) ? Character.toUpperCase(operand) : Character.toLowerCase(operand)))).collect(Collectors.joining());
    //    }
    //}

    // 참고코드 2
    // class Solution {
    //    public String solution(String my_string) {
    //        String answer = "";
    //
    //        for(int i = 0; i < my_string.length(); i++) {
    //            if(my_string.charAt(i) >= 65 && my_string.charAt(i) <= 90) {
    //               answer += Character.toLowerCase(my_string.charAt(i));
    //            } else {
    //               answer += Character.toUpperCase(my_string.charAt(i));
    //            }
    //        }
    //
    //        return answer;
    //    }
    //}
}
