https://school.programmers.co.kr/learn/courses/30/lessons/12985#
1 2 3 4 5 6 7 8에서 a가 4 b 가 7이라고할때 
한번 스테이지가 지나가면 a 는 2 b는 4로 바뀌게된다. 
이렇게 진행되다가 a와 b의 값이 같아지면 멈추게되는데 아래의 원리와 같다.
a가 3이고 b가4면 한번의 스테이지면 끝난다 왜냐하면 a와 b가 같아지기때문이다. 
같아진다는것은 홀수와 짝수로 대결할 수 있는 구도가 만들어졌다는 뜻이다.

import java.util.*;
class Solution
{
    //결론은 1 1 이될때 만난다는거
    public int solution(int n, int a, int b) {
        int answer = 0;
        
        while(a != b) {
            a = getNum(a);
            b = getNum(b);
            answer++;
        }
        return answer;
    }          
    public int getNum(int num) {
        if(num % 2 == 1) {
            return num / 2 + 1;
        }
        return num / 2;
    }
}
