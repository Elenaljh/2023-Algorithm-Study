package blair_2024.week_01;

import java.util.Scanner;

public class Daily0106 {

    // 04-2 선택 정렬

    // ATM 인출 시간 계산하기
    // https://www.acmicpc.net/problem/11399

    /*
        ❗️문제 분석하기

         - ATM에서 모든 사람이 가장 빠른 시간에 인출하는 방법을 그리디 방식으로 해결해보기
            ㄴ 그리디 방식: ATM 앞에 있는 사람 중 인출 시간이 가장 적 걸리는 사람이 먼저 인출할 수 있도록 순서를 정하는 것
         - 그리디 방식을 사용하기 위해 인출 시간을 기준으로 값을 정렬해야 한다. -> 삽입 정렬 이용
         - 정렬을 마친 후에는 각 사람이 돈을 인출하는 데 필요한 시간 더하기
     */

    /*
        ❗️pesudo code

        numOfPeople (사람 수)
        savedArray (자릿수별로 구분해 저장한 배열)
        sumArray (savedArray의 합 배열: 각 사람이 인출을 완료하는 데 필요한 시간을 저장)

        for (numOfPeople 만큼 반복) {
            savedArray 배열 저장하기
        }

        for (i : numOfPeople 만큼 반복) {
            for (j : i -1 ~ 0까지 뒤에서부터 반복) {
                현재 범위에서 삽입 위치 찾기
            }
            for (j: i ~ insert_point +1 까지 뒤에서부터 반복하기) {
                삽입을 위해 삽입 위치에서 i까지 데이터를 한 칸씩 뒤로 밀기
            }
            삽입 위치에 현재 데이터 삽입하기
        }
        for (i : numOfPeople 만큼 반복) {
            savedArray 배열을 통한 합배열 sumArray 만들기
        }
        sumArray 배열의 각 데이터 값을 모두 합해 결과 출력하기
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfPeople = sc.nextInt();
        int[] savedArray = new int[numOfPeople];
        int[] sumArrray = new int[numOfPeople];

        for (int i = 0; i < numOfPeople; i++) {
            savedArray[i] = sc.nextInt();
        }

        for (int i = 1; i < numOfPeople; i++) { // 삽입 정렬
            int insert_point = i;
            int insert_value = savedArray[i];
            for (int j = i - 1; j >= 0; j--) {
                if (savedArray[j] < savedArray[i]) {
                    insert_point = j + 1;
                    break;
                }
                if (j == 0) {
                    insert_point = 0;
                }
            }
            for (int j = i; j > insert_point; j--) {
                savedArray[j] = savedArray[j - 1];
            }
            savedArray[insert_point] = insert_value;
        }
        sumArrray[0] = savedArray[0]; // 합 배열 만들기
        for (int i = 1; i < numOfPeople; i++) {
            sumArrray[i] = sumArrray[i - 1] + savedArray[i];
        }
        int sum = 0;
        for (int i = 0; i < numOfPeople; i++) {
            sum = sum + sumArrray[i];
        }
        System.out.println(sum);
    }
}
