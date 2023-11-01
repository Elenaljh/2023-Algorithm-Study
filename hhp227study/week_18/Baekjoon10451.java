/**
순열 사이클
https://www.acmicpc.net/problem/10451
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] array = new int[n + 1];
            Set<Integer> visited = new HashSet<>();
            int answer = 0;

            Arrays.setAll(array, val -> val > 0 ? scanner.nextInt() : 0);
            for (int j = 1; j < array.length; j++) {
                int index = array[j];

                if (visited.contains(index)) continue;
                answer++;
                while (!visited.contains(index)) {
                    visited.add(index);
                    if (!visited.isEmpty()) {
                        index = array[index];
                    }
                }
            }
            System.out.println(answer);
        }
        scanner.close();
    }
}
