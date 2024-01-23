import java.util.*;
import java.io.*;

public class B2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer[]> stack1 = new Stack<>();
        Stack<Integer[]> stack2 = new Stack<>();


        //정보입력
        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stack1.push(new Integer[]{Integer.parseInt(st.nextToken()), i});
        }

        //정보 수신하는 탑 찾기
        while(!stack1.isEmpty()) {
            if (stack2.isEmpty() || stack2.peek()[0] > stack1.peek()[0]) {
                stack2.push(stack1.pop());
                continue;
            }
            result[stack2.peek()[1]] = stack1.peek()[1] + 1;
            stack2.pop();
        }
        while (!stack2.isEmpty()) {
            result[stack2.peek()[1]] = 0;
            stack2.pop();
        }

        //값 출력하기
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
