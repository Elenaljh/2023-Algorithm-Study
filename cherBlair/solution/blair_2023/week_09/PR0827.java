package blair_2023.week_09;

public class PR0827 {

    // 💛문자 반복 출력하기

    // 문제 설명
    // 문자열 my_string과 정수 n이 매개변수로 주어질 때,
    // my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 return 하도록 solution 함수를 완성해보세요.

    // 제한사항
    //  2 ≤ my_string 길이 ≤ 5
    //  2 ≤ n ≤ 10
    //  "my_string"은 영어 대소문자로 이루어져 있습니다.

    class Solution {
        public String solution(String my_string, int n) {
            String answer = "";

            String[] myString = my_string.split("");

            for (String t : myString) {
                for (int i = 0; i < n; i++) {
                    answer = answer.concat(t);
                }
            }
            return answer;
        }
    }

    // 코드 참고
    // class Solution {
    //    public String solution(String my_string, int n) {
    //        StringBuilder sb = new StringBuilder();
    //        for(char c : my_string.toCharArray()){
    //            sb.append((c + "").repeat(n));
    //        }
    //        return sb.toString();
    //    }
    //}
}
