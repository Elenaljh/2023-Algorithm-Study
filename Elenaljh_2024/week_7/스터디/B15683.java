package 스터디;

import java.io.*;
import java.util.*;

public class B15683 {
    static int N, M, MIN = Integer.MAX_VALUE;
    static int[][] MAP;
    static boolean[][] watched;
    static List<Camera> cameras = new ArrayList<>();
    static List<Integer[]> five = new ArrayList<>();
    //상: 0, 하: 1, 우: 2, 좌: 3
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[][][] order = new int[][][] { //앞 인덱스는 cctv 번호-1, 뒤 인덱스는 cctv 돌리는 방향
            {{0}, {1}, {2}, {3}}, //1번
            {{0, 1}, {2, 3}}, //2번
            {{0, 2}, {1, 3}, {1, 2}, {3, 0}}, //3번
            {{0, 3, 1}, {2, 1, 3}, {1, 2, 0}, {3, 0, 2}}, //4번
            {{0, 1, 2, 3}} //5번
    };

    static class Camera {
        public int x, y, type;
        public int[] direction;
        public Camera(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
        public void setDirection(int[] direction) {
            this.direction = direction;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAP = new int[N][M];
        watched = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
                if (MAP[i][j] >= 1 && MAP[i][j] <= 4) {
                    cameras.add(new Camera(i, j, MAP[i][j]));
                    watched[i][j] = true;
                }
                if (MAP[i][j] == 6) watched[i][j] = true;
                if (MAP[i][j] == 5) {
                    watched[i][j] = true;
                    five.add(new Integer[]{i, j});
                }
            }
        }
        for (Integer[] arr : five) {
            for (int direction = 0; direction < 4; direction++) {
                int nx = arr[0] + dx[direction];
                int ny = arr[1] + dy[direction];
                while (true) {
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;
                    if (MAP[nx][ny] == 6) break;
                    if (!watched[nx][ny]) {
                        watched[nx][ny] = true;
                    }
                    nx += dx[direction]; ny += dy[direction];
                }
            }
        }


        //dfs? 백트래킹?
        calculateArea(0);
        System.out.println(MIN);
    }

    static void calculateArea(int count) {
        if (count == cameras.size()) {
            //배열 복사, area 복사
            boolean[][] watchedCopy = new boolean[N][M];
            for (int i = 0; i < N; i++) watchedCopy[i] = watched[i].clone();

            //함수 실행
            for (int i = 0; i < cameras.size(); i++) {
                Camera camera = cameras.get(i);
                int x = camera.x; int y = camera.y;
                for (int j = 0; j < camera.direction.length; j++) {
                    int direction = camera.direction[j];

                    int nx = x + dx[direction];
                    int ny = y + dy[direction];
                    while (true) {
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;
                        if (MAP[nx][ny] == 6) break;
                        if (!watchedCopy[nx][ny]) {
                            watchedCopy[nx][ny] = true;
                        }
                        nx += dx[direction]; ny += dy[direction];
                    }
                }
            }

            //주석
//            for (Camera camera : cameras) {
//                System.out.print("(" + camera.x + ", " + camera.y + ") " + Arrays.toString(camera.direction) + " / ");
//            }
            int area = 0;
            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(watchedCopy[i])); //디버깅
                for (int j = 0; j < M; j++) {
                    if (!watchedCopy[i][j]) area++;
                }
            }
//            System.out.println("area: " + area);
//            System.out.println(); //디버깅
            MIN = Integer.min(MIN, area);
            return;
        }

        //로직
        int cameraType = cameras.get(count).type - 1;
        for (int turn = 0; turn < order[cameraType].length; turn++) {
            cameras.get(count).setDirection(order[cameraType][turn]);
            calculateArea(count+1);
        }

    }

}
