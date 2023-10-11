import java.util.*;
import java.io.*;

public class B1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n = br.readLine().split("");
        int[] m = new int[10];

        for (int i = 0; i < n.length; i++) {
            int j = Integer.parseInt(n[i]);
            if (j == 9) j = 6;
            m[j]++;
        }

        /**
         * 의문: 왜 m[6] = 3이면 m[6] = (int) Math.ceil(m[6]/2); 의 결과가 1인가?
         * 이것 때문에 669 -> 1 이라는 이상한 결과가 나옴.
         */
        if (m[6]%2 == 1) {
            m[6] = m[6]/2 + 1;
        } else {
            m[6] = m[6]/2;
        }
        int max = Arrays.stream(m).max().getAsInt();

        System.out.println(max);
    }
}
