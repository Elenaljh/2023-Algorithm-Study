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

    //동일 너비 단위로 처리
    public void bfs3() {
        if (isEmpty()) return;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        int current = 0, size= 0, breadth = 0;
        while (!queue.isEmpty()) {
            size = queue.size(); //큐 사이즈 체크 - 동일 너비의 탐색대상노드의 개수
            System.out.println("breadth " + breadth + " : ");
            while (--size >= 0) {
                current = queue.poll();
                System.out.println(nodes[current]+"\t");
                if(current*2<=lastIndex) queue.offer(current*2);
                if(current*2+1<=lastIndex) queue.offer(current*2+1);
            }
            System.out.println();
            ++breadth; //너비 증가 (다음 탐색 위함)
        }
    }

    //최소한 루트노드 1개 이상이 있을 때만 dfs 순회할 수 있도록
    public void dfsByPreorder() {
        if(isEmpty()) return;
        System.out.println("====preorder====");
        dfsByPreorder(1);
        System.out.println();
    }

    //dfs : 재귀 사용 -> 함수 호출 스택을 간접적으로 이용해본다.
    private void dfsByPreorder(int current) { //전위 순회
        System.out.print(nodes[current] + "\t"); //노드 처리 로직

        //왼쪽 자식노드 : 번호 = 부모*2 -> 존재여부 검사
        if (current*2 <= lastIndex) {
            dfsByPreorder(current*2);
        }
        //오른쪽 자식노드
        if (current*2+1 <= lastIndex) {
            dfsByPreorder(current*2+1);
        }
    }


    /** 중위순회 **/
    //최소한 루트노드 1개 이상이 있을 때만 dfs 순회할 수 있도록
    public void dfsByInorder() {
        if(isEmpty()) return;
        System.out.println("====inorder====");
        dfsByInorder(1);
        System.out.println();
    }

    //dfs : 재귀 사용 -> 함수 호출 스택을 간접적으로 이용해본다.
    private void dfsByInorder(int current) { //전위 순회
        //왼쪽 자식노드 : 번호 = 부모*2 -> 존재여부 검사
        if (current*2 <= lastIndex) {
            dfsByInorder(current*2);
        }
        System.out.print(nodes[current] + "\t"); //노드 처리 로직
        //오른쪽 자식노드
        if (current*2+1 <= lastIndex) {
            dfsByInorder(current*2+1);
        }
    }

    /** 후위순회 **/
    //최소한 루트노드 1개 이상이 있을 때만 dfs 순회할 수 있도록
    public void dfsByPostorder() {
        if(isEmpty()) return;
        System.out.println("====postorder====");
        dfsByPostorder(1);
        System.out.println();
    }

    //dfs : 재귀 사용 -> 함수 호출 스택을 간접적으로 이용해본다.
    private void dfsByPostorder(int current) { //전위 순회
        //왼쪽 자식노드 : 번호 = 부모*2 -> 존재여부 검사
        if (current*2 <= lastIndex) {
            dfsByPostorder(current*2);
        }
        //오른쪽 자식노드
        if (current*2+1 <= lastIndex) {
            dfsByPostorder(current*2+1);
        }
        System.out.print(nodes[current] + "\t"); //노드 처리 로직
    }
}
