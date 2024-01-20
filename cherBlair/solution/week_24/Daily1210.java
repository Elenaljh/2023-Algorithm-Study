package week_24;

import java.util.Scanner;

public class Daily1210 {

    // 03-1 배열과 리스트
    // https://www.acmicpc.net/problem/11720

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String sNum = sc.next();
//        char[] cNum = sNum.toCharArray();
//        int sum = 0;
//        for (int i = 0; i < cNum.length; i++) {
//            sum += cNum[i] - '0';
//        }
//        System.out.print(sum);
//    }

    //-----------------------------------------------
    // https://www.acmicpc.net/problem/1546

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        long sum = 0, max = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            sum = sum + A[i];
        }
        System.out.println(sum * 100.0 / max / N);
    }
}
