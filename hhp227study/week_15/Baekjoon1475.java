/**
방 번호
https://www.acmicpc.net/problem/1475
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();
        long factor = 0;
        int[] bucket = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        float[] count = new float[bucket.length];
        int result = 0;

        for (int i = 0; i < num.length(); i++) {
            factor = Integer.parseInt(String.valueOf(num.charAt(i)));
            if (factor== 6 || factor == 9) {
                if (count[6] < 1) {
                    count[6]++;
                } else {
                    count[6] += 0.5;
                }
            }
            for (int j = 0; j < bucket.length; j++) {
                if (factor == bucket[j]) {
                    if (factor != 6) {
                        count[j]++;
                    }
                }
            }
        }
        for (float v : count) {
            result = Math.max(result, (int) v);
        }
        System.out.println(result);
    }
}
