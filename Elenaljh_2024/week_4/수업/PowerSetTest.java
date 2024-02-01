package 수업;

import java.util.Scanner;

//N개의 원소를 입력받아 가능한 모든 부분집합 생성
// 1 <= N <= 10 (n이 너무 커지면 안된다ㅜㅜ)
public class PowerSetTest {

    static int N, target, input[];
    static boolean isSelected[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        target = sc.nextInt(); //목표합
        input = new int[N];
        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        generateSubSet(0, 0);
    }

    private static void generateSubSet(int cnt, int sum){ //sum: 기존 부분집합의 구성요소들의 합

        //기저조건
        if (cnt == N) {
            if (sum == target) {
                for (int i = 0; i < N; i++) {
                    if(isSelected[i]) System.out.print(input[i]+"\t");
                }
                System.out.println();
            }
            return;
        }

        //만약 원소를 특정할 필요 없이 누적합 달성 여부만 따져야 한다면 isSelected는 필요 없다!
        isSelected[cnt] = true; //부분집합에 cnt번째 원소 포함
        generateSubSet(cnt+1,sum+input[cnt]); //이렇게 인자로 보낼때 더해줘야 나중에 돌아왔을 때 원래값으로 복귀함
        isSelected[cnt] = false; //포함하지 않는 경우
        generateSubSet(cnt+1, sum); //누적합에 변화가 없는 경우이기 때문
    }
}
