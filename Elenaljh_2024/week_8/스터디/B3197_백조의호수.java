package 스터디;

import java.io.*;
import java.util.*;

public class B3197_백조의호수 {

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] visitedPerson;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    static Queue<Integer[]> q = new ArrayDeque<>();
    static Queue<Integer[]> person = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];


        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean found = false;
        int time = 0;

        while (!found) {
            visited = new boolean[R][C];
            visitedPerson = new boolean[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 'L' && person.isEmpty()) {
                        person.add(new Integer[] {i, j});
                        visitedPerson[i][j] = true;
                    }
                    if (map[i][j] == '.') {
                        q.add(new Integer[] {i, j});
                        visited[i][j] = true;
                    }
                }
            }

            melt();
            time++;
            found = meet();
        }

        System.out.println(time);


    }

    static void melt() {
        while (!q.isEmpty()) {
            Integer[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (!visited[nx][ny] && map[nx][ny] == 'X') {
                        map[nx][ny] = '.';
                    }
                }
            }
        }
    }


    static boolean meet() {
        while (!person.isEmpty()) {
            Integer[] now = person.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (!visitedPerson[nx][ny] && map[nx][ny] == '.') {
                        visitedPerson[nx][ny] = true;
                        person.add(new Integer[] {nx, ny});
                    }
                    if (!visitedPerson[nx][ny] && map[nx][ny] == 'L') {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
