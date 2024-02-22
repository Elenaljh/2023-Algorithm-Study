package 숙제;

import java.io.*;
import java.util.*;

public class B17471_게리맨더링 {
    static int N, MIN = -1, numberOfPeople[];
    static boolean[] visited;
    static ArrayList<Integer>[] areas;
    public static void main(String[] args) throws IOException {
        //전처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); //구역의 수
        areas = new ArrayList[N+1]; //지역
        visited = new boolean[N+1]; //방문여부
        numberOfPeople = new int[N+1]; //지역 인구 수
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) numberOfPeople[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N+1; i++) areas[i] = new ArrayList<>();
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int rpt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < rpt; j++) {
                int neighbor = Integer.parseInt(st.nextToken());
                areas[i].add(neighbor); //이웃구역 저장
            }
        }

        divide(0);

        System.out.println(MIN);
    }

    static void divide(int count) {
        if (count == N) {
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();

            for (int i = 1; i < N+1; i++) {
                if (visited[i]) aList.add(i); //true인 경우
                else bList.add(i); //false인 경우
            }

            if (aList.size() == 0 || bList.size() == 0) return; //공집합, 전집합 방지

            //bfs 로직
            if (check(aList) && check(bList)) {
                int popDiff = calPopDiff();
                MIN = MIN==-1 ? popDiff : Integer.min(MIN, popDiff);
            }

            return;
        }

        //부분집합 만들기
        visited[count] = true;
        divide(count+1);
        visited[count] = false;
        divide(count+1);
    }

    //각 구역이 모두 이어져있는지 검사 (bfs)
    static boolean check(List<Integer> list) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] selected = new boolean[N+1];

        q.add(list.get(0));
        selected[list.get(0)] = true;

        int count = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            ArrayList<Integer> neighbors = areas[now];
            for (int i = 0; i < neighbors.size(); i++) {
                if (!selected[neighbors.get(i)] && list.contains(neighbors.get(i))) {
                    q.add(neighbors.get(i));
                    selected[neighbors.get(i)] = true;
                    count++;
                }
            }
        }

        if (count == list.size()) return true;
        else return false;
    }

    //인구차이 계산
    static int calPopDiff() {
        int cnt = 0;
        for (int i = 1; i < N+1; i++) {
            if (visited[i]) {
                cnt += numberOfPeople[i];
            } else {
                cnt -= numberOfPeople[i];
            }
        }
        return Math.abs(cnt);
    }

}
