/**
 * 과제
 * https://www.acmicpc.net/problem/1244
 */
import java.io.*;
import java.util.*;
public class B1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine()); //스위치 개수
        boolean[] switches = new boolean[num+1]; //스위치 저장할 배열 : 인덱스 0부터 num까지
        String[] line = br.readLine().split(" "); //스위치 입력 받는 배열 : 인덱스 0부터 num-1까지
        for (int i = 1; i <= num; i++) {
            switches[i] = (Integer.parseInt(line[i-1]) != 0);
        }

        int t = Integer.parseInt(br.readLine()); //스위치 조작 횟수

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = 1; j <= num; j++) {
                    if (j%number==0) {
                        switches[j] = !switches[j];
                    }
                }
            } else {
                switches[number] = !switches[number];
                for (int j = 1; j <= num; j++) {
                    if (number-j < 1 || number+j > num) break;
                    if (switches[number-j] == switches[number+j]) {
                        switches[number-j] = !switches[number-j];
                        switches[number+j] = !switches[number+j];
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 1; i <= num; i++) {
            if (i%20==0) {
                sb.append(switches[i] ? 1 : 0).append("\n");
            } else {
                sb.append(switches[i] ? 1 : 0).append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
