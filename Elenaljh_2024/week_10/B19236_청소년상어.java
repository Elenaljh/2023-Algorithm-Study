import java.io.*;
import java.util.*;
public class B19236_청소년상어 {
    static int[][] number, direction;
    static int sharkX, sharkY;
    static int[] dx = new int[]{0, -1, -1, 0, 1, 1, 1, 0, -1}; //반시계방향
    static int[] dy = new int[]{0, 0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        number = new int[4][4];
        direction = new int[4][4];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                number[i][j] = Integer.parseInt(st.nextToken());
                direction[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //상어가 공간에 들어온다!
        shark(0, 0);

        //

    }

    static void shark(int x, int y) {
        sharkX = x; sharkY = y;
        number[x][y] = 0;
    }

    static void swap(int num) {
        //물고기 위치 구하기

    }
}
