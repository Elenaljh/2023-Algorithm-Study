import java.io.*;
import java.util.*;
/*
시간초과 극복함
 */
public class 줄기세포배양_수정 {
    static HashMap<String, Integer> inactive, active, vitality;
    static PriorityQueue<Integer[]> q;
    static int N, M, K;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            //초기화
            inactive = new HashMap<>();
            active = new HashMap<>();
            vitality = new HashMap<>();
            q = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);

            //자료 입력
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int X = Integer.parseInt(st.nextToken()); //생명력
                    if (X == 0) continue;
                    inactive.put(i+" "+j, X);
                    vitality.put(i+" "+j, X);
                }
            }

            //시간 흐르게 하기
            for (int time = 0; time < K; time++) {
                //1. 세포 번식
                duplicate();
                //2. active 시간 흐르게
                activeWork();
                //3. inactive 시간 흐르게
                inactiveWork();
            }

            sb.append("#").append(test).append(" ").append(active.size()+inactive.size()).append("\n");
        }
        System.out.println(sb);
    }
    //세포 번식
    static void duplicate() {
        while (!q.isEmpty()) {
            Integer[] cell = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cell[0] + dx[i]; int ny = cell[1] + dy[i];
                String coordinate = nx+" "+ny;
                if (!vitality.containsKey(coordinate)) {
                    inactive.put(coordinate, cell[2]+1);
                    vitality.put(coordinate, cell[2]);
                }
            }
        }
    }

    //inactive 시간 흐르게
    static void inactiveWork() {
        Iterator<Map.Entry<String, Integer>> itr = inactive.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            String coordinate = entry.getKey();
            Integer time = entry.getValue();
            if (--time == 0) {
                active.put(coordinate, vitality.get(coordinate)); //active에 넣기
                itr.remove(); //inactive에서 지우기
                Integer[] info = beforeQueue(coordinate, vitality.get(coordinate));
                q.add(info); //큐에 넣기
            } else {
                entry.setValue(time);
            }
        }
    }

    //active 시간 흐르게
    static void activeWork() {
        Iterator<Map.Entry<String, Integer>> itr = active.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            String coordinate = entry.getKey();
            Integer time = entry.getValue();
            if (--time == 0) {
                itr.remove(); //active에서 지우기
            } else {
                entry.setValue(time); //값 변경
            }
        }
    }

    //좌표 분리
    static Integer[] beforeQueue(String coordinate, int vitality) {
        StringTokenizer st = new StringTokenizer(coordinate);
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        return new Integer[]{x, y, vitality};
    }
}
