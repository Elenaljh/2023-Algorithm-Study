import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        char[] bracket = br.readLine().toCharArray();

        char before = ' ';
        int mul = 1;
        int result = 0;
        boolean isBalance = true;
        for (char c :
                bracket) {

            if (c == '(' || c == '[') {
                switch (before) {
                    case '(':
                        mul *= 2;
                        break;
                    case '[':
                        mul *= 3;
                        break;
                }
                stack.add(c);
                before = c;
            } else {
                if (stack.isEmpty()) {
                    isBalance = false;
                    break;
                } else if (c == ')') {
                    if (stack.peek() != '(') {
                        isBalance = false;
                        break;
                    } else {
                        if (before == ']' || before == ')') mul /= 2;
                        else result += 2 * mul;
                    }
                } else if (c == ']') {
                    if (stack.peek() != '[') {
                        isBalance = false;
                        break;
                    } else {
                        if (before == ']' || before == ')') mul /= 3;
                        else result += 3 * mul;
                    }
                }

                stack.pop();
                before = c;
            }
        }
        if (!isBalance) {
            System.out.println(0);
        } else {
            if (stack.isEmpty()) {
                System.out.println(result);
            } else {
                System.out.println(0);
            }
        }
    }
}
