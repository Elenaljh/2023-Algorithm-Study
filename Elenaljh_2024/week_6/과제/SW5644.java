package 과제;
/*
무선 충전
 */
import java.io.*;
import java.util.*;
public class SW5644 {
    static int[] dx = new int[]{0, -1, 0, 1, 0}; //이동X, 상, 우, 하, 좌
    static int[] dy = new int[]{0, 0, 1, 0, -1};
    static int M, A, moveA[], moveB[];
    static int AX, AY, BX, BY, sum;
    static Charger[] chargers;

    static class Charger implements Comparable<Charger> {
        public int P; //성능
        public int persons; //범위 안 사람의 수
        public int C; //충전 범위
        public int x; //행
        public int y; //열
        public Charger(String x, String y, String c, String p) {
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
            this.C = Integer.parseInt(c);
            this.P = Integer.parseInt(p);
            this.persons = 0;
        }
        @Override
        public int compareTo(Charger o) {
            return this.P/this.persons - o.P/o.persons;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //총 이동시간
            A = Integer.parseInt(st.nextToken()); //BC의 개수
            moveA = new int[M]; moveB = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) moveA[i] = Integer.parseInt(st.nextToken()); //A이동정보
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) moveB[i] = Integer.parseInt(st.nextToken()); //B이동정보
            chargers = new Charger[A];
            for (int i = 0; i < A; i++) { //충전소 배열에 저장
                st = new StringTokenizer(br.readLine());
                chargers[i] = new Charger(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
            }

            //로직
            sum = 0; //충전양 더하는 곳
            for (int i = 0; i < M; i++) {
                AX = AX + dx[moveA[i]];
                AY = AY + dy[moveA[i]];
                BX = BX + dx[moveB[i]];
                BY = BY + dy[moveB[i]];
                calculate();
            }
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }

    static void calculate() { //a:A이동, b:B이동
        List<Charger> listA = new ArrayList<>();
        List<Charger> listB = new ArrayList<>();
        for (Charger charger : chargers) {
            if ((Math.abs(charger.x-AX)+Math.abs(charger.y-AY))<=charger.C) {
                charger.persons = charger.persons + 1;
                listA.add(charger);
            }
            if ((Math.abs(charger.x-BX)+Math.abs(charger.y-BY))<=charger.C) {
                charger.persons = charger.persons + 1;
                listB.add(charger);
            }
        }

        if (!listA.isEmpty()) {
            Charger A = Collections.max(listA);
            sum += A.P/A.persons;
            for (Charger charger : listA) {
                charger.persons = charger.persons - 1;
            }
        }
        if (!listB.isEmpty()) {
            Charger B = Collections.max(listB);
            sum += B.P/B.persons;
            for (Charger charger : listB) {
                charger.persons = charger.persons - 1;
            }
        }
    }
}
