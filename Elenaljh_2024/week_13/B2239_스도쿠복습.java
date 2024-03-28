import java.io.*;
import java.util.*;
public class B2239_스도쿠복습 {
    static int[][] map = new int[9][9];
    static List<int[]> zeroList = new ArrayList<>();
    static int row[] = new int[9], col[] = new int[9], block[][] = new int[3][3];
    static int[] num = new int[513];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = str.charAt(j) - '1';
                if (map[i][j] > -1) {
                    row[i] |= 1<<map[i][j];
                    col[j] |= 1<<map[i][j];
                    block[i/3][j/3] |= 1<<map[i][j];
                } else {
                    zeroList.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < 9; i++) num[1<<i] = i;

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]+1);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean dfs(int solved) {
        //종료조건
        if (zeroList.size() == solved) {

            return true;
        }

        //타겟 셀 좌표
        int r = zeroList.get(solved)[0];
        int c = zeroList.get(solved)[1];

        //해당 셀에 들어갈 수 있는 숫자 구하기
        int candidate = ((1<<9)-1) & ~(row[r]|col[c]|block[r/3][c/3]);

        //하나씩 넣어보기
        while (candidate > 0) {
            int n = candidate & -candidate; //후보수 중 가장 작은 수
            candidate -= n;

            map[r][c] = num[n];

            row[r] |= n;
            col[c] |= n;
            block[r/3][c/3] |= n;
            if(dfs(solved+1)) return true;
            row[r] &= ~n;
            col[c] &= ~n;
            block[r/3][c/3] &= ~n;
        }
        return false;
    }
}
