/**
에디터
https://www.acmicpc.net/problem/1406
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder s = new StringBuilder(scanner.next());
        int m = scanner.nextInt();
        int cursor = s.length();

        for (int i = 0; i < m; i++) {
            String command = scanner.next();
            cursor = cursor > s.length() ? s.length() : Math.max(cursor, 0);

            switch (command) {
                case "L":
                    cursor--;
                    break;
                case "D":
                    cursor++;
                    break;
                case "B":
                    cursor--;
                    if (cursor > -1) s.deleteCharAt(cursor);
                    break;
                case "P":
                    s.insert(cursor, scanner.next());
                    cursor++;
                    break;
            }
        }
        System.out.println(s);
        scanner.close();
    }
}
