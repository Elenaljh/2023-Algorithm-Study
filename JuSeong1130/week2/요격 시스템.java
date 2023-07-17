import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,Comparator.comparingInt(o1 -> o1[1]));
        int prev = 0;
        
        
        for(int i = 0; i < targets.length; i++) {
            int start = targets[i][0];
            int end = targets[i][1];
            if(prev <= start) {
                prev = end;
                answer++;
            }
        }
        return answer;
    }
}

/*
이문제의 핵심
스케줄링에 대해 알고 있으면 좋다

이문제는 한번에 최대한 많은것을 처리하는것이 핵심이다.

어떻게하면 한번에 많은것을 처리할 수 있을까?
같이처리하는것을 늘려나가면된다.
같이 처리할 수 있는 기준은 A의 끝나는구간 > B의 시작구간이여야한다. 그렇다면 같이 처리할 수 있다.
이것을 기준으로 탐욕적으로 생각해 문제를 해결하면된다.
*/
