import java.io.*;
import java.util.*;
/*
시간초과나는 코드임
 */
public class SW5653_줄기세포배양 {
    static class Cell implements Comparable<Cell> {
        public int x, y, vitality, status;

        public Cell(int x, int y, int vitality, int status) {
            this.x = x;
            this.y = y;
            this.vitality = vitality;
            this.status = status;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x && y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public int compareTo(Cell o) {
            return o.vitality - this.vitality; //생명력 내림차순 정렬
        }

        @Override
        public String toString() {
            return "x=" + x + ", y=" + y + ", 생명력" + vitality;
        }
    }
    static final int inactive = 0, active = 1, dead = 2; //cell status에 사용할 것
    static HashMap<Cell, Integer> petriDish; //세포, 남은 시간 넣음(처음 X가 깎이면 활성화되어 다시 X시간동안 살고 그 동안 번식함)
    static ArrayList<Cell> deadCells;
    static PriorityQueue<Cell> q;
    static int N, M, K;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //행
            M = Integer.parseInt(st.nextToken()); //열
            K = Integer.parseInt(st.nextToken()); //배양시간
            petriDish = new HashMap<>(); //초기화
            deadCells = new ArrayList<>(); //초기화
            q = new PriorityQueue<>(); //초기화

            //해시맵에 세포:생명력 형태로 저장한다.
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int X = Integer.parseInt(st.nextToken());
                    if (X == 0) continue;
                    Cell c = new Cell(i, j, X, inactive);
                    petriDish.put(c, X);
                }
            }

            //K시간동안 배양
            for (int time = 0; time < K; time++) {
                timePass();
            }

            //살아있는 세포 개수 출력
            sb.append("#").append(test).append(" ").append(petriDish.size()).append("\n");
        }
        System.out.println(sb);
    }

    static void timePass() {
        grow(); //세포 번식 (생명력 강한 세포 우선)
        age(); //생명력 -1
    }

    //번식시키는 메서드
    static void grow() {
        while (!q.isEmpty()) {
            Cell c = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i]; int ny = c.y + dy[i];
                Cell child = new Cell(nx, ny, c.vitality, inactive);
                if (!petriDish.containsKey(child) && !deadCells.contains(child)) {
                    petriDish.put(child, c.vitality+1);
                }
            }
        }
    }

    //세포 나이먹게 하기
    static void age() {
        HashMap<Cell, Integer> temp = new HashMap<>(); //임시 저장 맵

        for (Map.Entry<Cell, Integer> entry : petriDish.entrySet()) {
            Cell current = entry.getKey();
            int X = entry.getValue();

            if (current.status == inactive) { //비활성화 상태일 때
                if (--X == 0) {
                    current.status = active; //상태 변환
                    X = current.vitality;
                    q.add(current); //큐에 저장
                }
            }
            else if (current.status == active) { //활성화 상태일 때
                if (--X == 0) {
                    current.status = dead;
                    deadCells.add(current);
                    continue; //맵에서 지울것이므로 임시 맵에 저장하지 않음
                }
            }

            temp.put(current, X); //변경된 내용을 임시 맵에 저장
        }

        //임시 맵의 내용을 원래 맵에 반영
        petriDish.clear();
        petriDish.putAll(temp);
    }
}