package week_09;

public class PR0829 {

    // 💛숨어있는 숫자의 덧셈 (1)

    // 문제 설명
    //  문자열 my_string이 매개변수로 주어집니다. my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  1 ≤ my_string의 길이 ≤ 1,000
    //  my_string은 소문자, 대문자 그리고 한자리 자연수로만 구성되어있습니다.


    class Solution {
        public int solution(String my_string) {
            int answer = 0;
            String numOnly = my_string.replaceAll("[^0-9]", "");
            String[] numArray = numOnly.split("");

            for (String t : numArray) {
                answer += Integer.parseInt(t);
            }

            return answer;
        }
    }

    // 코드 참고 1
    // class Solution {
    //    public int solution(String myString) {
    //        return myString.chars().mapToObj(i -> (char) i).filter(Character::isDigit).map(String::valueOf).mapToInt(Integer::valueOf).sum();
    //    }
    //}

    // 코드 참고 2
    // class Solution {
    //    public int solution(String my_string) {
    //        int answer = 0;
    //        String str = my_string.replaceAll("[^0-9]","");
    //
    //        for(char ch : str.toCharArray()) {
    //            answer += Character.getNumericValue(ch);
    //        }
    //
    //        return answer;
    //    }
    //}
}
