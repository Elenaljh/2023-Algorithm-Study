package 과제;
/*
최적경로
복습 필수!!
 */
import java.io.*;
import java.util.StringTokenizer;

public class SW1247 {
    static class Points {
        int x;
        int y;
        Points(String x, String y) {
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
        }
        int getDistance(Points o) {
            return Math.abs(this.x-o.x) + Math.abs(this.y-o.y);
        }
    }
    static Points[] clients; //고객 리스트
    static int N, MIN;
    static Points home; //집

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); //전체 테스트케이스 수
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); //고객의 수
            clients = new Points[N];
            MIN = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());

            //회사, 집, 고객 좌표 입력
            Points company = new Points(st.nextToken(), st.nextToken());
            home = new Points(st.nextToken(), st.nextToken());
            for (int i = 0; i < N; i++) clients[i] = new Points(st.nextToken(), st.nextToken());

            dfs(0, company, 0, 0); //가장 처음 방문한 곳은 회사니까..

            sb.append("#").append(t).append(" ").append(MIN).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int count, Points prev, int sum, int flag) {
        //중단조건
        if (sum > MIN) return; //sum이 min보다 크면 굳이 더 탐색할 필요가 없다(시간낭비임)

        //다 방문한 경우
        if (count == N) {
            MIN = Math.min(MIN, sum + home.getDistance(prev)); //sum + 집가는 길과 min 비교
            return;
        }

        //방문하기
        for (int i = 0; i < N; i++) {
            if ((flag & 1 << i) != 0) continue; //방문했다면 패스
            dfs(count + 1, clients[i], sum + prev.getDistance(clients[i]), flag | 1 << i); //방문표시해줌!
        }
    }
}
