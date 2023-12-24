package week_25;

import java.util.Scanner;
import java.util.Stack;

public class Daily1220 {

    /*
        03-5 스택과 큐

        ❗️스택(stack): 삽입과 삭제 연산이 후입선출(LIFO)로 이뤄지는 자료구조. 삽입과 삭제가 한 쪽에서만 이뤄진다.
                     깊이 우선 탐색(DFS), 백트래킹 종류의 코딩 테스트에 효과적
        ❗️스택 용어
            - 위치
                ㄴ top: 삽입과 삭제가 일어나는 위치
            - 연산
                ㄴ push: top 위치에 새로운 데이터를 삽입하는 연산
                ㄴ pop: top 위치에 현재 있는 데이터를 삭제하고 확인하는 연산
                ㄴ peek: top 위치에 현재 있는 데이터를 단순 확인하는 연산

        ❗️큐(queue): 삽입과 삭제 연산이 선입선출(FIFO)로 이뤄지는 자료구조. 삽입과 삭제가 양방향에서 이뤄진다.
                    너비 우선 탐색(BFS)에서 자주 사용함
        ❗️큐 용어
            - 위치
                ㄴ rear: 큐에서 가장 끝 데이터를 가리키는 영역
                ㄴ front: 큐에서 가장 앞의 데이터를 가리키는 영역
            - 연산
                ㄴ add: rear 부분에 새로운 데이터를 삽입하는 연산
                ㄴ poll: front 부분에 있는 데이터를 삭제하고 확인하는 연산
                ㄴ peek: 큐의 맨 앞(front)에 있는 데이터를 확인할 때 사용하는 연산
     */


    // 스택으로 오름차순 수열 만들기
    // https://www.acmicpc.net/problem/1874

    /*
        ❗️pseudo code

        N(수열 개수)
        A[] (수열 배열)

        수열 배열 채우기
        for (N만큼 반복) {
            if (현재 수열 값 >= 오름차순 자연수) {
                while (값이 같아질때까지) {
                    push()
                    (+) 저장
                }
                pop()
                (-)저장
            } else (현재 수열 값 < 오름차순 자연수) {
                pop()
                if (스택 pop 결괏값 > 수열의 수) {
                    NO 출력
                } else {
                    (-) 저장
                }
            }
        }
        if (NO 값을 출력한 적이 없으면) {
            저장한 값 출력
        }

     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;
        for (int i = 0; i < A.length; i++) {
            int su = A[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if (result) {
            System.out.println(bf.toString());
        }
    }
}
