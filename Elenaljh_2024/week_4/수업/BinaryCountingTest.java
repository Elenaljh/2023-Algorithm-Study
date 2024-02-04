package 수업;

import java.util.Scanner;

public class BinaryCountingTest {
    static int[] numbers;
    static int N;

    // 입력받은 수들로 가능한 부분집합 구성 : 경우의 수의 비트마스킹 활용
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        for(int i=0; i<N; ++i) {
            numbers[i] = sc.nextInt();
        }
        generateSubSet(N);

    }

    // n:3일 경우의 총 부분집합의 경우의수 ==>8
    // 경우의수 8을 이용하여 0-7까지의 값을 비트마스킹으로 사용
    // 000 001 010 011 100 101 110 111
    // 위 3자리의 비트를 아래처럼 인식하여 처리한다.
    // 2인덱스원소 1인덱스원소 0인덱스원소 (각 비트가 1인 경우 : 해당원소 부분집합에 포함)
    private static void generateSubSet(int n) {
        // 1<<n : 2^n 부분집합의 개수 구하기
        for(int flag=0,caseCount = 1<<n; flag<caseCount; ++flag) { //2^n번 반복
            for(int j=0; j<N; ++j) {
                System.out.print(((flag & 1<<j) != 0? numbers[j] : "X")+"\t");
//				System.out.print(((flag & 1<<j) != 0? numbers[j]+"\t" : ""));
            }
            System.out.println();
        }
    }
}
