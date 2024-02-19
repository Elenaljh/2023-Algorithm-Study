package 스터디;

import java.io.*;
import java.util.*;
public class B12100 {
    static int N, map[][], directions[], MAX = 0;
    static int[] dx = new int[]{-1, 1, 0, 0}; //상, 하, 좌, 우
    static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        directions = new int[5];
        game(0);
        System.out.println(MAX);
    }

    static void game(int count) {
        if (count == 5) {
            //map 복사
            int[][] newMap = new int[N][N];
            for (int i = 0; i < N; i++) {
                newMap[i] = map[i].clone();
            }

            for (int i = 0; i < 5; i++) {
                merge(directions[i], newMap);
            }

            //최대값 찾기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    MAX = Integer.max(MAX, newMap[i][j]);
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            directions[count] = i;
            game(count+1);
        }
    }

    static void merge(int direction, int[][] map) {
        for (int i = 0; i < N; i++) {
            int origin_x, origin_y;
            if (direction == 1) { //하
                origin_x = 0; origin_y = i;
            } else if (direction == 2) { //좌
                origin_x = i; origin_y = N-1;
            } else if (direction == 0) { //상
                origin_x = N-1; origin_y = i;
            } else { //우
                origin_x = i; origin_y = 0;
            }
            int nx = origin_x, ny = origin_y;
            while (true) {
                nx = nx + dx[direction];
                ny = ny + dy[direction];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
                if (map[nx][ny] == 0) {
                    continue;
                } else if (map[nx][ny] == map[origin_x][origin_y]) {
                    map[nx][ny] = 0;
                    map[origin_x][origin_y] = map[origin_x][origin_y] * 2;
                    origin_x += dx[direction]; origin_y += dy[direction];
                } else if (map[origin_x][origin_y] == 0) {
                    map[origin_x][origin_y] = map[nx][ny];
                    map[nx][ny] = 0;
                } else if (map[origin_x+dx[direction]][origin_y+dy[direction]] == 0) {
                    origin_x += dx[direction]; origin_y += dy[direction];
                    map[origin_x][origin_y] = map[nx][ny];
                    map[nx][ny] = 0;
                } else {
                    origin_x += dx[direction]; origin_y += dy[direction];
                }
            }

            }
        }
    }

