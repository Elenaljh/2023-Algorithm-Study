package 수업;

import java.util.Arrays;

// nPr ==> 3P2 = 3 * 2 = 6
// nCr = nPr / r! ==> 3C2 = 3P2 / 2! = 3 * 2 / 2 = 3
public class PerCombiTest {
    static int[] num= {1,2,3};   // num={1,2,3,4}
    static int N=2;              // N=2, N=3
    static int sCount=0;

    private static void makePermutation(int toSelect,int[] selected, boolean[] visited) {
        if (toSelect == N) {
            System.out.println(Arrays.toString(selected));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[toSelect] = num[i];
                makePermutation(toSelect + 1, selected, visited);
                visited[i] = false;
            }
        }
    }
    //--------------------------------------------------------------------------------------
    private static void makeCombination(int toSelect, int[] selected, int startIdx) {
        if (toSelect == N) {
            System.out.println(Arrays.toString(selected));
            return;
        }
        for (int i = startIdx; i < num.length; i++) {
            selected[toSelect] = num[i];
            makeCombination(toSelect+1, selected, i+1);
        }
    }
    //--------------------------------------------------------------------------------------
    private static void powerSet(int cnt, boolean[] isSelected) {
        if (cnt == num.length) {
            sCount++;
            System.out.print("{");
            for (int i = 0; i < num.length; i++) {
                if (isSelected[i]) {
                    System.out.print(num[i] + " ");
                }
            }
            System.out.print("}, ");
            return;
        }

        //선택
        isSelected[cnt] = true;
        powerSet(cnt + 1, isSelected);

        //비선택
        isSelected[cnt] = false;
        powerSet(cnt+1, isSelected);
    }
    //--------------------------------------------------------------------------------------
    public static void main(String[] args) {
//		1. num에서 N개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
        System.out.println("-----순열-----");
        makePermutation(0, new int[N], new boolean[num.length]);

//		2. num에서 N개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
        System.out.println("-----조합-----");
        makeCombination(0, new int[N], 0);

//		3. num으로 구성할 수 있는 모든 부분집합을 출력하시오.
        System.out.println("-----부분집합-----");
        powerSet(0, new boolean[num.length]);
        System.out.println("\n총 경우의 수: " + sCount);
    }
}
/*
순열: 순서의 의미가 있다
예) 1 2 3 (N:2)
1  2
1  3
2  1
2  3
3  1
3  2

조합: 순서의 의미가 없다
예) 1 2 3  (N:2)
1  2
1  3
2  3
*/