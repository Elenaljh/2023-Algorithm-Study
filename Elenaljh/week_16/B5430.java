import java.io.*;
import java.util.*;

public class B5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new LinkedList<>();

        int t = Integer.parseInt(br.readLine());

        Loop1 :
        for (int i = 0; i < t; i++) {
            StringBuilder sb = new StringBuilder();

            //명령어 분리
            String[] function = br.readLine().split("");

            //덱에 숫자 넣기
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            input = input.replace("[", "");
            input = input.replace("]", "");
            String[] numbers = input.split(",");
            for (int j = 0; j < n; j++) {
                q.addLast(Integer.parseInt(numbers[j]));
            }

            //명령문 실행
            boolean front = true;
            for (String func : function) {
                if (func.equals("R")) {
                    front = !front;
                } else {
                    if (q.isEmpty()) {
                        System.out.println("error");
                        continue Loop1;
                    }
                    if (front == true) {
                        q.pollFirst();
                    } else {
                        q.pollLast();
                    }
                }
            }

            //출력
            int size = q.size();
            sb.append("[");
            if (front == true) {
                for (int j = 0; j < size; j++) {
                    sb.append(q.pollFirst()).append(",");
                }
            } else {
                for (int j = 0; j < size; j++) {
                    sb.append(q.pollLast()).append(",");
                }
            }
            if (sb.charAt(sb.length()-1)==',') {
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append("]");

            System.out.println(sb);
        }

    }

}
