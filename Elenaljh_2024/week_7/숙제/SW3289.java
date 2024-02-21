package 숙제;
/*
서로소집합
 */
import java.io.*;
import java.util.*;
public class SW3289 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test = 1; test <= T; test++) {
            sb.append("#").append(test).append(" ");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); //입력으로 주어지는 연산의 개수
            //0 a b : 합집합
            //1 a b : 같은 집합에 포함되어있는지 확인
            parent = new int[n+1];
            makeSet(n);
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                switch (command) {
                    case 0:
                        union(first, second);
                        break;
                    case 1:
                        if (find(first) == find(second)) {
                            sb.append(1);
                        } else {
                            sb.append(0);
                        }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); //경로 압축
    }

    private static void makeSet(int n) {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

}
