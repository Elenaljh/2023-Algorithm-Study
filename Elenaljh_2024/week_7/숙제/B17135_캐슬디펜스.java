package 숙제;
/*
캐슬 디펜스
 */
import java.util.*;
import java.io.*;
public class  B17135_캐슬디펜스 {
    static int[][] map;
    static int N, M, D, ENEMY = 0, COUNT = 0, MAX = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N+1][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) ENEMY++;
            }
        }

        game(0, 0);

        System.out.println(MAX);

    }

    static int calcDistance(int ex, int ey, int ax, int ay) {
        return Math.abs(ex-ax) + Math.abs(ey-ay);
    }

    static void game(int count, int start) {
        if (count == 3) {
            int tmp = ENEMY;
            //0. 맵 복사
            int[][] copyMap = copyMap();
            COUNT = 0;
            while (ENEMY > 0) {
                //1. 궁수가 죽일 적 정하기
                List<Integer[]> enemies = new ArrayList<>();
                for (int i = 0; i < M; i++) {
                    if (map[N][i] == 1) {
                        selectTarget(N, i, enemies, copyMap);
                    }
                }
                //2. 죽이기
                kill(copyMap, enemies);
                //3. 적 한 칸 앞으로 옮기기
                move(copyMap);
            }
            MAX = Integer.max(MAX, COUNT);
            ENEMY = tmp;
            return;
        }

        for (int i = start; i < M; i++) {
            map[N][i] = 1;
            game(count+1, i+1);
            map[N][i] = 0;
        }
    }

    static int[][] copyMap() {
        int[][] copy = new int[N+1][M];
        for (int i = 0; i < N+1; i++) {
            copy[i] = map[i].clone();
        }
        return copy;
    }

    static void selectTarget(int ax, int ay, List<Integer[]> list, int[][] map) {
        int minDist = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;
                int distance = calcDistance(i, j, ax, ay);
                if (distance <= D && distance < minDist) {
                    minDist = distance;
                    minX = i; minY = j;
                } else if (distance == minDist && j < minY) {
                    minX = i; minY = j;
                }
            }
        }
        if (minDist != Integer.MAX_VALUE) {
            list.add(new Integer[]{minX, minY});
        }
    }

    static void kill(int[][] map, List<Integer[]> list) {
        for (Integer[] enemy : list) {
            int x = enemy[0]; int y = enemy[1];
            if (map[x][y] == 1) {
                map[x][y] = 0;
                ENEMY--; COUNT++;
            }
        }
    }

    static void move(int[][] map) {
        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    if (i == N-1) {
                        ENEMY--;
                        map[i][j] = 0;
                        continue;
                    }
                    map[i][j] = 0;
                    map[i+1][j] = 1;
                }
            }
        }
    }
}
