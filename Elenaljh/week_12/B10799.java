import java.io.*;
import java.util.*;

public class B10799 {
    public static void main(String[] args) throws IOException{
        Stack<String> stack = new Stack<>();
        int count = 0;
        boolean b = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("(")) {
                stack.push("(");
                b = true;
            }
            if (input[i].equals(")") && b) {
                stack.pop();
                count += stack.size();
                b = false;
            } else if (input[i].equals(")") && b == false) {
                stack.pop();
                count++;
            }
        }
        System.out.println(count);
    }
}
