package 수업;

import java.util.Scanner;

public class PowerSetSumTest {

    static int N, input[];
    static boolean isSelected[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        generateSubSet(0);
    }

    private static void generateSubSet(int cnt){
        //기저조건
        if (cnt == N) { //모든 원소가 고려되었다면 부분집합을 구성하는 원소들의 합이 목표합이 되는지 체크
            for (int i = 0; i < N; i++) {
                System.out.print((isSelected[i]?input[i]:"X")+"\t");
            }
            System.out.println();
            return;
        }

        isSelected[cnt] = true; //부분집합에 cnt번째 원소 포함
        generateSubSet(cnt+1);
        isSelected[cnt] = false; //포함하지 않는 경우
        generateSubSet(cnt+1);
    }
}
