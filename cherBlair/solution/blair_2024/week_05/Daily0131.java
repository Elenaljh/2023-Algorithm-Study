package blair_2024.week_05;

public class Daily0131 {

    // 05-1 깊이 우선 탐색 DFS

    // 연결 요소의 개수 구하기
    // https://www.acmicpc.net/problem/11724

    /*
        ❗️pseudo code

        nodeCnt // 노드 개수
        edgeCnt // 엣지 개수
        savedArray // 그래프 데이터 저장 인접 리스트
        visitedArray // 방문 기록 저장 배열

        for (n의 개수만큼 반복) {
            savedArray의 각 ArrayList 초기화
        }

        for (edgeCnt 만큼 반복) {
            savedArray에 그래프 데이터 저장
        }

        for (nodeCnt 만큼 반복) {
            if (방문하지 않은 노드가 있으면) {
                연결 요소 개수++
                DFS 실행
            }
        }

        // DFS 구현
        DFS {
            if (현재 노드 == 방문 노드) {
                return;
            }
            visitedArray 배열에 현재 노드 방문 기록
            현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행(재귀함수 형태)
        }

     */

}
