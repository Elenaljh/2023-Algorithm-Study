package 과제;

import java.util.Scanner;

/*
신기한 소수 찾기
 */
public class B2023 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[] first = new int[]{2, 3, 5, 7};
    static int[] next = new int[]{1, 3, 7, 9};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        work(0);

    }

    static void work(int depth) {
        if (depth == N) {
            System.out.println(sb);
            return;
        }
        if (depth == 0) {
            for (int i : first) {
                sb.append(i);
                work(depth+1);
                sb.deleteCharAt(sb.length()-1);
            }
        } else {
            for (int i : next) {
                sb.append(i);
                if (!inspect(Integer.parseInt(sb.toString()))) {
                    sb.deleteCharAt(sb.length()-1);
                    continue;
                }
                work(depth+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    //소수인지 판별
    static boolean inspect(int number) {
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number%i == 0) return false;
        }
        return true;
    }
}
