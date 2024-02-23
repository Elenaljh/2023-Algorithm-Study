package 스터디;

import java.io.*;
import java.util.*;
public class B16637_괄호추가하기 {
    static int N, MAX = Integer.MIN_VALUE; //MAX = 0으로 했다가 피봄ㅜ
    static boolean[] selected;
    static char[] equation, operations;
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //식 길이
        equation = br.readLine().toCharArray();
        operations = new char[N/2];
        selected = new boolean[N/2];
        for (int i = 0; i < N; i++) {
            if (i%2==1) operations[i/2] = equation[i];
        }

        select(0);

        System.out.println(MAX);
    }

    static void select(int count) {
        if (count == N/2) {
//            System.out.println(Arrays.toString(selected));
            //후위연산자 변환
            String postfix = convertToPostfix();
            //계산
            int result = operate(postfix);
//            System.out.println(postfix + " = " + result);
            //MAX 갱신
            MAX = Integer.max(MAX, result);
            return;
        }

        if (count==0 || !selected[count-1]) {
            selected[count] = true;
            select(count+1);
        }
        selected[count] = false;
        select(count+1);
    }

    static String convertToPostfix() {
        boolean[] marker = new boolean[N];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N / 2; i++) {
            if (selected[i]) {
                marker[i * 2 + 1] = true;
            }
        }
        //원래는 여는 괄호 만나면 여는 괄호 스택에 저장 -> 그 후 만나는 연산자 모두 스택에 저장
        //닫는 괄호 만났을 때 여는 괄호가 나올 때까지 스택에서 연산자 꺼내서 sb에 추가
        //스택에서 빠져나온 여는 괄호는 버리기
        //위와 같이 하는 것이 정석인데 이 문제같은 경우 괄호속 연산자가 1개이고, 중위식에 따로 괄호가 있는 것이 아니기 때문에 약식으로 함
        for (int i = 0; i < N; i++) {
            //숫자일때
            if (i % 2 == 0) {
                sb.append(equation[i]);
                if (!stack.isEmpty() && marker[i - 1]) {
                    //닫는 괄호가 나올 경우 스택에 저장된 연산자 반환
                    sb.append(stack.pop());
                }
                continue;
            }
            //괄호속 연산자인 경우
            if (marker[i]) {
                stack.push(equation[i]);
                continue;
            }
            //일반(괄호 속X) 연산자이고 스택이 비어있을 때
            if (stack.isEmpty()) {
                stack.push(equation[i]);
                continue;
            }
            //스택이 안비어있을때 - 스택 연산자 빼서 표현 후 현재 연산자는 저장
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            stack.push(equation[i]);
        }
        //마지막으로 스택 비우기
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }


    static int operate(String postfix) {
        Stack<Integer> resultStack = new Stack<>();
        for (int i = 0; i < N; i++) {
            char current = postfix.charAt(i);
            if (current == '+' || current == '-' || current == '*' || current == '/') {
                int second = resultStack.pop();
                int first = resultStack.pop();
                int result = 0;
                switch (current) {
                    case '+':
                        result = first + second;
                        break;
                    case '-':
                        result = first - second;
                        break;
                    case '*':
                        result = first * second;
                        break;
                    case '/':
                        result = first/second;
                }
                resultStack.push(result);
            } else {
                resultStack.push(current - '0');
            }
        }
        return resultStack.pop();
    }

}



