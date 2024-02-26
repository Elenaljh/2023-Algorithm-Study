package 스터디;

import java.util.*;
import java.io.*;
public class SW4013_특이한자석 {
    /**
     * gears[] 설명
     * 빨간화살표방향: 각 행의 0열
     * 0번째 바퀴 2열 -> 1번째 바퀴 6열
     * 1번째 바퀴 2열 -> 2번째 바퀴 6열
     * 2번째 바퀴 2열 -> 3번째 바퀴 6열
     */
    static int[][] gears = new int[4][8];
    static int[] directions = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int T = 1; T <= testCase; T++) {
            int K = Integer.parseInt(br.readLine()); //돌리는 횟수
            //톱니바퀴 정보 입력 (0열이 빨간 화살표가 가리키는 자성 정보)
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    gears[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int gear = Integer.parseInt(st.nextToken())-1;
                int direction = Integer.parseInt(st.nextToken());

                //돌리는 방향 파악
                checkDirection(gear, direction);

                //기어 돌리기
                for (int g = 0; g < 4; g++) {
                    turn(g, directions[g]);
                }
            }

            //점수 계산
            int score = calScore();

            sb.append("#").append(T).append(" ").append(score).append("\n");
        }
        System.out.println(sb);
    }

    //direction: 1-시계방향, -1-반시계방향, 2-정지
    static void turn(int gear, int direction) {
        int redArrow = -1;
        if (direction == 1) {
            redArrow = gears[gear][7];
            for (int i = 7; i > 0; i--) {
                gears[gear][i] = gears[gear][i-1];
            }
            gears[gear][0] = redArrow;
        }
        if (direction == -1) {
            redArrow = gears[gear][0];
            for (int i = 0; i < 7; i++) {
                gears[gear][i] = gears[gear][i+1];
            }
            gears[gear][7] = redArrow;
        }
    }

    static void checkDirection(int gear, int direction) {
        //기준 기어 돌리기
        directions[gear] = direction;

        //기준 기어 왼쪽 돌리기
        int place = gear;
        while (true) {
            if (place == 0) break;
            int left = gears[place][6];
            int right = gears[place-1][2];
            if (left == right) {
                Arrays.fill(directions, 0, place, 2);
                break;
            }
            directions[place-1] = directions[place]>0 ? -1 : 1;
            place--;
        }

        //기준 기어 오른쪽 돌리기
        place = gear;
        while (true) {
            if (place == 3) break;
            int left = gears[place][2];
            int right = gears[place+1][6];
            if (left == right) {
                Arrays.fill(directions, place+1, 4, 2);
                break;
            }
            directions[place+1] = directions[place]>0 ? -1 : 1;
            place++;
        }
    }

    static int calScore() {
        int score = 0;
        int pole = -1;
        for (int i = 0; i < 4; i++) {
            pole = gears[i][0];
            score += pole == 0 ? 0 : (int)Math.pow(2, i);
        }
        return score;
    }
}
