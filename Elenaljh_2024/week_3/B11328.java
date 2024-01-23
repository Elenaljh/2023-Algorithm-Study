import java.util.*;
import java.io.*;

public class B11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int[] oldAlphabet = new int[26];
            int[] newAlphabet = new int[26];
            st = new StringTokenizer(br.readLine());
            String oldstr = st.nextToken();
            String newstr = st.nextToken();

            for (int j = 0; j < oldstr.length(); j++) {
                int alph = oldstr.charAt(j) - 97;
                oldAlphabet[alph]++;
            }

            for (int j = 0; j < newstr.length(); j++) {
                int alph = newstr.charAt(j) - 97;
                newAlphabet[alph]++;
            }

            if (Arrays.equals(oldAlphabet, newAlphabet)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}
