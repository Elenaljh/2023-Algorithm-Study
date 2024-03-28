import java.io.*;
import java.util.*;
public class B3055_탈출 {
    static int r, c, Dr, Dc;
    static char[][] map;
    static int[][] Gtime, Wtime;
    static Queue<Integer[]> Gq = new ArrayDeque<>(), Wq = new ArrayDeque<>();
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        Gtime = new int[r][c]; Wtime = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(Gtime[i], -1);
            Arrays.fill(Wtime[i], -1);
        }

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    Gq.add(new Integer[]{i, j, 0}); //좌표, 시간
                    Gtime[i][j] = 0;
                } else if (map[i][j] == '*') {
                    Wq.add(new Integer[]{i, j, 0});
                    Wtime[i][j] = 0;
                } else if (map[i][j] == 'D') {
                    Dr = i; Dc = j;
                }
            }
        }

        int time = bfs();
        if (time == -1) {
            System.out.println("KAKTUS");
            return;
        }
        System.out.println(time);
    }

    //탈출 불가능할 때 : -1 반환
    static int bfs() {
        int result = 0;
        while (!Gq.isEmpty()) {
            while (!Wq.isEmpty() && Wq.peek()[2] == result) {
                Integer[] now = Wq.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                        if (Wtime[nx][ny] == -1 && map[nx][ny] != 'X' && map[nx][ny] != 'D') {
                            Wtime[nx][ny] = now[2] + 1;
                            Wq.add(new Integer[]{nx, ny, now[2]+1});
                            map[nx][ny] = '*';
                        }
                    }
                }
            }
            while (!Gq.isEmpty() && Gq.peek()[2] == result) {
                Integer[] now = Gq.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                        if (Gtime[nx][ny] == -1 && (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
                            Gtime[nx][ny] = now[2] + 1;
                            Gq.add(new Integer[]{nx, ny, now[2]+1});
                        }
                    }
                }
            }
            result++;
        }
        return Gtime[Dr][Dc];
    }
}
