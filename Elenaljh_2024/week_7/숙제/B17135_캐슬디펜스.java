package 숙제;
/*
캐슬 디펜스
 */
import java.util.*;
import java.io.*;
public class B17135_캐슬디펜스 {
    static int N, M, D, ATTACK, MAX = 0, ENEMY = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken()); //궁수 공격 거리 제한
        map = new int[N+1][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) ENEMY++;
            }
        }

        perm(0, 0);

        System.out.println(MAX);
    }

    static void perm(int count, int start) {
        if (count == 3) {
            //공격 시뮬레이션 -> ATTACK 갱신
            ATTACK = 0;
            int[][] newMap = copyMap();
            int tmp = ENEMY;
            while (ENEMY > 0) {
                List<Integer[]> attackedEnemy = new ArrayList<>();
                for (int i = 0; i < M; i++) {
                    if (newMap[N][i] == 1) attack(N, i, newMap, attackedEnemy);
                }
                kill(newMap, attackedEnemy);
                move(newMap);
            }
            MAX = Integer.max(MAX, ATTACK);
            ENEMY = tmp;
            return;
        }

        for (int i = start; i < M; i++) {
            map[N][i] = 1;
            perm(count+1, i+1);
            map[N][i] = 0;
        }
    }
    static void attack(int ax, int ay, int[][] map, List<Integer[]> attackedEnemy) {
        List<Integer[]> candidate = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                int distance = distance(i, j, ax, ay);
                if (map[i][j] == 1 && distance <= D) {
                    candidate.add(new Integer[]{i, j, distance});
                    min = Integer.min(distance, min);
                }
            }
        }
        for (int i = 0; i < candidate.size(); i++) {
            Integer[] enemy = candidate.get(i);
            if (enemy[2] == min) {
                attackedEnemy.add(new Integer[]{enemy[0], enemy[1]});
                return;
            }
        }
    }

    static void kill(int[][] map, List<Integer[]> attackedEnemy) {
        for (int i = 0; i < attackedEnemy.size(); i++) {
            Integer[] enemy = attackedEnemy.get(i);
            if (map[enemy[0]][enemy[1]] == 1) {
                map[enemy[0]][enemy[1]] = 0;
                ATTACK++; ENEMY--;
            }
        }
    }

    static void move(int[][] map) {
        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    if (i == N-1) {
                        map[i][j] = 0; ENEMY--;
                    } else {
                        map[i+1][j] = 1;
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    static int distance(int ex, int ey, int ax, int ay) { //enemy, archer
        return Math.abs(ex-ax) + Math.abs(ey-ay);
    }

    static int[][] copyMap() {
        int[][] copy = new int[N+1][M];
        for (int i = 0; i < N+1; i++) {
            copy[i] = map[i].clone();
        }
        return copy;
    }
}
