package blair_2024.week_03;

public class Daily0114 {

    // 04-5 병합 정렬

    // 수 정렬하기 2
    // https://www.acmicpc.net/problem/2751

    /*
    ❗️pesudo code

    count (정렬할 수 개수)
    sortedArray (정렬할 배열)
    tempArray (정렬 시 잠시 사용 할 임시 배열)
    for (count 만큼 반복) {
        sortedArray 선언
    }
    병합 정렬 함수 수행
    결괏값 출력

    // 병합 정렬 수행
    병합 정렬 (start, end) {
        start(시작점), end(종료점), middle(중간점)

        // 재귀 함수 형태로 구현
        병합 정렬 (start, middle)
        병합 정렬 (middle + 1, end)
        for (start ~ end) {
            tempArray 저장
        }

        // 두 그룹 병합 로직
        index1 (앞쪽 그룹 시작점)
        index2 (뒤쪽 그룹 시작점)
        while (index1 <= 중간점 && index2 <= 종료점)
            양쪽 그룹 index가 가르키는 값을 비교한 후 더 작은 수를 선택해 배열에 저장하고,
            선택된 데이터의 index 값을 오른쪽으로 한 칸 이동하기
            반복문이 끝난 후 남아 있는 데이터 정리
        }

     */

}
