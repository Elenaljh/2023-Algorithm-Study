//https://school.programmers.co.kr/learn/courses/30/lessons/43238
import java.util.*;

/*
이문제의 핵심 키 
mid(총시간) / time(심사관당 처리되는데 걸리는시간)해서 이 심사관이 몇명처리가능한지

만약 sum이 n보다 크다면 더작은게 있을테니 end를 줄이고
sum이 n보다 작다면 더커야 n들을 다 처리가능하니 start를 mid로 올리고

내가 걱정하는거
A B C 심사관있을때 A번만으로끝날수도있는데? 이건 어떻게하지?
되는경우까지 계속 줄여나가면서 하기때문에 최저를 구할 수 있음
만약에 5명이있을때  10초 부터 가능한대 5초에 A B만으로 5명이 끝나면 5초가되는것 
*/

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = times[0];
        long end = times[times.length-1] * (long)n; // 최악의 시간  // long을 붙여주는이유 최악 * 최악 을하게되면 int 범위를 벗어나게 되므로 연산을 long으로 해준다는 것을 명시해주어야한다. -1486618624
        long answer = 0;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for(int time : times) {
                sum +=  (mid / time);
            }
            if(sum >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}
