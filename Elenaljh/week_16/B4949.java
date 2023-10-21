import java.io.*;
import java.util.*;

public class B4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Loop1 :
        while (true) {
            //스택 초기화
            Stack<String> stack = new Stack<>();

            //문장 입력
            String sentence = br.readLine();
            if (sentence.equals(".")) break; //"."입력시 종료
            StringTokenizer st = new StringTokenizer(sentence);

            // 문장 하나 검사
            while (st.hasMoreTokens()) {
                String str = st.nextToken();

                //하나의 단어 검사
                if (str.contains("(") || str.contains("[") || str.contains(")") || str.contains("]")) {
                    for (int i = 0; i < str.length(); i++) {
                        switch (str.charAt(i)) {
                            case '(':
                                stack.push("(");
                                break;
                            case '[':
                                stack.push("[");
                                break;
                            case ')':
                                if (stack.isEmpty()) {
                                    System.out.println("no");
                                    continue Loop1;
                                } else if (stack.peek() == "(") {
                                    stack.pop();
                                    break;
                                } else {
                                    System.out.println("no");
                                    continue Loop1;
                                }
                            case ']':
                                if (stack.isEmpty()) {
                                    System.out.println("no");
                                    continue Loop1;
                                } else if (stack.peek() == "[") {
                                    stack.pop();
                                    break;
                                } else {
                                    System.out.println("no");
                                    continue Loop1;
                                }
                        }
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }
    }
}
