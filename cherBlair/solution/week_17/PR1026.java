package week_17;

import java.util.Arrays;

public class PR1026 {

    // 💛 한 번만 등장한 문자
    // https://school.programmers.co.kr/learn/courses/30/lessons/120896
    // 문제 설명
    // 문자열 s가 매개변수로 주어집니다.
    // s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.
    // 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.

    // 제한사항
    //  0 < s의 길이 < 1,000
    //  s는 소문자로만 이루어져 있습니다.

    class Solution {
        public String solution(String s) {
            String answer = "";
            String[] str = s.split("");
            int strLength = str.length;

            Arrays.sort(str);

            for (int i = 0; i < strLength; i++) {
                int count = 0;

                for (int j = 0; j < strLength; j++) {
                    if (str[i].equals(str[j])) {
                        count++;
                    }
                }
                if (count == 1) {
                    answer += str[i];
                }
            }
            return answer;
        }
    }

    // 다른 풀이 참고 - [ HP ]
    // import java.util.Arrays;
    //import java.util.Map;
    //import java.util.stream.Collectors;
    //
    //class Solution {
    //    public String solution(String s) {
    //        return Arrays.stream(s.split(""))
    //                .collect(Collectors.groupingBy(s1 -> s1))
    //                .entrySet()
    //                .stream()
    //                .filter(entry -> entry.getValue().size() <= 1)
    //                .map(Map.Entry::getKey)
    //                .sorted()
    //                .collect(Collectors.joining());
    //    }
    //}


    // 다른 풀이 참고 2
    // class Solution {
    //    public String solution(String s) {
    //        int[] alpha = new int[26];
    //        for(char c : s.toCharArray()){
    //            alpha[c - 'a']++;
    //        }
    //
    //        StringBuilder answer = new StringBuilder();
    //        for(int i = 0; i < 26; i++){
    //            if(alpha[i] == 1){
    //                answer.append((char)(i + 'a'));
    //            }
    //        }
    //        return answer.toString();
    //    }
    //}
}
