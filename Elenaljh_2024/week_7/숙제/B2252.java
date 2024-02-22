package 숙제;
/*
줄 세우기(위상정렬)
 */

import java.io.*;
import java.util.*;
public class B2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList[] students = new ArrayList[n+1];
        int[] edgeCount = new int[n+1]; //진입차수 배열
        for (int i = 1; i < n+1; i++) students[i] = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            students[first].add(second);
            edgeCount[second]++;
        }

        //위상정렬에 사용할 큐
        Queue<Integer> q = new ArrayDeque<>();

        //진입차수가 0인 노드를 큐에 넣기
        for (int i = 1; i < n+1; i++) {
            if (edgeCount[i] == 0) {
                q.add(i);
            }
        }

        //큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int nodeNum = q.poll();
            sb.append(nodeNum).append(" ");
            List<Integer> list = students[nodeNum];
            for (int i = 0; i < list.size(); i++) {
                edgeCount[list.get(i)]--; //진입차수 제거
                if (edgeCount[list.get(i)]==0) {
                    q.add(list.get(i));
                }
            }
        }

        System.out.println(sb.toString().trim());

    }
}
