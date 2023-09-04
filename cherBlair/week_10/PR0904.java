package week_10;

public class PR0904 {
    // 💛가위 바위 보

    // 가위는 2 바위는 0 보는 5로 표현합니다.
    // 가위 바위 보를 내는 순서대로 나타낸 문자열 rsp가 매개변수로 주어질 때,
    // rsp에 저장된 가위 바위 보를 모두 이기는 경우를 순서대로 나타낸 문자열을 return하도록 solution 함수를 완성해보세요.

    // 제한사항
    //  0 < rsp의 길이 ≤ 100
    //  rsp와 길이가 같은 문자열을 return 합니다.
    //  rsp는 숫자 0, 2, 5로 이루어져 있습니다.

    class Solution {
        public String solution(String rsp) {
            String answer = "";

            String[] rspArray = rsp.split("");

            for (String t : rspArray) {
                if (t.equals("2")) {
                    answer = answer.concat("0");
                } else if (t.equals("0")) {
                    answer = answer.concat("5");
                } else if (t.equals("5")) {
                    answer = answer.concat("2");
                }
            }
            return answer;
        }
    }


    // 참고 코드
    // import java.util.Arrays;
    //import java.util.stream.Collectors;
    //
    //class Solution {
    //    public String solution(String rsp) {
    //        return Arrays.stream(rsp.split("")).map(s -> s.equals("2") ? "0" : s.equals("0") ? "5" : "2").collect(Collectors.joining());
    //    }
    //}
}
