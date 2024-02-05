package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
불이나 다시 풀고 와라ㅋㅋ
 */
public class B5427 {
    static int w, h;
    static char[][] map;
    static int[][] man, fire;
    static Queue<Integer[]> fireQ = new LinkedList<>();
    static Queue<Integer[]> manQ = new LinkedList<>();
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int T = 0; T < t; T++) {
            //너비와 높이
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); //열
            h = Integer.parseInt(st.nextToken()); //행
            map = new char[h][w];
            man = new int[h][w];
            fire = new int[h][w];

            //맵 기록
            for (int i = 0; i < h; i++) {
                Arrays.fill(man[i], -1);
                Arrays.fill(fire[i], Integer.MAX_VALUE);
            }
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = line.charAt(j);
                    map[i][j] = c;
                    if (c == '*') {
                        fire[i][j] = 0;
                        fireQ.add(new Integer[]{i, j});
                    }
                    if (c == '@') {
                        man[i][j] = 0;
                        manQ.add(new Integer[]{i, j});
                    }
                }
            }

            //bfs 돌리기
            firebfs();
            manbfs();
        }
        System.out.println(sb);
    }

    static void firebfs() {
        while (!fireQ.isEmpty()) {
            Integer[] now = fireQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    if (fire[nx][ny] == Integer.MAX_VALUE && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
                        fireQ.add(new Integer[]{nx, ny});
                        fire[nx][ny] = fire[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }

    static void manbfs() {
        while(!manQ.isEmpty()) {
            Integer[] now = manQ.poll();
            if (now[0] == 0 || now[1] == 0 || now[0] == h-1 || now[1] == w-1) {
                if (man[now[0]][now[1]] < fire[now[0]][now[1]]) {
                    sb.append(man[now[0]][now[1]]+1).append("\n");
                    return;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    if (man[nx][ny] == -1 && map[nx][ny] == '.' && (fire[nx][ny] > man[nx][ny])) {
                        manQ.add(new Integer[]{nx, ny});
                        man[nx][ny] = man[now[0]][now[1]] + 1;
                    }
                }
            }
        }
        sb.append("IMPOSSIBLE").append("\n");
    }
}
