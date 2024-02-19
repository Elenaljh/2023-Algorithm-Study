/**
두 수의 합
https://www.acmicpc.net/problem/3273
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), answer = 0;
        Set<Integer> set = new HashSet<>() {
            {
                for (int i = 0; i < n; i++) add(scanner.nextInt());
            }
        };
        int x = scanner.nextInt();

        for (int num : set) {
            if (set.contains(x - num) && num < x - num) answer++;
        }
        System.out.println(answer);
        scanner.close();
    }
}
