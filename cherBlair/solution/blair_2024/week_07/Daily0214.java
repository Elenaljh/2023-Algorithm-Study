package blair_2024.week_07;

public class Daily0214 {

    // 05-1 깊이 우선 탐색 DFS

    // 친구 관계 파악하기
    // https://www.acmicpc.net/problem/13023

    /*
        ❗️pseudo code

        nodeCount (노드 개수)
        edgeCount (에지 개수)
        graphArray (그래프 데이터 저장 인접 리스트)
        visitedArray (방문 기록 저장 배열)
        arrive (도착 확인 변수)

        for (noceCount 만큼 반복) {
            visitedArray 인접 리스트의 각 ArrayList 초기화 하기
        }
        for (edgeCount 만큼 반복) {
            visitedArray 인접 리스트에 그래프 데이터 저장하기
        }
        for (nodeCount 만큼 반복) {
            각 노드마다 DFS 실행하기
            if (arrive) 반복문 종료 // depth가 5에 도달한 적이 있다면
        }
        if (arrive) 1 출력
        else 0 출력

        // DFS 구현
        DFS {
            if (길이가 5 || arrive) {
                arrive = true;
                함수 종료
            }
            방문 배열에 현재 노드 방문 기록하기
            현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행하기 (호출하는 depth는 1씩 증가)
        }

     */
}
