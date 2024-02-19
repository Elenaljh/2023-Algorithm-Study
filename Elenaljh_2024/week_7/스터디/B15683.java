package 스터디;

import java.io.*;
import java.util.*;

public class B15683 {
    static int N, M, MIN = Integer.MAX_VALUE;
    static int[][] MAP;
    static List<Camera> cameras = new ArrayList<>();
    //상: 0, 하: 1, 우: 2, 좌: 3
    static int[][][] order = new int[][][] { //앞 인덱스는 cctv 번호-1, 뒤 인덱스는 cctv 돌리는 방향
            {{0}, {1}, {2}, {3}}, //1번
            {{0, 1}, {2, 3}}, //2번
            {{0, 2}, {1, 3}}, //3번
            {{0, 3, 1}, {2, 1, 3}, {1, 2, 0}, {3, 0, 2}}, //4번
            {{0, 1, 2, 3}} //5번
    };

    static class Camera {
        public int x, y, type;

        public Camera(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAP = new int[N][M];
        int area = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
                if (MAP[i][j] == 1 || MAP[i][j] == 2 || MAP[i][j] == 3 || MAP[i][j] == 4 || MAP[i][j] == 5) {
                    cameras.add(new Camera(i, j, MAP[i][j]));
                }
                if (MAP[i][j] == 0) area++;
            }
        }

        //dfs? 백트래킹?
        calculateArea(0, area, MAP);
        System.out.println(MIN);
    }

    static void calculateArea(int count, int area, int[][] map) {
        if (count == cameras.size()) {
            MIN = Integer.min(MIN, area);
            return;
        }
        //배열 복사, area 복사
        int[][] copiedMap = new int[N][M];
        for (int i = 0; i < N; i++) copiedMap[i] = map[i].clone();


        //로직
        for (int i = count; i < cameras.size(); i++) {
            int cameraType = cameras.get(i).type - 1;
            int x = cameras.get(i).x; int y = cameras.get(i).y;
            for (int turn = 0; turn < order[cameraType].length; turn++) {
                int watched = 0;
                for (int direction = 0; direction < order[cameraType][turn].length; direction++) {
                    watched += execute(order[cameraType][turn][direction], x, y, copiedMap);
                }
                calculateArea(count+1, area-watched, copiedMap);
            }
        }
    }

    static int up(int x, int y, int[][] map) {
        int area = 0;
        if (x-1 < 0) return 0;
        for (int i = 1; x-i >= 0; i++) {
            if (map[x-i][y] == 6) return area;
            if (map[x-i][y] == 1 || map[i][y] == 2 || map[i][y] == 3 || map[i][y] == 4 || map[i][y] == 5) continue;
            if (map[x-i][y] == 0) {
                map[x-i][y] = -1;
                area++;
            }
        }
        return area;
    }

    static int down(int x, int y, int[][] map) {
        int area = 0;
        if (x+1 >= N) return 0;
        for (int i = 1; x+i < N; i++) {
            if (map[x+i][y] == 6) return area;
            if (map[x+i][y] == 1 || map[i][y] == 2 || map[i][y] == 3 || map[i][y] == 4 || map[i][y] == 5) continue;
            if (map[x+i][y] == 0) {
                map[x+i][y] = -1;
                area++;
            }
        }
        return area;
    }

    static int right(int x, int y, int[][] map) {
        int area = 0;
        if (y+1 >= M) return 0;
        for (int i = 1; y+i < M; i++) {
            if (map[x][y+i] == 6) return area;
            if (map[x][y+i] == 1 || map[x][i] == 2 || map[x][i] == 3 || map[x][i] == 4 || map[x][i] == 5) continue;
            if (map[x][y+i] == 0) {
                map[x][y+i] = -1;
                area++;
            }
        }
        return area;
    }

    static int left(int x, int y, int[][] map) {
        int area = 0;
        if (y-1 < 0) return 0;
        for (int i = 1; y-i >= 0; i++) {
            if (map[x][y-i] == 6) return area;
            if (map[x][y-i] == 1 || map[x][i] == 2 || map[x][i] == 3 || map[x][i] == 4 || map[x][i] == 5) continue;
            if (map[x][y-i] == 0) {
                map[x][y-i] = -1;
                area++;
            }
        }
        return area;
    }

    static int execute(int index, int x, int y, int[][] map) {
        switch (index) {
            case 0:
                return up(x, y, map);
            case 1:
                return down(x, y, map);
            case 2:
                return right(x, y, map);
            case 3:
                return left(x, y, map);
            default:
                return 0;
        }
    }
}
