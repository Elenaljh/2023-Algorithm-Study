package week_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Daily1214 {

    // 03-3 투 포인터

    // https://www.acmicpc.net/problem/1940
    // 주몽

    /*
    ❗️pseudo code

    N(재료의 개수), M(갑옷이 되는 번호) 저장하기
    for (N만큼 반복) {
       재료 배열 저장하기
    }
    재료 배열 저장하기
    while (i < j) {
        if (재료 합 < M) {
            작은 번호 재료를 한 칸 위로 변경하기
        } else if (재료 합 > M) {
            큰 번호 재료를 한 칸 아래로 변경하기
        } else {
            경우의 수 증가
            양쪽 index 각각 변경하기
        }
    }
    count 출력하기

    */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int count = 0, i = 0, j = N - 1;

        while (i < j) {
            if (A[i] + A[j] < M) {
                i++;
            } else if (A[i] + A[j] > M) {
                i--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        bf.close();
    }


}
