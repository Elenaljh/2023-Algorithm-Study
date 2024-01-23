import java.io.*;
import java.util.*;

public class B1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[] a = new int[26];
        int[] b = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            int alp = str1.charAt(i) - 97;
            a[alp]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            int alp = str2.charAt(i) - 97;
            b[alp]++;
        }

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                count += Math.abs(a[i]-b[i]);
            }
        }

        System.out.println(count);
    }
}
