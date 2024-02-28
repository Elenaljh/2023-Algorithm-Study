import java.io.*;
import java.util.*;
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
            if (this == o) {
                return true;
            }
            if (!(o instanceof Cell cell)) {
                return false;
            }
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
    }
    static final int inactive = 0, active = 1, dead = 2; //cell status에 사용할 것
    static HashMap<Cell, Integer> petriDish = new HashMap<>(); //세포, 남은 시간 넣음(처음 X가 깎이면 활성화되어 다시 X시간동안 살고 그 동안 번식함)
    static PriorityQueue<Cell> q = new PriorityQueue<>();
    static int N, M, K;
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

            //해시맵에 세포:생명력 형태로 저장한다.
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int X = Integer.parseInt(st.nextToken());
                    Cell c = new Cell(i, j, X, inactive);
                    petriDish.put(c, X);
                }
            }


        }
    }

    static void timePass() {

    }
}
