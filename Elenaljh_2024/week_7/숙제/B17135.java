package 숙제;
/*
캐슬 디펜스
 */
import java.util.*;
import java.io.*;
public class B17135 {
    static int N, M, D;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken()); //궁수 공격 거리 제한
        map = new int[N+1][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //n번 행에 궁수 3명 배치
        //각 턴마다 각 궁수는 동시에 적을 하나씩 공격
        //궁수가 공격하는 적 -> 거리가 D 이하인 적 중 가장 가까운 적 + 거리가 같은 경우 가장 왼쪽
        //공격받은 적은 게임에서 제외됨
        //공격이 끝나면 적이 아래로 한 칸 이동, n번째 행으로 이동한 경우 게임에서 제외
        //모든 적이 제외되면 게임이 끝남
        //궁수의 공격으로 제거할 수 있는 적의 최대 수는?
        //격자판 두 위치 거리계산: |r1-r2|-|c1-c2|

    }
}
