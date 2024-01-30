/*
https://www.acmicpc.net/problem/1021
감상: 덱에 집착해서 linkedList를 쓸 생각을 못했다. 애초에 linkedList는 덱 기능을 다 쓸 수 있다..
 */
import java.io.*;
import java.util.*;

public class B1021 {
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> dq = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        //배열 저장
        for (int i = 1; i <= n; i++) {
            dq.addLast(i);
        }

        int count = 0;
        //실행
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int index = dq.indexOf(target);
            while (target != dq.get(0)) {
                if (index > dq.size()/2) {
                    dq.addFirst(dq.pollLast());
                    count++;
                } else {
                    dq.addLast(dq.pollFirst());
                    count++;
                }
            }
            dq.pollFirst();
        }
        System.out.println(count);
    }
}
