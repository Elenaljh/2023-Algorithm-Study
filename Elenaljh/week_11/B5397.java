import java.io.*;
import java.util.*;

public class B5397 {
    public static void main(String[] args) throws IOException {
        //변수받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(bf.readLine()); //문자열 길이
        String[] result = new String[L];

        //스택
        Stack<String> left = new Stack<String>();
        Stack<String> right = new Stack<String>();

        //로직
        for (int i = 0; i < L; i++) {
            String[] input = bf.readLine().split("");
            for (String s : input) {
                switch (s.charAt(0)) {
                    case '<':
                        if (!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>':
                        if (!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-':
                        if (!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(String.valueOf(s));
                        break;
                }
            }
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            StringBuilder sb = new StringBuilder();
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            result[i] = sb.toString();
        }
        for (int i = 0; i < L; i++) {
            System.out.println(result[i]);
        }
    }
}
