package 수업;

import java.util.ArrayDeque;
import java.util.Queue;

//완전이진트리 - 배열 구현
//크기를 늘리지 않는 버전
public class CompleteBinaryTree<T> {

    private Object[] nodes;
    private final int SIZE;
    private int lastIndex; //마지막으로 저장된 노드의 인덱스

    public CompleteBinaryTree(int size) {
        this.SIZE = size;
        nodes = new Object[size+1]; //0인덱스 사용하지 않음
    }

    public boolean isEmpty() {
        return lastIndex == 0;
    }

    public boolean isFull() {
        return lastIndex == SIZE;
    }

    public void add(T e) {
        if (isFull()) {
            System.out.println("포화상태입니다.");
            return;
        }
        nodes[++lastIndex] = e;
    }
    public void bfs() {
        if (isEmpty()) return; //루트노드 하나는 있어야 탐색이 됨..
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1); //방문할 노드를 관리할 값 넣기 (노드 번호 인덱스)

        while (!queue.isEmpty()) { //방문할 대상이 있는 동안 반복
            int current = queue.poll();
            System.out.println(nodes[current]); //노드 처리 로직

            //왼쪽 자식노드 : 번호 = 부모*2 -> 존재여부 검사
            if (current*2 <= lastIndex) {
                queue.offer(current*2);
            }
            //오른쪽 자식노드
            if (current*2+1 <= lastIndex) {
                queue.offer(current*2+1);
            }
        }


    }
}
