import java.io.*;
import java.util.*;

public class B1158 {
    public static void main(String[] args) throws IOException {
        //변수받기, 준비
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        //로직
        for (int i = 1; i < N+1; i++) {
            q.offer(i);
        }

        sb.append("<");

        while(q.size() > 1) {
            for(int i = 0; i < K-1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll() + ", ");
        }

        sb.append(q.poll() + ">");

        //출력, 마무리
        System.out.println(sb.toString());
        bf.close();
    }
}
