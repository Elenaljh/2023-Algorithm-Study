package 스터디;

import java.io.*;
import java.util.*;

public class SW4008_숫자만들기 {
    static int N, operators[], numbers[], MIN, MAX;
    static char[] selectedOperators;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            //입력
            N = Integer.parseInt(br.readLine());
            operators = new int[4]; //+, -, *, / 순서
            selectedOperators = new char[N-1];
            numbers = new int[N];
            MIN = Integer.MAX_VALUE;
            MAX = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                operators[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            //경우의 수 구하기
            perm(0);

            sb.append("#").append(testCase).append(" ").append(MAX-MIN).append("\n");
        }

        System.out.println(sb);
    }

    static void perm(int count) {
        if (count == N-1) {
            //계산해서 MIN, MAX 갱신하기
            calculate();
            return;
        }

        //연산자 순열 만들기
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                if (i == 0) selectedOperators[count] = '+';
                if (i == 1) selectedOperators[count] = '-';
                if (i == 2) selectedOperators[count] = '*';
                if (i == 3) selectedOperators[count] = '/';
                operators[i]--;
                perm(count+1);
                operators[i]++;
            }
        }
    }

    static void calculate() {
        Stack<Integer> stack = new Stack<>();
        for (int i = N-1; i >= N; i--) stack.push(numbers[i]);
        int result = numbers[0];
        for (int i = 0; i < N-1; i++) {
            int first = result;
            int second = numbers[i+1];
            result = operate(first, second, selectedOperators[i]);
        }

        MIN = Integer.min(MIN, result);
        MAX = Integer.max(MAX, result);
    }

    static int operate(int a, int b, char c) {
        if (c == '+') return a+b;
        if (c == '-') return a-b;
        if (c == '*') return a*b;
        if (c == '/') return a/b;
        return 0;
    }
}
