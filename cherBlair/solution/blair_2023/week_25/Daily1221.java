package blair_2023.week_25;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Daily1221 {

    // 03-5 스택과 큐
    // https://www.acmicpc.net/problem/2164

    /*
        ❗️pseudo code

        N (카드의 개수)
        myQueue (카드 저장 자료구조)
        for (카드의 개수만큼 반복) {
            큐에 카드 저장하기
        }
        while (카드가 1장 남을 때 까지) {
            맨 위의 카드를 버림: poll()
            맨 위의 카드를 제일 아래로 이동: poll() -> add()
        }
        마지막으로 남은 카드 출력

     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            myQueue.add(i);
        }
        while (myQueue.size() > 1) {
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }
        System.out.println(myQueue.poll());
    }
}
