import java.io.*;
import java.util.*;
/*
https://www.acmicpc.net/problem/6549
 */
public class B6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer[]> right = new Stack<>();
        Stack<Integer> left = new Stack<>();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] result = new int[n];

            for (int i = 0; i < n; i++) {
                int input = Integer.parseInt(st.nextToken());
                //오른쪽 검사
                while (!right.isEmpty()) {
                    if (right.peek()[0] > input) {
                        Integer[] tmp = right.pop();
                        int size = tmp[0] * (i-tmp[1]-1);
                        result[tmp[1]] = size;
                    } else {
                        break;
                    }
                }
                right.push(new Integer[]{input, i});

                //왼쪽 검사
                while (!left.isEmpty()) {
                    if (left.peek() < input) {
                        left.pop();
                    } else {
                        break;
                    }
                }
                int size = input * left.size();
                result[i] += size;
                left.push(input);
            }

            int max = 0;
            for (int size : result) {
                max = Math.max(max, size);
            }
            sb.append(max).append("\n");

        }
        System.out.println(sb);
    }
}
