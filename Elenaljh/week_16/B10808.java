import java.io.*;

public class B10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        int[] result = new int[26];

        for (int i = 0; i < st.length(); i++) {
            int j = (int) st.charAt(i) - 97;
            result[j]++;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(result[i] + " ");
        }


    }
}
