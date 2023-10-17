import java.io.*;
import java.util.*;

public class B10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        int a;

        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            if (st.contains("push")) {
                a = Integer.parseInt(st.split(" ")[1]);
                q.addLast(a);
            } else if (st.equals("pop")) {
                a = (q.isEmpty())? -1 : q.pollFirst();
                System.out.println(a);
            } else if (st.equals("size")) {
                System.out.println(q.size());
            } else if (st.equals("empty")) {
                a = (q.isEmpty())? 1 : 0;
                System.out.println(a);
            } else if (st.equals("front")) {
                a = (q.isEmpty())? -1 : q.peek();
                System.out.println(a);
            } else if (st.equals("back")) {
                a = (q.isEmpty())? -1 : q.peekLast();
                System.out.println(a);
            }
        }
    }
}
