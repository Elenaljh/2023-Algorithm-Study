/**
회의실 배정
https://www.acmicpc.net/problem/1931
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> list = new ArrayList<>() {
            {
                for (int i = 0; i < n; i++) {
                    add(new int[] {scanner.nextInt(), scanner.nextInt()});
                }
            }
        };
        int last = 0, count = 0;

        list.sort((o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o1[1]);
        for (int[] pair : list) {
            if (last <= pair[0]) {
                last = pair[1];
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
    }
}
