package 과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

/*
사칙연산 유효성 검사
 */
public class SW1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            int n = Integer.parseInt(br.readLine());
            boolean good = true;
            for (int j = 0; j < n; j++) {
                String[] tmp = br.readLine().split(" ");
                String node = tmp[1]; //사칙연산기호 혹은 숫자
                if (node.equals("+") || node.equals("-") || node.equals("*") || node.equals("/")) {
                    if (tmp.length != 4) {
                        good = false;
                    }
                } else {
                    if (tmp.length != 2) {
                        good = false;
                    }
                }
            }
            if (good) {
                sb.append("#").append(i).append(" ").append(1).append("\n");
            } else {
                sb.append("#").append(i).append(" ").append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
