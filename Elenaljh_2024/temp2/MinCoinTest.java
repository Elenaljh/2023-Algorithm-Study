import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//화폐단위 1, 4, 6
public class MinCoinTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //목표금액
        int[] D = new int[N+1]; //각 금액을 만드는 최소 동전수(최적해)

        D[0] = 0; //점화식으로 값을 구할 수 없는 대상 초기화
        for (int i = 1; i <= N; i++) {  //i: 금액
            int min = D[i-1] + 1; //1원을 사용했을 경우 임시 최적해
            if (i >= 4) min = Math.min(D[i-4]+1, min);
            if (i >= 6) min = Math.min(D[i-6]+1, min);

            D[i] = min;
        }
        System.out.println(Arrays.toString(D));
        System.out.println(D[N]);
    }
}
