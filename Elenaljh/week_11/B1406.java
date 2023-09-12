import java.util.*;
import java.io.*;

//Stack을 사용해 구현
public class B1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine(); //문장받기
        int length = Integer.parseInt(bf.readLine()); //명령어 갯수

        //스택 선언 (왼쪽, 오른쪽)
        Stack<String> left = new Stack<String>();
        Stack<String> right = new Stack<String>();

        //왼쪽 스택에 문자열 넣음
        String[] arr = str.split(""); //받은 문장을 알파벳으로 쪼개기
        for (String s : arr) {
            left.push(s);
        }

        //명령어 받고 실행하기
        for (int i = 0; i < length; i++) {
            String command = bf.readLine();
            char c = command.charAt(0); //String을 char로 바꿈. 숫자는 인덱스

            switch(c) {
                case 'L':
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case 'D':
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                case 'B':
                    if (!left.isEmpty()) left.pop();
                    break;
                case 'P':
                    left.push(String.valueOf(command.charAt(2))); // char을 stack에 집어넣지 못한다..
                    break;
                default:
                    break;
            }
        }

        //left 스택에 있는 문자들을 right로 넣기
        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        //문자열 출력
        while (!right.isEmpty()) {
            bw.write(right.pop());
        }

        //마무리
        bw.flush();
        bw.close();
        bf.close();
    }
}
