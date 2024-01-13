package blair_2024.week_02;

public class Daily0110 {

    // 04-4 퀵 정렬

    // k번째 수 구하기
    // https://www.acmicpc.net/problem/11004

    /*
        ❗️pesudo code

        count (숫자의 개수)
        numK (K번째의 수)
        savedArray (숫자 데이터 저장 배열)
        for (count 만큼 반복( {
            savedArray 배열 저장하기
        }
        퀵 소트 실행
        K번째 데이터 출력

        * 별도 함수 구현
        퀵 소트 함수 (시작, 종료, K) {
            피벗 구하기 함수 (시작, 종료)
            if (피벗 == K) {
                종료
            } else if (K < 피벗) {
                퀵 소트 수행하기 (시작, 피벗 -1, K)
            } else {
                퀵 소트 수행하기 (피벗 + 1, 종료, K)
            }
        }
        피벗 구하기 함수 (시작, 종료) {
            데이터가 2개인 경우는 바로 비교하여 정렬
            middle (중앙 값)
            중앙 값을 시작 위치와 swap
            피벗을 시작 위치 값 savedArray[S]로 저장
            i (시작점), j (종료점)
            while (i <= j) {
                피벗보다 큰 수가 나올 때까지 i++
                피벗보다 작은 수가 나올 때까지 j--
                찾은 i와 j 데이터를 swap
            }
            피벗 데이터를 나눠진 두 그룹의 경계 index에 저장하기
            경계 index 리턴
        }

     */
}
