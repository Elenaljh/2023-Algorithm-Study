/**
 * 과제
 * https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV139KOaABgCFAYh&solveclubId=AYzyCQd6tDkDFAXz&problemBoxTitle=0130&problemBoxCnt=3&probBoxId=AY1YCnJqvA4DFATh+
 */
import java.util.*;
import java.io.*;

public class SW1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int dump = Integer.parseInt(br.readLine()); //덤프 횟수
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> boxes = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                boxes.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < dump; j++) {
                int max = Collections.max(boxes);
                int min = Collections.min(boxes);
                int maxIndex = boxes.indexOf(max);
                int minIndex = boxes.indexOf(min);

                boxes.set(maxIndex, max-1);
                boxes.set(minIndex, min+1);
            }

            int diff = Collections.max(boxes) - Collections.min(boxes);
            sb.append("#").append(i+1).append(" ").append(diff).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
