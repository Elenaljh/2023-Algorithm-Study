import java.io.*;
import java.util.*;
public class B2910_빈도정렬 {
    static class Node implements Comparable<Node> {
        int frequency, index;

        public Node(int frequency, int index) {
            this.frequency = frequency;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            if (this.frequency == o.frequency){
                return this.index - o.index;
            }
            return o.frequency - this.frequency;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Map<Integer, Node> map = new HashMap<>();
        st =new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            Node node = map.getOrDefault(x, new Node(0, i));
            node.frequency++;
            map.put(x, node);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((Comparator.comparing(map::get)));

        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Node node = map.get(list.get(i));
            for (int j = 0; j < node.frequency; j++) {
                sb.append(list.get(i)).append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
