package 재귀;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/11729
하노이 탑 이동 순서
 */
public class B11729 {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hanoi(n, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb);
    }
    static void hanoi(int n, int start, int middle, int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            count++;
            return;
        }
        hanoi(n-1, start, end, middle);
        hanoi(1, start, middle, end);
        hanoi(n-1, middle, start, end);
    }
}

