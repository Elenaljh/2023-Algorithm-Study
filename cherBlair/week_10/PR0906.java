package week_10;

public class PR0906 {
    // 💛암호 해독
    // 문제 설명
    //  군 전략가 머쓱이는 전쟁 중 적군이 다음과 같은 암호 체계를 사용한다는 것을 알아냈습니다.
    //  암호화된 문자열 cipher를 주고받습니다.
    //  그 문자열에서 code의 배수 번째 글자만 진짜 암호입니다.
    //  문자열 cipher와 정수 code가 매개변수로 주어질 때 해독된 암호 문자열을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  1 ≤ cipher의 길이 ≤ 1,000
    //  1 ≤ code ≤ cipher의 길이
    //  cipher는 소문자와 공백으로만 구성되어 있습니다.
    //  공백도 하나의 문자로 취급합니다.

    class Solution {
        public String solution(String cipher, int code) {
            String answer = "";
            String[] ca = cipher.split("");

            for (int i = 1; i <= ca.length; i++) {
                if (code * i >= code && code * i <= ca.length) {
                    answer = answer.concat(ca[code*i -1]);
                }
            }
            return answer;
        }
    }

    // 참고 코드
    // class Solution {
    //    public String solution(String cipher, int code) {
    //        String answer = "";
    //
    //        for (int i = code; i <= cipher.length(); i = i + code) {
    //            answer += cipher.substring(i - 1, i);
    //        }
    //
    //        return answer;
    //    }
    //}

    // 참고코드2 [ HP ]
    //import java.util.stream.Collectors;
    //import java.util.stream.IntStream;
    //
    //class Solution {
    //    public String solution(String cipher, int code) {
    //        return IntStream.range(0, cipher.length())
    //                .filter(value -> value % code == code - 1)
    //                .mapToObj(c -> String.valueOf(cipher.charAt(c)))
    //                .collect(Collectors.joining());
    //    }
    //}
}
