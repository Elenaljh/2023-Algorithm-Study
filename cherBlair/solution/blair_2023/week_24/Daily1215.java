package blair_2023.week_24;

import java.util.Scanner;

public class Daily1215 {

    // 03-3 투 포인터
    // ❗️투포인터: 2개의 포인터로 알고리즘의 시간 복잡도를 최적화 함.

    // https://www.acmicpc.net/problem/2018
    // 연속된 자연수의 합 구하기

    /*
     ❗️pseudo code

     N 변수 저장
     사용 변수 초기화 (count = 1, start_index = 1, end_index = 1, sum = 1)
     while (end_index != N) {
        if (sum == N) {
            count 증가, end_index 증가, sum 값 변경
        } else if (sum > N ) {
            sum 값 변경, start_index 증가
        } else if (sum < N) {
            end_index 증가, sum 값 변경
        }
     }
     count 출력하기

     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int start_idx = 1;
        int end_idx = 1;
        int sum = 1;

        while (end_idx != N) {
            if (sum == N) {
                count++;
                end_idx++;
                sum = sum + end_idx;
            } else if (sum > N) {
                sum = sum - start_idx;
                start_idx++;
            } else {
                end_idx++;
                sum = sum + end_idx;
            }
        }
        System.out.println(count);
    }
}
