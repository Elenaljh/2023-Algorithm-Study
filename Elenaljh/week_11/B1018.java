import java.io.*;
import java.util.*;

import static java.lang.Math.min;

public class B1018 {

    public static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //변수받기
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];

        //배열 저장하기, B=true, W=false
        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'B') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        //검사하기
        int result = 64;
        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                result = min(result, find(i,j));
            }
        }

        //결과
        System.out.println(result);
        bf.close();
    }

    public static int find(int a, int b) {
        int count = 0;
        boolean color = arr[a][b];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (color != arr[a+i][b+j]) {
                    count++;
                }
                color = !color;
            }
            color = !color;
        }

        return min(count, 64-count);
    }

}
