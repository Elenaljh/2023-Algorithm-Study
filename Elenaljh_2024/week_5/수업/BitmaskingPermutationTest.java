package 수업;

import java.util.Arrays;
import java.util.Scanner;

//nPr
public class BitmaskingPermutationTest {
    static int N, input[], numbers[], R;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //N자리 수
        R = sc.nextInt(); //R 정하기
        input = new int[N]; //입력 수 배열
        numbers = new int[R]; //순열 저장 배열

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt(); //N개 수 입력
        }
        permutation(0, 0);
    }

    //nPn
    public static void permutation(int cnt, int flag) {
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((flag & 1<<i) != 0) continue; //i인덱스에 해당하는 수가 사용중이면 패스
            numbers[cnt] = input[i]; //수 선택
            permutation(cnt+1, flag | 1<<i);
        }
    }

}
