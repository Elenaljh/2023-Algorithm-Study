package 스터디;

import java.io.*;
import java.util.*;
public class SW5658_보물상자비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //숫자 개수
            int K = Integer.parseInt(st.nextToken()); //K번째로 큰 숫자를 구해야 함
            char[] numbers = br.readLine().toCharArray();
            TreeSet<Integer> set = new TreeSet<>();
            int numberOfTurns = N/4;

            for (int i = 0; i < numberOfTurns; i++) {
                numbers = turnNumbers(numbers);
                int[] splitNumbers = splitNumbers(numbers);
                for (int j = 0; j < 4; j++) {
                    set.add(splitNumbers[j]);
                }
            }

            Iterator<Integer> itr = set.descendingIterator();
            int answer = -1;
            for (int i = 0; i < K; i++) {
                answer = itr.next();
            }

            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    //char[] 네 부분으로 파싱해서 숫자로 변환하는 함수
    static int[] splitNumbers(char[] numbers) {
        int[] results = new int[4];
        int n = numbers.length/4;
        for (int i = 0; i < numbers.length; i++) {
            if (i%n == 0) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(numbers[i+j]);
                }
                int hexToDecimal = Integer.parseInt(sb.toString(), 16);
                results[i/n] = hexToDecimal;
            }
        }
        return results;
    }

    //char[]을 시계방향으로 돌리는 함수
    static char[] turnNumbers(char[] numbers) {
        int n = numbers.length;
        char[] newNumbers = new char[n];
        newNumbers[0] = numbers[n-1];
        for (int i = 1; i < n; i++) {
            newNumbers[i] = numbers[i-1];
        }
        return newNumbers;
    }
}
