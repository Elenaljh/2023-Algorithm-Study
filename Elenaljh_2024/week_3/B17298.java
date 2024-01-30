import java.io.*;
import java.util.*;
/*
https://www.acmicpc.net/problem/17298
 */

//시간초과 - 어케해결
public class B17298 {
    public static void main(String[] args) throws IOException {
        Stack<Integer[]> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek()[0] < input) {
                    result[stack.peek()[1]] = input;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(new Integer[]{input, i});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]==0?-1:result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
