import java.io.*;
import java.util.*;
public class B1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
        Integer[] originalScores = new Integer[n];
        double[] newScores = new double[n];

        originalScores = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer max = Arrays.stream(originalScores).max(Integer::compareTo).get();
//        newScores = Arrays.stream(originalScores).map((Double)i -> (Double)(i/max*100)).toArray();

        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            newScores[i] = (double) originalScores[i] / max * 100;
            sum += newScores[i];
        }
        double result = sum / n;
        System.out.println(result);
    }
}
