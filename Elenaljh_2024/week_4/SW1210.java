import java.io.*;
import java.util.*;

public class SW1210 {
    public static void main(String[] args) throws IOException {
        int WIDTH = 100; //원래는 100
        int TESTCASE = 10; //테스트케이스 원래는 10
        int[][] map = new int[WIDTH][WIDTH];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TESTCASE; t++) {
            sb.append("#").append(br.readLine()).append(" "); //테스트케이스 번호
            int x = 0;
            int y = WIDTH-1;


            //맵 입력
            for (int i = 0; i < WIDTH; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < WIDTH; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (i == WIDTH-1 && map[i][j]==2) {
                        x = j;
                    }
                }
            }
            boolean left = false, right = false;
            //좌우로 왔다갔다 하는 문제 해결해야 함
            //출발점으로 거슬러 올라가기
            while (y != 0) {
                if (x-1 >= 0 && map[y][x-1] == 1 && !right) {
                    x--;
                    left = true;
                } else if (x+1 < WIDTH && map[y][x+1] == 1 && !left) {
                    x++;
                    right = true;
                } else if (y-1 >= 0 && map[y-1][x] == 1) {
                    y--;
                    left = false;
                    right = false;
                }
            }
            sb.append(x).append("\n");

        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
