import java.io.*;
import java.util.*;

public class B2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int count = 0;
        HashMap<Integer, Stack<Integer>> stacks = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int pret = Integer.parseInt(st.nextToken());
            Stack<Integer> stack;

            //만약 해당 라인의 프렛을 저장할 스택이 없는 경우
            if (!stacks.containsKey(line)) {
                stacks.put(line, new Stack<>());
                stack = stacks.get(line);
                stack.push(pret);
                count++;
                continue;
            }

            stack = stacks.get(line);

            //그냥 push
            if (stack.peek()<pret) {
                stack.push(pret);
                count++;
                continue;
            }
            //pret보다 작은 것이 나올때까지 pop하다가 push
            while (stack.peek()>pret) {
                stack.pop();
                count++;
                if (stack.isEmpty()) {
                    stack.push(pret);
                    count++;
                }
            }

            if (stack.peek()==pret) continue;

            stack.push(pret);
            count++;
        }

        System.out.println(count);
    }
}
