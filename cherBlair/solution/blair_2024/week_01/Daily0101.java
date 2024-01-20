package blair_2024.week_01;

import java.util.Scanner;

public class Daily0101 {

    // 04-2 선택 정렬

    // 내림차순으로 정렬하기
    // https://www.acmicpc.net/problem/1427

    /*
        ❗️pesudo code

        str (정렬할 수)
        A (자릿수별로 구분해 저장한 배열)
        for (str의 길이만큼 반복) {
            A 배열 저장 -> str.substring
        }
        for (i: 0 ~ str의 길이만큼 반복) {
            for (j: i + 1 ~ str의 길이만큼 반복) {
                현재 범위에서 Max 찾기
            }
            현재 i 값과 Max 값 중 Max가 더 크면 swap 수행하기
        }
        A 배열 출력

     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] A = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for (int i = 0; i < str.length(); i++) {
            int Max = i;
            for (int j = i + 1; j < str.length(); j++) {
                if (A[j] > A[Max]) {
                    Max = j;
                }
            }
            if (A[i] < A[Max]) {
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            System.out.print(A[i]);
        }
    }
}
