package blair_2023.week_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Daily1211 {

    /* 03-2 구간 합
     *
     * ❗️구간 합: 합 배열을 이용하여 시간 복잡도를 줄이기 위해 사용하는 특수한 목적의 알고리즘
     * ❗합 배열 S의 정의: S[i] = A[0] + A[1] + ... A[i-1] + A[i] // A[0]부터 A[i]까지의 합
     * ❗합 배열 S를 만드는 공식: S[i] = S[i-1] + A[i]
     * ❗구간 합을 구하는 공식: S[j] - S[i-1] 👉🏻 i에서 j까지 구간 합
     *       - A[2] ~ A[5] 구간 합을 합 배열로 구하는 과정
     *          S[5] = A[0] + A[1] + A[2] + A[3] + A[4] + A[5]
     *          S[1] = A[0] + A[1]
     *          S[5] - S[1] = A[2] + A[3] + A[4] + A[5]
     * */

    // https://www.acmicpc.net/problem/11659
    // 구간 합 구하기

    /*
     * ❗️pseudo code
     *
     * suNo(숫자 개수), quizNo(질의 개수) 저장하기
     * for (숫자 개수만큼 반복하기) {
     *  합 배열 생성하기 (S[i] = S[i - 1] + A[i])
     * }
     * for (질의 개수만큼 반복하기) {
     *  질의 범위 받기(i ~ j)
     *  구간 합 출력하기 (S[j] - S[i - 1])
     * }
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        long[] S = new long[suNo + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int q = 0; q < quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i - 1]);
        }
    }
}
