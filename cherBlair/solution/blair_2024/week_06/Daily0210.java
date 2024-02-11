package blair_2024.week_06;

public class Daily0210 {

    // 05-1 깊이 우선 탐색 DFS

    // 신기한 소수 찾기
    // https://www.acmicpc.net/problem/2023

    /*
        ❗️pseudo code

        digit (자릿수)
        DFS 실행 // 숫자 2,3,5,7로 탐색 시작, 일의 자리 시작이므로 자릿수는 1
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

        // DFS 구현하기
        DFS(숫자, 자릿수) {
            if(자릿수 == digit) {
                if(소수) 수 출력하기
                탐색 종료
            }

            for (1 ~ 9 반복) {
                if (뒤에 붙는 수가 홀수이면서 소수일 때)
                // 자릿수를 1씩 늘리면서 DFS 실행
                DFS(현재 수 * 10 + i, 자릿수 + 1)
            }
        }

        // 소수 구하기 함수
        for ('2 ~ 현재 수 / 2' 반복하기) {
            if (나머지가 0이면) {
                return 소수가 아님
            }
        }
        return 소수
     */
}
