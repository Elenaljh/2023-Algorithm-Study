package 과제;
/*
정사각형 방
 */
import java.util.*;
import java.io.*;
public class SW1867 {
    static int n, m;
    static int[][] room;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int count; //이동 가능한 횟수
    static int max = 0;
    static int thePlace; //count를 최대화하는 방 번호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 1; t <= testCase; t++) {
            n = Integer.parseInt(br.readLine());
            room = new int[n][n];
            thePlace = Integer.MAX_VALUE;
            max = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    count = 1;
                    bfs(i, j);
                }
            }
            sb.append("#").append(t).append(" ").append(thePlace).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int r, int c) {
        Queue<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[]{r, c});

        while (!q.isEmpty()) {
            Integer[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (room[nx][ny] == room[now[0]][now[1]] + 1 && !contains(q, new Integer[]{nx, ny})) {
                        q.add(new Integer[]{nx, ny});
                        count++;
                    }
                }
            }
        }
        if (count > max) {
            thePlace = room[r][c];
            max = count;
        } else if (count == max) {
            thePlace = Integer.min(room[r][c], thePlace);
        }
    }

    static boolean contains(Queue<Integer[]> q, Integer[] arr) {
        for (Integer[] a : q) {
            if (Arrays.equals(a, arr)) {
                return true;
            }
        }
        return false;
    }
}
