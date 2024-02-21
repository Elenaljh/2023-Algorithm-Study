package 숙제;
/*
촌수계산
https://www.acmicpc.net/problem/2644
 */

import java.util.*;
import java.io.*;
public class B2644 {
    static int kin = -1;
    static Node[] family;
    static boolean[] visited;
    static class Node {
        int to;
        Node next;

        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); //사람 수
        family = new Node[n+1];
        visited = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine()); //관계 수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            family[parent] = new Node(child, family[parent]);
            family[child] = new Node(parent, family[child]);
        }

        find(0, p1, p2);
        System.out.println(kin);
    }

    static void find(int depth, int p1, int p2) {
        if (p1 == p2) {
            kin = depth;
            return;
        }

        visited[p1] = true;
        for (Node tmp = family[p1]; tmp != null; tmp = tmp.next) {
            if (!visited[tmp.to]) {
                find(depth+1, tmp.to, p2);
            }
//            visited[p1] = false;
        }
    }
}
