import java.io.*;
import java.util.*;
public class B17406_배열돌리기4 {
    static int N, M, K, r, c, s, MIN;
    static int[][] arr, rotationSetting;
    static int[] dx = new int[]{1, 0, -1, 0}; //하, 우, 상, 좌
    static int[] dy = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        //입력부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //행
        M = Integer.parseInt(st.nextToken()); //열
        K = Integer.parseInt(st.nextToken()); //회전 연산 갯수
        arr = new int[N+1][M+1];
        rotationSetting = new int[K][3];
        MIN = Integer.MAX_VALUE;
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rotationSetting[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(0, new boolean[K], new int[K]);

        System.out.println(MIN);
    }

    static void rotate(int[][] arr) {
        for (int i = 0; i < s; i++) {
            int tmp = arr[r-s+i][c-s+i];
            int x = r-s+i, y = c-s+i;
            for (int j = 0; j < 4; j++) {
                while (x+dx[j] <= r+s-i && x+dx[j] >= r-s+i && y+dy[j] >= c-s+i && y+dy[j] <= c+s-i) {
                    arr[x][y] = arr[x+dx[j]][y+dy[j]];
                    x += dx[j]; y += dy[j];
                }
            }
            arr[r-s+i][c-s+i+1] = tmp;
        }
    }

    static void perm(int count, boolean[] visited, int[] rotationOrder) {
        if (count == K) {
            //배열 복사
            int[][] copy = new int[N+1][M+1];
            for (int i = 1; i <= N; i++) copy[i] = arr[i].clone();
            //복사한 배열 돌리기
            for (int a : rotationOrder) {
                r = rotationSetting[a][0];
                c = rotationSetting[a][1];
                s = rotationSetting[a][2];
                rotate(copy);
            }
            //최소 A 찾기
            int min = Integer.MAX_VALUE;
            int cnt;
            for (int i = 1; i <= N; i++) {
                cnt = 0;
                for (int j = 1; j <= M; j++) {
                    cnt += copy[i][j];
                }
                min = Integer.min(min, cnt);
            }

            //A 최소값 갱신
            MIN = Integer.min(MIN, min);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                rotationOrder[count] = i;
                perm(count+1, visited, rotationOrder);
                visited[i] = false;
            }
        }
    }
}
