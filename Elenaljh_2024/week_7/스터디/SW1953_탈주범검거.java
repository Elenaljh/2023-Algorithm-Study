package 스터디;

import java.io.*;
import java.util.*;
public class SW1953_탈주범검거 {
    static int N, M, R, C, L, COUNT = 1;
    static int[][] map, visited;
    static int[] dx = new int[]{-1, 1, 0, 0}; //상하좌우
    static int[] dy = new int[]{0, 0, -1, 1};
    static Queue<Integer[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken()); //맨홀뚜껑 위치한 행
            C = Integer.parseInt(st.nextToken()); //맨홀뚜껑 열
            L = Integer.parseInt(st.nextToken()); //탈출 후 경과시간
            map = new int[N][M];
            visited = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            COUNT = 1;
            q.add(new Integer[]{R, C});
            visited[R][C] = 1;
            bfs();

            sb.append("#").append(testCase).append(" ").append(COUNT).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Integer[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (visited[nx][ny] == 0 && checkType(now, i)) {
                        visited[nx][ny] = visited[now[0]][now[1]] + 1;
                        if (visited[nx][ny] > L) {
                            q.clear();
                            return;
                        }
                        q.add(new Integer[]{nx, ny});
                        COUNT++;
                    }
                }
            }
        }
    }

    static boolean checkType(Integer[] now, int direction) {
        int current = map[now[0]][now[1]];
        int nx = now[0] + dx[direction];
        int ny = now[1] + dy[direction];
        int next = map[nx][ny];
        if (current == 1) {
            if (direction == 0) {
                if (next == 1 || next == 2 || next == 5 || next == 6) return true;
            }
            if (direction == 1) {
                if (next == 1 || next == 4 || next == 7 || next == 2) return true;
            }
            if (direction == 2) {
                if (next == 1 || next == 3 || next == 4 || next == 5) return true;
            }
            if (direction == 3) {
                if (next == 1 || next == 3 || next == 6 || next == 7) return true;
            }
        }
        if (current == 2) {
            if (direction == 0) {
                if (next == 1 || next == 2 || next == 5 || next == 6) return true;
            }
            if (direction == 1) {
                if (next == 1 || next == 4 || next == 7 || next == 2) return true;
            }
        }
        if (current == 3) {
            if (direction == 2) {
                if (next == 1 || next == 3 || next == 4 || next == 5) return true;
            }
            if (direction == 3) {
                if (next == 1 || next == 3 || next == 6 || next == 7) return true;
            }
        }
        if (current == 4) {
            if (direction == 0) {
                if (next == 1 || next == 2 || next == 5 || next == 6) return true;
            }
            if (direction == 3) {
                if (next == 1 || next == 3 || next == 6 || next == 7) return true;
            }
        }
        if (current == 5) {
            if (direction == 3) {
                if (next == 1 || next == 3 || next == 6 || next == 7) return true;
            }
            if (direction == 1) {
                if (next == 1 || next == 4 || next == 7 || next == 2) return true;
            }
        }
        if (current == 6) {
            if (direction == 2) {
                if (next == 1 || next == 3 || next == 4 || next == 5) return true;
            }
            if (direction == 1) {
                if (next == 1 || next == 4 || next == 7 || next == 2) return true;
            }
        }
        if (current == 7) {
            if (direction == 0) {
                if (next == 1 || next == 2 || next == 5 || next == 6) return true;
            }
            if (direction == 2) {
                if (next == 1 || next == 3 || next == 4 || next == 5) return true;
            }
        }
        return false;
    }


}
