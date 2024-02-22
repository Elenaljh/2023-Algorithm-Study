package 숙제;
/*
Contact
 */
import java.io.*;
import java.util.*;
public class SW1238_Contact {
    static int LastCall;
    static int[] visited;
    static ArrayList<Integer>[] people;
    static int testCase = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int T = 1; T <= testCase; T++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //입력받는 데이터 길이
            int start = Integer.parseInt(st.nextToken()); //연락 시작점

            people = new ArrayList[101];
            visited = new int[101];
            Arrays.fill(visited, -1);
            for (int i = 1; i < 101; i++) people[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n/2; i++) {
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                if (!people[first].contains(second)) people[first].add(second);
            }

            LastCall = 0;
            bfs(start);

            int answer = 0;
            for (int i = 1; i < 101; i++) {
                if (visited[i] == LastCall) answer = Integer.max(answer, i);
            }

            sb.append("#").append(T).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = 0;

        while (!q.isEmpty()) {
            int prev = q.poll();
            for (int i = 0; i < people[prev].size(); i++) {
                int following = people[prev].get(i);
                if (visited[following] == -1) {
                    visited[following] = visited[prev] + 1;
                    q.add(following);
                    LastCall = Integer.max(LastCall, visited[following]);
                }
            }
        }
    }
}
