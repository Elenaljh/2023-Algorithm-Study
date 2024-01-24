import java.util.*;
import java.io.*;

public class B1874 {
    public static Stack<Integer> stack = new Stack<>();
    public static Stack<Integer> numbers = new Stack<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        //데이터 삽입
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = n; i >= 1; i--) numbers.push(i);

        //본문
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            work(input);
        }

        //결과 출력
        if (stack.isEmpty()) {
            //성공
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }

    static void work(int input) {
        //null방지
        if (stack.isEmpty() && !numbers.isEmpty()) {
            stack.push(numbers.pop());
            sb.append("+").append("\n");
        }
        //stack에 input보다 작거나 같은 숫자가 있을 때
        if (stack.peek() <= input) {
            while (stack.peek() < input && !numbers.isEmpty()) {
                stack.push(numbers.pop());
                sb.append("+").append("\n");
            }
            if (stack.peek() == input) {
                stack.pop();
                sb.append("-").append("\n");
            }
        }
    }

}
