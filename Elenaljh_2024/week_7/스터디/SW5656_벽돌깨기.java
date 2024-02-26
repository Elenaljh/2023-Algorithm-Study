package 스터디;

import java.io.*;
import java.util.*;

public class SW5656_벽돌깨기 {
    static int N, W, H, MIN;
    static int[][] map;
    static int[] dx = new int[]{-1, 1, 0, 0}; //상하좌우
    static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //구슬 쏘는 횟수 (N <= 4)
            W = Integer.parseInt(st.nextToken()); //가로 길이 (열) -> 구슬 쏠 수 있는 장소 W개
            H = Integer.parseInt(st.nextToken()); //세로 길이 (행)
            MIN = Integer.MAX_VALUE;
            map = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dropMarbles(0, new int[N]);

            sb.append("#").append(testCase).append(" ").append(MIN).append("\n");
        }
        System.out.println(sb);
    }

    //구슬 어디에 떨어뜨릴건지 결정
    static void dropMarbles(int count, int[] selected) {
        if (count == N) {
            //맵 복사
            int[][] copiedMap = new int[H][W];
            for (int i = 0; i < H; i++) copiedMap[i] = map[i].clone();
            //벽돌파괴 시뮬레이션
            simulate(copiedMap, selected);
            //남은 벽돌 수 세기
            int numberOfBricks = count(copiedMap);
            //MIN 갱신
            MIN = Integer.min(MIN, numberOfBricks);
            return;
        }

        for (int i = 0; i < W; i++) {
            selected[count] = i;
            dropMarbles(count+1, selected);
        }
    }

    //벽돌파괴 시뮬레이션
    static int[][] simulate(int[][] map, int[] orders) {
        for (int target : orders) {
            int row = findBrick(target, map); //구슬 떨어뜨린 열의 최상단 벽돌의 행 좌표
            if (row == -1) continue; //-1 반환시 그 열에 아무것도 없으므로 pass
            //파괴
            int[][] destructedMap = destruct(row, target, map);
            //벽돌 이동
            map = move(destructedMap);
        }
        return map;
    }

    //구슬 떨어뜨린 열의 가장 위에 있는 벽돌의 행 좌표 반환, -1 반환시 아무것도 없다는 뜻
    static int findBrick(int col, int[][] map) {
        for (int i = 0; i < H; i++) {
            if (map[i][col] != 0) return i;
        }
        return -1;
    }

    //파괴 -> 연쇄효과 반영 -> bfs 사용
    static int[][] destruct(int row, int col, int[][] map) {
        boolean[][] visited = new boolean[H][W];
        Queue<Integer[]> q = new ArrayDeque<>(); //[행, 열]
        q.add(new Integer[]{row, col});
        visited[row][col] = true;

        while(!q.isEmpty()) {
            Integer[] now = q.poll();
            int number = map[now[0]][now[1]];

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < number; j++) {
                    int nx = now[0] + dx[i]*j;
                    int ny = now[1] + dy[i]*j;

                    if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                        if (!visited[nx][ny] && map[nx][ny] != 0) {
                            visited[nx][ny] = true;
                            q.add(new Integer[]{nx, ny});
                        }
                    }
                }
            }
        }

        //파괴된 부분(visited에 true로 표시된 부분) 0으로 바꾸기
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (visited[i][j]) map[i][j] = 0;
            }
        }

        //파괴 후 변경된 맵 리턴
        return map;
    }

    //벽돌 이동
    static int[][] move(int[][] map) {
        for (int col = 0; col < W; col++) {
            int current = H-1, top, topBrick;
            int currentBrick = map[current][col];
            Loop1:
            while (true) {
                while (currentBrick != 0) {
                    current--;
                    if (current < 0) break;
                    currentBrick = map[current][col];
                }
                top = current-1;
                if (top < 0) break;
                topBrick = map[top][col];
                while (topBrick == 0) {
                    if (top == 0) break Loop1;
                    top--;
                    topBrick = map[top][col];
                }
                map[current][col] = topBrick;
                map[top][col] = 0;
                currentBrick = topBrick;
            }
        }
        return map;
    }

    //남은 벽돌 수 세기
    static int count(int[][] map) {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] != 0) count++;
            }
        }
        return count;
    }

}
