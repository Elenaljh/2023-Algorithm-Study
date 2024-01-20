/**
수 정렬하기
https://www.acmicpc.net/problem/2750
*/

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int[] array = new int[num];

        for (int i = 0; i < num; i++) {
            array[i] = Integer.parseInt(scan.nextLine());
        }
        Arrays.sort(array);
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
        scan.close();
    }
}
