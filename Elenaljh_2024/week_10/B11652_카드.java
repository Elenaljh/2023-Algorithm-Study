import java.util.*;
import java.io.*;
public class B11652_카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Long, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(br.readLine());
            Integer val = map.getOrDefault(x, 0);
            map.put(x, val+1);
        }
        //value 기준으로 정렬(내림차순) -> 같을 때는 키값 작은 것
        List<Long> keySet = new ArrayList<>(map.keySet());
        keySet.sort(((o1, o2) -> {
            if (Objects.equals(map.get(o2), map.get(o1))) {
                return o1.compareTo(o2);
            }
            return map.get(o2) - map.get(o1);
        }));

        System.out.println(keySet.get(0));
    }
}
