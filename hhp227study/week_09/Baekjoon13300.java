/**
방 배정
https://www.acmicpc.net/problem/13300
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        Map<Integer, int[]> map = new HashMap<>() {
            {
                for (int i = 0; i < 6; i++) {
                    put(i + 1, new int[2]);
                }
            }
        };
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt(), y = scanner.nextInt();
            int[] info = map.get(y);

            info[s]++;
            map.put(y, info);
        }
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] info = entry.getValue();
            answer += Math.ceil((double) info[0] / k) + Math.ceil((double) info[1] / k);
        }
        System.out.println(answer);
    }
}
