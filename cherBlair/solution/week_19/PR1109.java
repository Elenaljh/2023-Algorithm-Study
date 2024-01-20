package week_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PR1109 {

    /*
     * 💛외게어 사전
     * https://school.programmers.co.kr/learn/courses/30/lessons/120869
     * 문제 설명
     * PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다.
     * 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다.
     * spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 존재하지 않는다면 2를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
        spell과 dic의 원소는 알파벳 소문자로만 이루어져있습니다.
        2 ≤ spell의 크기 ≤ 10
        spell의 원소의 길이는 1입니다.
        1 ≤ dic의 크기 ≤ 10
        1 ≤ dic의 원소의 길이 ≤ 10
        spell의 원소를 모두 사용해 단어를 만들어야 합니다.
        spell의 원소를 모두 사용해 만들 수 있는 단어는 dic에 두 개 이상 존재하지 않습니다.
        dic과 spell 모두 중복된 원소를 갖지 않습니다.
     * */
    class Solution {
        public int solution(String[] spell, String[] dic) {
            int answer = 0;
            int compareCount = 0;
            int spellCount = spell.length;
            String spelltoString = Arrays.toString(spell);

            for (String s : dic) {
                String[] split = s.split("");
                int matchCount = 0;

                matchCount = getMatchCount(spelltoString, split, matchCount);
                if (spellCount == matchCount) {
                    compareCount++;
                }
            }
            return answer = compareCount < 1 ? 2 : 1;
        }

        private int getMatchCount(String spelltoString, String[] split, int matchCount) {
            List<String> notDuplicated = new ArrayList<>();

            for (String st : split) {
                if (!notDuplicated.contains(st)) {
                    notDuplicated.add(st);
                }
            }
            for (String s2 : notDuplicated) {
                if (spelltoString.contains(s2)) {
                    matchCount++;
                }
            }
            return matchCount;
        }
    }

    // 다른 풀이 - [ hp ]
    // import java.util.Arrays;
    //import java.util.stream.Collectors;
    //
    //class Solution {
    //    public int solution(String[] spell, String[] dic) {
    //        return Arrays.stream(dic).map(s -> s.chars().sorted().mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining())).collect(Collectors.toList()).contains(Arrays.stream(spell).sorted().collect(Collectors.joining())) ? 1 : 2;
    //    }
    //}


    // 다른 풀이 2
    // class Solution {
    //    public int solution(String[] spell, String[] dic) {
    //        int answer = 2;
    //
    //
    //        for(String dicS : dic) {
    //
    //            boolean isRight = true;
    //            for(String spellS : spell) {
    //                if(dicS.indexOf(spellS) == -1) {
    //                    isRight = false;
    //                    break;
    //                }
    //            }
    //
    //            if(isRight) {
    //                answer = 1;
    //                break;
    //            }
    //        }
    //
    //        return answer;
    //    }
    //}


    // test code
//    public static void main(String[] args) {
//        //String[] spell = {"s", "o", "m", "d"};
//        String[] spell = {"p", "o", "s"};
//
//        //String[] dic = {"moos", "dzx", "smm", "sunmmo", "som"};
//        String[] dic = {"sod", "eocd", "qixm", "adio", "soo"};
//        int answer = 0;
//        int compareCount = 0;
//        String spelltoString = Arrays.toString(spell);
//        int spellCount = spell.length;
//
//        for (String s : dic) {
//            String[] split = s.split("");
//            int matchCount = 0;
//
//            matchCount = getMatchCount(spelltoString, split, matchCount);
//            if (spellCount == matchCount) {
//                compareCount++;
//            }
//        }
//
//        System.out.println();
//        System.out.println("compareCount   " + compareCount);
//        answer = compareCount < 1 ? 2 : 1;
//
//        System.out.println();
//        System.out.println("**********");
//        System.out.println(answer);
//    }
//
//    private static int getMatchCount(String spelltoString, String[] split, int matchCount) {
//        List<String> notDuplicated = new ArrayList<>();
//
//        for (String st : split) {
//            if (!notDuplicated.contains(st)) {
//                notDuplicated.add(st);
//            }
//        }
//
//        for (String s2 : notDuplicated) {
//            if (spelltoString.contains(s2)) {
//                matchCount++;
//            }
//        }
//        return matchCount;
//    }
}
