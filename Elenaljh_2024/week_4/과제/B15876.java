package 과제;

/*
노답
https://www.acmicpc.net/problem/15876
 */
import java.util.Scanner;

public class B15876 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int turn = 0;
//        5 * n
        // 5*k까지만 구한다.
        // 00000

        int cnt = 0;
        for (int i = 0; i <= 5*k; i++) {
            int a = i;
            while (a > 0) {

            }

        }
        // 숫자를 센다 1++;
        // 4명이면 20개
        //
        // 0
        // 110
        // 1
        // 110
        // 0
        // 101
        // 1
        // 101
        // 1
        // 1

        // 1번째 사람이 0번째 인덱스?
//        System.out.println(0b)
//        for (int i = 0; i <= n; i++) {
//            while ()
//        }
    }

    static int length(int number) {
        if (number == 0) return 1;
        int length = 0;
        while (number>0) {
            length++;
            number = number >> 1; //number을 오른쪽으로 시프트 -> 2로 나누는 효과
        }
        return length;
    }
}
