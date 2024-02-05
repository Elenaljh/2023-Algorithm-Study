package BFS;

import java.io.*;
import java.util.*;
public class B5427_1 {
    static int r, c, jx, jy, fx, fy, exitTime;
    static char[][] map;
    static int[][] fire, jihun;
    static Queue<Integer[]> fireQ = new LinkedList<>();
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int k = 0; k < t; k++) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            map = new char[r][c];
            fire = new int[r][c];
            jihun = new int[r][c];

            for (int i = 0; i < r; i++) {
                Arrays.fill(fire[i], Integer.MAX_VALUE);
                Arrays.fill(jihun[i], -1);
            }

            //map, fire, jihun 입력
            for (int i = 0; i < r; i++) {
                String str = br.readLine();
                for (int j = 0; j < c; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '@') {
                        jx = i;
                        jy = j;
                    }
                    if (map[i][j] == '*') {
                        fireQ.add(new Integer[]{i, j});
                        fire[i][j] = 0;
                    }
                }
            }

            //불, 지훈 bfs
            fireBfs();
            int time = jihunBfs();

            //출력
            if (time == -1) {
                sb.append("IMPOSSIBLE").append("\n");
            } else {
                sb.append(exitTime+1).append("\n");
            }

        }
        System.out.println(sb);
    }

    static void fireBfs() {

        while (!fireQ.isEmpty()) {
            Integer[] now = fireQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (fire[nx][ny] == Integer.MAX_VALUE && (map[nx][ny] == '.' || map[nx][ny] == 'J')) {
                        fireQ.add(new Integer[]{nx, ny});
                        fire[nx][ny] = fire[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }

    static int jihunBfs() {
        boolean survive = false;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{jx, jy});
        jihun[jx][jy] = 0;
        exitTime = 0;

        if (jx == 0 || jy == 0 || jx == r-1 || jy == c-1) {
            return exitTime;
        }

        Loop1:
        while (!q.isEmpty()) {
            Integer[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (jihun[nx][ny] == -1 && map[nx][ny] == '.') {
                        if (jihun[now[0]][now[1]] + 1 < fire[nx][ny]) {
                            q.add(new Integer[]{nx, ny});
                            jihun[nx][ny] = jihun[now[0]][now[1]] + 1;
                            exitTime = jihun[now[0]][now[1]] + 1;
                        } else {
                            jihun[nx][ny] = Integer.MAX_VALUE;
                        }
                        if ((nx == 0 || ny == 0 || nx == r-1 || ny == c-1) && map[nx][ny] == '.' && fire[nx][ny] > jihun[nx][ny]) {
                            survive = true;
                            break Loop1;
                        }
                    }
                }
            }
        }
        if (survive) {
            return exitTime;
        } else {
            return -1;
        }
    }
}
