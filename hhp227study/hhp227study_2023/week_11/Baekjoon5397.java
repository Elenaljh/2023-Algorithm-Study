/**
키로거
https://www.acmicpc.net/problem/5397
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tcCount = scanner.nextInt();

        for (int i = 0; i < tcCount; i++) {
            String s = scanner.next();
            StringBuilder sb = new StringBuilder();
            int cursor = 0;

            for (char c : s.toCharArray()) {
                switch (c) {
                    case '<':
                        if (cursor > 0) cursor--;
                        break;
                    case '>':
                        if (cursor < sb.length()) cursor++;
                        break;
                    case '-':
                        if (cursor > 0) cursor--;
                        if (sb.length() > 0) sb.deleteCharAt(cursor);
                        break;
                    default:
                        sb.insert(cursor, c);
                        cursor++;
                        break;
                }
            }
            System.out.println(sb);
        }
        scanner.close();
    }
}
