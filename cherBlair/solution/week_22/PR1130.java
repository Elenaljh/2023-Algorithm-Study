package week_22;

public class PR1130 {

    // 문자열 밀기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120921

    class Solution {
        public int solution(String A, String B) {
            int answer = 0;
            String copy = A;

            for (int i = 0; i < A.length(); i++) {
                if (copy.equals(B)) {
                    return answer;
                }

                String a = copy.substring(copy.length() - 1);
                copy = a + copy.substring(0, copy.length() - 1);
                answer++;
            }
            return -1;
        }
    }

    // 다른 풀이 참고
    // class Solution {
    //    public int solution(String A, String B) {
    //        String tempB = B.repeat(3);
    //        return tempB.indexOf(A);
    //    }
    //}


    // 다른 풀이 2
    // class Solution {
    //    public int solution(String A, String B) {
    //
    //        return (B+B).indexOf(A);
    //    }
    //}
}
