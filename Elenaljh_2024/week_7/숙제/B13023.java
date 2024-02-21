package 숙제;

import java.io.*;
import java.util.*;
public class B13023 {
    static boolean exist;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //사람 수
        int m = Integer.parseInt(st.nextToken()); //친구 관계 수
        Node[] people = new Node[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            people[first] = new Node(second, people[first]);
            people[second] = new Node(first, people[second]);
        }

        for (int i = 0; i < n; i++) {
            exist = false;
            find(i, people, new boolean[n], 1);
            if (exist) break;
        }
        if (exist) System.out.println(1);
        else System.out.println(0);
    }

    static void find(int current, Node[] people, boolean[] visited, int depth) {
        if (depth == 5) {
            exist = true;
            return;
        }
        visited[current] = true;
        for (Node temp = people[current]; temp != null; temp = temp.next) {
            if (!visited[temp.to]) {
                find(temp.to, people, visited, depth+1);
            }
        }
        visited[current] = false;
    }

}
