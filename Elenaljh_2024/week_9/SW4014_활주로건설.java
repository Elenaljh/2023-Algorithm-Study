import java.io.*;
import java.util.*;
public class SW4014_활주로건설 {
    static int N, X, MAX;
    static int[][] map;
    static int[] dx = new int[]{0, 1}; //우, 하
    static int[] dy = new int[]{1, 0};
    static final int row = 0, col = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            MAX = 0;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                if (checkRowCol(row, i)) answer++;
                if (checkRowCol(col, i)) answer++;
            }

            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }


    static boolean checkRowCol(int direction, int num) {//direction: row, col중 하나, num: 몇번째 row/col인지
        //해당 행/열의 첫번째값 좌표
        int x, y;
        if (direction == row) {
            x = num; y = 0;
        } else {
            x = 0; y = num;
        }

        //해당 행/열 검사하기
        boolean construct = false;
        int current = map[x][y];
        int count = 1;
        x += dx[direction]; y += dy[direction];

        while(x < N && y < N) {
            if (current == map[x][y]) { //평지
                if (!construct) {
                    count++;
                } else { //우하향 경사로 건설해야 함
                    if (count == X) {
                        construct = false;
                        count = 1;
                    } else {
                        count++;
                    }
                }
            }
            else if (current > map[x][y]) { //아래방향 경사 만남
                if (current - map[x][y] >= 2) return false; //단차가 2 이상이면 건설 불가
                if (!construct) { //딱히 전에 우하향 경사로를 지어야하지 않았다면
                    construct = true; //이제부터 경사로 지을 부지 확보해야 함
                    current = map[x][y];
                    count = 1;
                } else { //전에 경사로를 지어야 하는 상황이었다면
                    if (count >= X) {
                        current = map[x][y];
                        count = 1;
                    } else {
                        return false;
                    }
                }
            }
            else if (current < map[x][y]) { //위쪽방향 경사 만남
                if (map[x][y] - current >= 2) return false;
                if (construct) return false; //아래방향 경사 지어야하는데 위쪽경사 만남
                if (count < X) return false; //위쪽 경사 짓기 충분치 않음
                current = map[x][y];
                count = 1;
            }

            //포인터 좌표 변경
            x += dx[direction]; y += dy[direction];
        }

        if (construct && count < X) return false;

        return true;
    }
}
