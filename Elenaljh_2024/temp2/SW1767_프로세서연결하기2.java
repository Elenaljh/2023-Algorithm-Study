import java.io.*;
import java.util.*;
public class SW1767_프로세서연결하기2 {
    static class Processor {
        public int x, y;

        public Processor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, map[][], core, MAX, MIN, length;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static List<Processor> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1 && i != 0 && j != 0 && i != N-1 && j != N-1) {
                        list.add(new Processor(i, j));
                    }
                }
            }
            MAX = 0;
            MIN = Integer.MAX_VALUE;
            core = 0;
            length = 0;

            if (!list.isEmpty()) {
                perm(0);
            } else {
                MIN=0;
            }

            sb.append("#").append(test).append(" ").append(MIN).append("\n");
        }
        System.out.println(sb);
    }

    static void perm(int count) {
        if (count == list.size()) {
            if (core > MAX) {
                MAX = core;
                MIN = length;
            }
            if (core == MAX) {
                MIN = Integer.min(MIN, length);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            Processor p = list.get(count);
            if (check(p.x, p.y, i)) { //해당 좌표에서 해당 방향으로 칠할 수 있는지 검사
                core++;
                length += connect(p.x, p.y, i, 1);
                perm(count+1);
                length -= connect(p.x, p.y, i, 0);
                core--;
            }
        }
        perm(count+1);

    }

    static boolean check(int x, int y, int direction) {
        int nx = x + dx[direction];
        int ny = y + dy[direction];
        while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
            if (map[nx][ny] == 1) return false;
            nx += dx[direction];
            ny += dy[direction];
        }
        return true;
    }

    static int connect(int x, int y, int direction, int mode) {
        int count = 0;
        int nx = x + dx[direction];
        int ny = y + dy[direction];
        while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
            map[nx][ny] = mode;
            count++;
            nx += dx[direction];
            ny += dy[direction];
        }
        return count;
    }


}
