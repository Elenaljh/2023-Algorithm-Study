/**
괄호의 값
https://www.acmicpc.net/problem/2504
*/

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        Iterator<Integer> iterator;
        String input = scan.nextLine();
        int answer = 0;
        int temp = 0;

        try {
            for (int i = 0; i < input.length(); i++) {
                switch (input.substring(i, i + 1)) {
                    case "(":
                        stack.push(2);
                        break;
                    case ")":
                        if (stack.lastElement() == 2) {
                            if (input.charAt(i - 1) == '(') {
                                temp = 0;
                                temp += stack.pop();
                                iterator = stack.iterator();    // 이 부분에 주석처리한 코드를 넣어도 동일하게
                                                                // 작동함
                                while (iterator.hasNext()) {    // for (int n : stack) {
                                    temp *= iterator.next();    // temp *= n;
                                }                               // }
                                answer += temp;
                            } else {
                                stack.pop();
                            }
                        }
                        break;
                    case "[":
                        stack.push(3);
                        break;
                    case "]":
                        if (stack.peek() == 3) {
                            if (input.charAt(i - 1) == '[') {
                                temp = 0;
                                temp += stack.pop();
                                iterator = stack.iterator();
                              
                                while (iterator.hasNext()) {
                                    temp *= iterator.next();
                                }
                                answer += temp;
                            } else {
                                stack.pop();
                            }
                        }
                        break;
                }
            }
        } catch (Exception e) {
            answer = 0;
        } finally {
            System.out.println(stack.isEmpty() ? answer : 0);
        }
        scan.close();
    }
}
