package week_07;

public class PR0818 {

    // ◼︎ 문자열 뒤집기
    // 문자열 my_string이 매개변수로 주어집니다. my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  1 ≤ my_string의 길이 ≤ 1,000

    class Solution {
        public String solution(String my_string) {
            String answer = "";

            StringBuffer sb = new StringBuffer(my_string);
            answer = sb.reverse().toString();

            return answer;
        }
    }

    // 참고 코드
    // class Solution {
    //    public String solution(String myString) {
    //        return new StringBuilder(myString).reverse().toString();
    // }
    //}
}
