package week_23;

public class PR1204 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/120907
    // OX 퀴즈

    class Solution {
        public String[] solution(String[] quiz) {
            int length = quiz.length;
            String[] answer = new String[length];
            String[] s = new String[length];

            for (int i = 0; i < length; i++) {
                s = quiz[i].split(" ");

                if (s[1].equals("-")) {
                    if (Integer.parseInt(s[0]) - Integer.parseInt(s[2]) == Integer.parseInt(s[4])) {
                        answer[i] = "O";
                    } else {
                        answer[i] = "X";
                    }
                }

                if (s[1].equals("+")) {
                    if (Integer.parseInt(s[0]) + Integer.parseInt(s[2]) == Integer.parseInt(s[4])) {
                        answer[i] = "O";
                    } else {
                        answer[i] = "X";
                    }
                }
            }
            return answer;
        }
    }

    // 다른 풀이 참고 - 1
    // class Solution {
    //    public String[] solution(String[] quiz) {
    //        for(int i=0; i<quiz.length; i++){
    //            String[] text = quiz[i].split(" ");
    //            int result = Integer.parseInt(text[0]) + ( Integer.parseInt(text[2]) * ( text[1].equals("+") ? 1:-1) );
    //            quiz[i] = result == Integer.parseInt(text[4])? "O": "X";
    //        }
    //        return quiz;
    //    }
    //}

    // 다른 풀이 참고 - 2 [ hp ]
    // import java.util.Arrays;
    //
    //class Solution {
    //    public String[] solution(String[] quiz) {
    //        return Arrays.stream(quiz).map(s -> {
    //            String[] arr = s.trim().split(" ");
    //            return arr[1].equals("+") && Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]) || Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]) ? "O" : "X";
    //        }).toArray(String[]::new);
    //    }
    //}
}
