import java.io.*;
import java.util.*;
public class B1021 {
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> dq = new LinkedList<>();  //indexOf() 메서드 사용 위함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n+1; i++) {
            dq.addLast(i);
        }

        int count = 0;
        int target, index, half;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            target = Integer.parseInt(st.nextToken());
            index = dq.indexOf(target);
            half = dq.size()/2;

            if (index <= half){
                while (target != dq.peekFirst()) {
                    dq.addLast(dq.pollFirst());
                    count++;
                }
            } else {
                while (target != dq.peekFirst()) {
                    dq.addFirst(dq.pollLast());
                    count++;
                }
            }

            dq.pollFirst();
        }
        System.out.println(count);

    }

}
