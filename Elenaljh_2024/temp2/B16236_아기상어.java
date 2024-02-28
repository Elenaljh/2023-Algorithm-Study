import java.io.*;
import java.util.*;
public class B16236_아기상어 {
    static int N, map[][], shark[], count;
    static final int X = 0, Y = 1, size = 2;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        count = 0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) shark = new int[]{i, j, 2}; //x, y, 무게 저장
            }
        }




    }

    static int distance(int x, int y) { //먹이와의 거리 측정 (먹이까지 가는 것이 불가능할 때는 Integer.MAX_VALUE 반환)
        int[][] distance = new int[N][N];
        Queue<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[]{shark[X], shark[Y]});
        int dist = Integer.MAX_VALUE;

        Loop1:
        while (!q.isEmpty()) {
            Integer[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (distance[nx][ny] == 0 && map[nx][ny] != 9 &&  map[nx][ny] < shark[size]) {
                        distance[nx][ny] = distance[now[0]][now[1]] + 1;
                        q.add(new Integer[]{nx, ny});
                    }
                    if (nx == x && ny == y) {
                        dist = distance[nx][ny];
                        break Loop1;
                    }
                }
            }
        }

        return dist;
    }

    static int[] getClosestPrey() { //null 반환할 위험이 있음
        int min = Integer.MAX_VALUE;
        int[] closestPrey = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && map[i][j] < shark[size]) {
                    int dist = distance(i, j);
                    if (dist < min) {
                        min = dist;
                        closestPrey = new int[]{i, j, map[i][j]};
                    }
                }
            }
        }
        if (closestPrey != null) { //x, y, size, dist 반환
            return new int[]{closestPrey[0], closestPrey[1], closestPrey[2], min};
        } else {
            return null;
        }
    }

    static void moveAndEat(int[] prey) {
        shark[size] += prey[size];
        shark[X] = prey[X];
        shark[Y] = prey[Y];
        //TODO
    }

}
