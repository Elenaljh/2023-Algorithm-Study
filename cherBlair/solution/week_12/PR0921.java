package week_12;

public class PR0921 {

    // 💛외계 행성의 나이
    // 문제 설명
    // 우주여행을 하던 머쓱이는 엔진 고장으로 PROGRAMMERS-962 행성에 불시착하게 됐습니다.
    // 입국심사에서 나이를 말해야 하는데, PROGRAMMERS-962 행성에서는 나이를 알파벳으로 말하고 있습니다.
    // a는 0, b는 1, c는 2, ..., j는 9입니다.
    // 예를 들어 23살은 cd, 51살은 fb로 표현합니다.
    // 나이 age가 매개변수로 주어질 때 PROGRAMMER-962식 나이를 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  age는 자연수입니다.
    //  age ≤ 1,000
    //  PROGRAMMERS-962 행성은 알파벳 소문자만 사용합니다.

    class Solution {
        public String solution(int age) {
            String answer = "";

            StringBuilder sb = new StringBuilder();
            String ageString = Integer.toString(age);

            for (int i = 0; i < ageString.length(); i++) {
                sb.append(Character.toString(ageString.charAt(i) + 49));
            }

            answer = sb.toString();
            return answer;
        }
    }

    // 다른 풀이 참고 - stream [ HP ]
    // import java.util.stream.Collectors;
    //
    //class Solution {
    //    public String solution(int age) {
    //        return String.valueOf(age).chars().mapToObj(operand -> String.valueOf((char) (49 + operand))).collect(Collectors.joining());
    //    }
    //}

    // 다른 풀이 참고 2
    // class Solution {
    //    public String solution(int age) {
    //        String answer = "";
    //        String[] alpha = new String[]{"a","b","c","d","e","f","g","h","i","j"};
    //
    //        while(age>0){
    //            answer = alpha[age % 10] + answer;
    //            age /= 10;
    //        }
    //
    //        return answer;
    //    }
    //}
}
