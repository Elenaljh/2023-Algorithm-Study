package 숙제;

import java.io.*;
import java.util.*;
public class B3109_빵집 {
    static char[][] map;
    static int R, C, Pipe;
    static int[] dx = new int[]{-1, 0, 1}; //우상, 우, 우하
    static int[] dy = new int[]{1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            installPipe(i, 0);
        }

        System.out.println(Pipe);
    }

    static boolean installPipe(int row, int column) {
        if (column == C-1) {
            Pipe++;
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nx = row + dx[i];
            int ny = column + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (map[nx][ny] == '.') {
                    map[nx][ny] = '=';
                    if (installPipe(nx, ny)) return true;
                }
            }
        }
        return false;
    }
}
