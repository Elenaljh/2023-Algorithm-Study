import java.io.*;
import java.util.*;
public class 아기상어최적화 {
    static int N, sharkX, sharkY, sharkSize, countOfFish, cnt;
    static int[][] map;
    static int[] dx = new int[]{-1, 0, 0, 1};
    static int[] dy = new int[]{0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j*2)-'0';
                if (map[i][j] == 9) {
                    sharkX = i; sharkY = j; sharkSize = 2;
                    map[i][j] = 0; //why?
                }
            }
        }
        countOfFish = 0;
        int count = 0;
        while (bfs()) {
            count += cnt;
        }

        System.out.println(count);
    }

    static boolean bfs() {
        Queue<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[]{sharkX, sharkY});
        int[][] visited = new int[N][N];
        int fishX = N+1, fishY = N+1; //why?
        visited[sharkX][sharkY] = 1;
        boolean flag = false;

        while (!q.isEmpty()) {
            int queueSize = q.size();

            for (int k = 0; k < queueSize; k++) {
                Integer[] now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (visited[nx][ny] == 0 && map[nx][ny] <= sharkSize) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;

                            //먹이를 찾은 경우
                            if (map[nx][ny] < sharkSize && map[nx][ny] != 0) {
                                if (fishX > nx) { //현재 행이 더 아래쪽인 경우
                                    fishX = nx;
                                    fishY = ny;
                                } else if (fishX == nx && fishY > ny) { //현재 열이 더 왼쪽인 경우
                                    fishX = nx;
                                    fishY = ny;
                                }
                                flag = true;
                            }
                            q.add(new Integer[]{nx, ny});
                        }
                    }
                }
            }

            if (flag) {
                map[fishX][fishY] = 0;
                ++countOfFish;
                if (countOfFish == sharkSize) {
                    ++sharkSize;
                    countOfFish = 0;
                }
                sharkX = fishX;
                sharkY = fishY;
                cnt = visited[fishX][fishY] - 1;
                return true;
            }
        }
        return false;
    }
}
