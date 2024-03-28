import java.io.*;
import java.util.*;
public class B2239_스도쿠최적화 {
    static int[] row = new int[9];
    static int[] col = new int[9];
    static int[][] sec = new int[3][3]; //블록인듯
    static int[][] sudoku = new int[9][9];
    static List<int[]> zeros = new ArrayList<>();
    static int l; //???
    static int[] num = new int[513]; //2^9-1 = 513
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = line.charAt(j) - '1'; //??

                if (sudoku[i][j] > -1) {
                    row[i] |= 1 << sudoku[i][j]; //row[i]의 sudoku[i][j]번째 비트에 1 추가
                    col[j] |= 1 << sudoku[i][j]; //col[j]의 sudoku[i][j]번째 비트에 1 추가
                    sec[i/3][j/3] |= 1 << sudoku[i][j];
                } else {
                    zeros.add(new int[]{i, j});
                }
            }
        }

        l = zeros.size(); //0의 개수

        for (int i = 0; i < 9; i++) {
            num[1<<i] = i; //num[1]=0, num[2]=1, num[4]=2, num[8]=3, ... num[2^8]=8
        }

        dfs(0);

        //출력
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j] + 1);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static boolean dfs(int d) {
        if (d == l) return true; //종료조건

        int[] rc = zeros.get(d);
        int r = rc[0], c = rc[1]; //0인 셀의 위치

        // (1<<9)-1 = 111111111
        int able = ((1 << 9) - 1) & ~(row[r] | col[c] | sec[r/3][c/3]); //행, 열, sector에 모두 없는 숫자만 뽑음

        while (able > 0) { //사용 가능한 모든 숫자를 써보자
            int p = able & -able; //able의 가장 오른쪽 1 (가능한 수 중 가장 작은 수)
            able -= p;

            sudoku[r][c] = num[p]; //어차피 계속 바뀔거니까 굳이 dfs빠져나와서 원복 안시켜도 됨

            row[r] |= p;
            col[c] |= p;
            sec[r/3][c/3] |= p;

            if (dfs(d+1)) return true;

            row[r] &= ~p;
            col[c] &= ~p;
            sec[r/3][c/3] &= ~p;
        }
        return false;
    }
}
