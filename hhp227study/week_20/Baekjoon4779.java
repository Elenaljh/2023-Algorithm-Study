/**
칸토어 집합
https://www.acmicpc.net/problem/4779
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder("-");

            for (int i = 0; i < n; i++) {
                String s = stringBuilder.toString();

                stringBuilder.append(" ".repeat(stringBuilder.length())).append(s);
            }
            System.out.println(stringBuilder);
        }
        scanner.close();
    }
}
