import java.io.*;
import java.util.*;

public class SW1210 {
    public static void main(String[] args) throws IOException {
        int[][] map = new int[100][100];
        int WIDTH = 100; //원래는 100
        int TESTCASE = 1; //테스트케이스 원래는 10
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        List<Integer> starts = new ArrayList<>();
        for (int t = 0; t < TESTCASE; t++) {
            sb.append("#").append(br.readLine()).append(" "); //테스트케이스 번호
            int x = 0;
            int y = 99;


            //맵 입력
            for (int i = 0; i < WIDTH; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < WIDTH; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (i == WIDTH-1 && map[i][j]==2) {
                        x = j;
                    }
                }
            }

            //출발점으로 거슬러 올라가기
            // ksdjf;lkasdjfkldsjf;lsadjflkdsjflk;sdjfdsjfkdj;l아아아아아아아아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅓㅏㅏㅏㅓㅏㅏㅏ아라ㅏㅏㅏㅏㅏㅏㅏ

        }
        System.out.println(sb);
    }
}
