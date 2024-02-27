package 스터디;

import java.io.*;
import java.util.*;

public class B3197_백조의호수 {

    static int R, C, GROUND, GX, GY;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] visitedPerson;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    static Deque<Integer[]> q = new ArrayDeque<>();
    static Deque<Integer[]> person = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        visitedPerson = new boolean[R][C];
        GROUND = 0;
        int pX = 0, pY = 0;


        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'L') {
                    pX = i; pY = j;
                }
                if (map[i][j] == '.' || map[i][j] == 'L') {
                    q.add(new Integer[]{i, j});
                    visited[i][j] = true;
                    GROUND++;
                }
            }
        }
        person.add(new Integer[] {pX, pY});
        visitedPerson[pX][pY] = true;

        boolean found = false;
        int time = 0;

        while (!found) {
            melt();
            GROUND = q.size();
            time++;
            found = meet();
        }

        System.out.println(time);


    }

    static void melt() {
        while (GROUND > 0) {
            Integer[] now = q.poll();
            GROUND--;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (!visited[nx][ny] && map[nx][ny] == 'X') {
                        map[nx][ny] = '.';
                        visited[nx][ny] = true;
                        q.add(new Integer[]{nx, ny});
                    }
                }
            }
        }
    }


    static boolean meet() {
        while (map[person.peek()[0]][person.peek()[1]] != 'X') {
            Integer[] now = person.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (map[nx][ny] == 'X' && !visitedPerson[nx][ny]) {
                        person.add(new Integer[] {nx, ny});
                        visitedPerson[nx][ny] = true;
                    }
                    if (!visitedPerson[nx][ny] && map[nx][ny] == '.') {
                        visitedPerson[nx][ny] = true;
                        person.addFirst(new Integer[] {nx, ny});
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
