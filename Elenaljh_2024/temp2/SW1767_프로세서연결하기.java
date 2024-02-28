import java.io.*;
import java.util.*;
public class SW1767_프로세서연결하기 {
    static class Processor {
        public int x, y;
        public Processor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
    static int[] dx = new int[]{-1, 1, 0, 0}; //상하좌우
    static int[] dy = new int[]{0, 0, -1, 1};
    static List<Processor> list;
    static int minLength, N, maxProcessors, numOfP, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            //정보 입력
            N = Integer.parseInt(br.readLine());
            minLength = Integer.MAX_VALUE;
            map = new int[N][N];
            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1 && i != 0 && j != 0 && i != N-1 && j!=N-1) {
                        list.add(new Processor(i, j));
                    }
                }
            }
            numOfP = list.size();
            maxProcessors = 0;

            perm(0, new int[numOfP], list);

            sb.append("#").append(test).append(" ").append(minLength).append("\n");
        }
        System.out.println(sb);

    }

    //전선 길이 구하기
    static void perm(int count, int[] selected, List<Processor> list) {
        if (count == list.size()) {
            int num = numberOfProcessors(selected); //전선 연결할 프로세서 개수
            if (num < maxProcessors) return;
            //전선 설치 - 전선 총길이 구하기(구할 수 없으면 Integer.MAX_VALUE 반환) - 재귀
            int length = getTotalLength(selected, list); //전선 길이 구하기
            //MIN값 갱신-
            if (length != Integer.MAX_VALUE) {
                minLength = Integer.min(length, minLength);
                maxProcessors = num;
            }

            return;
        }

        //전선 설치 방향 정하기 (0:상, 1:하, 2:좌, 3:우, 4: 설치 안함)
        for (int i = 0; i < 4; i++) {
            selected[count] = i;

            perm(count+1, selected, list);
        }
    }

    static int getTotalLength(int[] selected, List<Processor> list) {
        //리턴할 변수 선언
        int length = 0;

        //맵 베끼기
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) copy[i] = map[i].clone();

        //맵에다가 전선 표시하기
        for (int i = 0; i < selected.length; i++) {
            int x = list.get(i).x; int y = list.get(i).y;
            int direction = selected[i];
            if (direction == 4) continue; //설치 아예 안하는 경우 전선의 길이 셀 필요x
            int nx = x+dx[direction]; int ny = y+dy[direction];
            while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (copy[nx][ny] == 1) return Integer.MAX_VALUE;
                copy[nx][ny] = 1;
                length++;
                if (length > minLength) return Integer.MAX_VALUE; //가지치기
                nx += dx[direction]; ny += dy[direction];
            }
        }

        //리턴
        return length;
    }

    static int numberOfProcessors(int[] selected) {
        int notUsed = 0;
        for (int i = 0; i < selected.length; i++) {
            if (selected[i] == 4) notUsed++;
        }
        return numOfP-notUsed;
    }
}
