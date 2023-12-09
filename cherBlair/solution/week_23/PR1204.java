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
}
