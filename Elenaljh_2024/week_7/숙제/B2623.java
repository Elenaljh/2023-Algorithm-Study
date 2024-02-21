package 숙제;
/*
음악프로그램
 */

import java.util.*;
import java.io.*;
public class B2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList[] list = new ArrayList[n+1];
        int[] arr = new int[n+1];
        for (int i = 1; i < n+1; i++) list[i] = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int prev = -1;
            for (int j = 0; j < count-1; j++) {
                if (prev == -1) {
                    int first = Integer.parseInt(st.nextToken());
                    prev = Integer.parseInt(st.nextToken());
                    list[first].add(prev);
                    arr[prev]++;
                    continue;
                }
                int second = Integer.parseInt(st.nextToken());
                list[prev].add(second);
                arr[second]++;
                prev = second;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < n+1; i++) {
            if (arr[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append("\n");
            ArrayList<Integer> children = list[current];
            for (int i = 0; i < children.size(); i++) {
                arr[children.get(i)]--;
                if (arr[children.get(i)] == 0) {
                    q.add(children.get(i));
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            if (arr[i] != 0) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(sb);
    }
}
