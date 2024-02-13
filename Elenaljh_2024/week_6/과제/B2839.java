package 과제;

import java.io.*;
import java.util.*;
public class B2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        if ((n < 5 && n != 3) || n == 7) {
            System.out.println(-1);
            return;
        }

        //5kg
        count += n/5;

        //3kg
        switch (n%5) {
            case 0:
                break;
            case 1:
                count++;
                break;
            case 2:
                count += 2;
                break;
            case 3:
                count++;
                break;
            case 4:
                count+=2;
        }

        System.out.println(count);
    }
}
