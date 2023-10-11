import java.io.*;
import java.util.*;

public class B2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String[] n = Integer.toString(a*b*c).split("");

        int[] count = new int[10];

        for (int i = 0; i < n.length; i++) {
            int j = Integer.parseInt(n[i]);
            count[j]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }

    }
}
