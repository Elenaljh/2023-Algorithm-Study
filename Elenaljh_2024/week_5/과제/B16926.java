package 과제;
/*
배열 돌리기1
 */
import java.io.*;
import java.util.*;
public class B16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //행
        int m = Integer.parseInt(st.nextToken()); //열
        int layer = Integer.min(n, m)/2;
        int r = Integer.parseInt(st.nextToken());

        //배열 입력
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //좌표 (상하좌우)
        int[] dx = new int[]{0, 1, 0, -1};//오른쪽, 아래, 왼쪽, 위
        int[] dy = new int[]{1, 0, -1, 0};

        //배열 돌리기 - 한 번에 한칸씩 r회 반복
        for (int t = 0; t < r; t++) {
            //한 레이어씩 돌리기
            for (int i = 0; i < layer; i++) {
                int origin = map[i][i];
                int x = i, y = i;
                int direction = 0;
                while (direction < 4) {
                    int nx = x + dx[direction];
                    int ny = y + dy[direction];
                    if (nx >= i && nx < n-i && ny >= i && ny < m-i) {
                        map[x][y] = map[nx][ny]; //(nx, ny)이걸 땡겨와서 [x, y]에 대입
                        x = nx;
                        y = ny;
                    } else { //범위 이탈시 다른 방향
                        direction++;
                    }
                }
                map[i+1][i] = origin; //따로 빼놓은 값 넣어주기
            }
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }


}
