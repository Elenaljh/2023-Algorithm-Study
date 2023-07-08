//https://school.programmers.co.kr/learn/courses/30/lessons/154539
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<int[]> stack = new Stack<>();
        int[] initArr = {0,numbers[0]};
        stack.add(initArr);
        for(int i = 1; i < numbers.length; i++) {
            while(!stack.isEmpty()) {
                int[] arr = stack.peek();
                int index = arr[0];
                int num = arr[1];
                if(num < numbers[i]) {
                    answer[index] = numbers[i];
                    stack.pop();
                } else {
                    
                    break;
                }
            }
            stack.add(new int[]{i,numbers[i]});
        }
        while(!stack.isEmpty()) {
             int[] arr = stack.pop();
             int index = arr[0];
             answer[index] = -1;
        }
        /* 시간초과 코드
        List<Integer> list = new ArrayList<>();
        loop :
        for(int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            for(int j = i+1; j < numbers.length; j++) {
                if(num < numbers[j]) {
                    answer[i] = numbers[j];
                    continue loop;
                }
            }
            answer[i] = -1;
        } */
        
        return answer;
    }
}
