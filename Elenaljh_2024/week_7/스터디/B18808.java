package 스터디;

import java.io.*;
import java.util.*;
public class B18808 {
    static int N, M, K, R, C, laptop[][], sticker[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //노트북 세로
        M = Integer.parseInt(st.nextToken()); //노트북 가로
        laptop = new int[N][M];
        K = Integer.parseInt(st.nextToken()); //스티커 개수

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken()); //스티커 행
            C = Integer.parseInt(st.nextToken()); //스티커 열
            sticker = new int[R][C];
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());

                }
            }
            //남는 공간이 모자라면 돌린다. (총 4번)
            int rotateCounter = 0;
            Loop1:
            while (rotateCounter < 4) {
                for (int i = 0; i <= N-R; i++) {
                    for (int j = 0; j <= M-C; j++) {
                        if (check(i, j)) {
                            attachSticker(i, j);
                            break Loop1;
                        }
                    }
                }
                if (rotateCounter < 3) rotate();
                rotateCounter++;
            }

        }

        // 몇 개의 칸이 채워졌는지 구하기
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (laptop[i][j] == 1) count++;
            }
        }
        System.out.println(count);
    }

    //돌리는 함수
    static void rotate() {
        int[][] rotated = new int[C][R];
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                rotated[i][j] = sticker[R-1-j][i];
            }
        }
        sticker = rotated;
        int tmp = R; R = C; C = tmp;
    }

//    남는 공간 체크하는 함수
    static boolean check(int r, int c) {
        for (int i = r; i < r+R; i++) {
            for (int j = c; j < c+C; j++) {
                if (laptop[i][j] == 1 && sticker[i-r][j-c] == 1) return false;
            }
        }
        return true;
    }

    //스티커 붙이기
    static void attachSticker(int r, int c) {
        for (int i = r; i < r+R; i++) {
            for (int j = c; j < c+C; j++) {
                if (laptop[i][j] == 0 && sticker[i-r][j-c] == 1) {
                    laptop[i][j] = 1;
                }
            }
        }
    }
}
