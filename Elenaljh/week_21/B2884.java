import java.io.*;
import java.util.*;

public class B2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int totalMinute = 60 * h + m;
        int calculatedMinute = totalMinute - 45;

        if (calculatedMinute < 0) {
            calculatedMinute = 24 * 60 + calculatedMinute;
        }

        int alarmHour = calculatedMinute / 60;
        int alarmMinute = calculatedMinute % 60;

        System.out.println(alarmHour + " " + alarmMinute);
    }
}
