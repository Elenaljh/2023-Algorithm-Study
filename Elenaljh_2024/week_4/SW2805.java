import java.io.*;
import java.util.*;

public class SW2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            //농장 크기
            int n = Integer.parseInt(br.readLine());

            //계산하기
            int revenue = 0;
            for (int j = 0; j < n; j++) {
                int pass = Math.abs((n-1)/2-j);
                int read = n - 2*pass;
                String tmp = br.readLine();
                //read
                for (int r = 0; r < read; r++) {
                    revenue += tmp.charAt(pass+r) - '0';
                }
            }

            //출력하기
            sb.append("#").append(i+1).append(" ").append(revenue).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
