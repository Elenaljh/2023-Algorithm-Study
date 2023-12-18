package week_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Daily1218 {

    // 03-3 투 포인터

    // https://www.acmicpc.net/problem/1253
    // 좋은 수 구하기

    /*
        ❗️pseudo code

        N (수의 개수)
        A (수 데이터 저장 배열)

        for (N만큼 반복하기) {
            A 배열에 데이터 저장
        }

        A 배열 정렬

        for (k를 0부터 N까지 반복) {
            변수 초기화하기 (찾고자 하는 값: find, 포인터 i, j)
            while (i < j) {
                if (A[i] + A[j] == 찾고자 하는 값) {
                    두 포인터 i, j가 k가 아닐 때 결괏값에 반영 및 while문 종료
                    두 포인터 i, j가 k가 맞을 때 포인터 변경 및 계속 수행
                } else if (A[i] + A[j] < 찾고자 하는 값) {
                    포인터 i 증가
                } else {
                    포인터 j 감소
                }
            }
        }
        좋은 수의 개수 출력

     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int result = 0;
        long A[] = new long[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        for (int k = 0; k < N; k++) {
            long find = A[k];
            int i = 0;
            int j = N - 1;

            while (i < j) {
                if (A[i] + A[j] == find) {
                    // find는 서로 다른 수 의 합이어야 함
                    if (i != k && j != k) {
                        result++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else {
                        j--;
                    }
                } else if (A[i] + A[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(result);
        bf.close();
    }
}
