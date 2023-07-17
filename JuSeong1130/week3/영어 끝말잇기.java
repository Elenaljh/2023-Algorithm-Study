/*
문제 요구사항
1. 전사람이 말한 마지막 글자와 내 첫글자가 같아야한다.  > charAt으로 첫글자와 마지막글자 비교
2. 전 사람이 말한걸 중복해서 말하면 안된다. 자료구조 Set contains O(1)로 중복 여부 판단
3. 끝말잇기가 잘 끝났다면 0,0 리턴 > 제시된 단어 총 크기 == Set의 크기가 같다면 끝말잇기가 잘 끝난것

https://school.programmers.co.kr/learn/courses/30/lessons/12981

어려웠던점
왼쪽은 걸린사람의 차례
오른쪽은 어떤 스테이지 였는데 이걸 좀 쉽고 효율적으로 어떻게 표현할지가 어려웠다.
0번째부터시작이아니라 1부터 시작이고 전값을 세팅하기위해 1번째를 건너뛰었기때문에 count를 2로 두고 시작했다
이후 count 값을 가지고 left와 right값을 구해내었다.

*/


import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int count = 2;
        char prev = words[0].charAt(words[0].length()-1);
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            char firstChar = words[i].charAt(0);
            if(prev != firstChar || set.contains(words[i])) {
                break;
            }
            set.add(words[i]);
            prev = words[i].charAt(words[i].length()-1);
            count++;
        }
        if(set.size() == words.length){
            return new int[] {0,0};
        }
        int left = count % n == 0 ? n : count % n;
        int right = count % n == 0 ? count / n : (count / n) + 1;  
        int[] answer = {left, right};
        return answer;
    }
}
