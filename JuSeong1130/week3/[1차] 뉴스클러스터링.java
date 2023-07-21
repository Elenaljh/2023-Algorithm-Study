https://school.programmers.co.kr/learn/courses/30/lessons/17677


/*
이문제의 핵심은 교집합과 합집합의 개수를 구해 결과를 내야했다.
교집합은 서로 있다면 둘중 작은 개수를 교집합의 개수로 추가하면 됬다.
합집합은 A + B - 교집합의 개수 이렇게 구하면 됬다.
합집합 원소개수 구하는걸 까먹어서 애먹었던 문제이다.

*/

import java.util.*;
import java.util.regex.Pattern;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        double hap = 0;
        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();
        for(int i = 0; i < str1.length()-1; i++) {
            String word = str1.substring(i,i+2);
            if(!Pattern.matches("[a-zA-Z]{2,}",word)) continue;
            word = word.toUpperCase();
            str1Map.put(word,str1Map.getOrDefault(word,0)+1);
            hap++;
        }
        for(int i = 0; i < str2.length()-1; i++) {
            String word = str2.substring(i,i+2);
            if(!Pattern.matches("[a-zA-Z]{2,}",word)) continue;
            word = word.toUpperCase();
            str2Map.put(word,str2Map.getOrDefault(word,0)+1);
            hap++;
        }
        if(str1Map.size() == 0 && str2Map.size() ==0) {
            return 65536;
        }
        int kyo = 0;
        for(String str : str1Map.keySet()) {
            if(str2Map.containsKey(str)) {
                int num = str1Map.get(str) > str2Map.get(str) ? str2Map.get(str) : str1Map.get(str);
                kyo += num;
                hap -= num;
            }
        }
        return (int)(kyo / hap * 65536);
    }
}
