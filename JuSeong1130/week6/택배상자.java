/*
while문의 종료조건에 있어 많이 헷갈렸던 문제다.

현재 레일에 있는값과 order에 있는 값이 같으면 택배차량에 넣고 또한 보조레일 입구에있는 값과 같다면 택배상장에 넣고
아니면 보조레일에 넣게되는 문제인데
엄청 복잡하다..

결국 두가지라 생각이 들게 되어풀었는데
레일에 있는 것과 보조레일에 있는경우를 같이 확인해야하는경우

보조레일만 확인하는경우

이렇게 두가지가 있고 결국에 2번째 보조레일만 확인하는 경우에서 보조레일에도없다면 while이 끝나게 구성하였다.

*/


import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int nowNum = 1;
        int index = 0;        
        while(true) {
           if(nowNum <= order.length) {
               if(nowNum == order[index]) {
                   answer++;
                   index++;
                   nowNum++;
               } else {
                   if(!stack.isEmpty() && stack.peek() == order[index]) {
                       answer++;
                       index++;
                       stack.pop();
                   } else {
                       stack.push(nowNum);
                       nowNum++;
                   }
               }
           } else {
               if(!stack.isEmpty() && stack.pop() == order[index]) {
                   answer++;
                   index++;
               } else {
                   break;
               }
           }
        }
        return answer;
    }
}
