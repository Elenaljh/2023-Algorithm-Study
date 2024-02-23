package 숙제;

import java.util.*;
import java.io.*;
public class B17281_야구 {
    static Deque<Integer> dq; //선수들 대기실
    static int[] place = new int[3]; //1루, 2루, 3루
    static int N, ability[][], players[], MAX;
    static boolean[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        ability = new int[N][10];
        players = new int[10];
        selected = new boolean[10];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setOrder(1);

        System.out.println(MAX);
    }

    static void setOrder(int count) {
        if (count == 10) {
            dq = new ArrayDeque<>();
            for (int i = 1; i < 10; i++) dq.addLast(players[i]);
            int score = 0;

            for (int inning = 0; inning < N; inning++) {
                score += play(inning);
            }
            //최대 점수 갱신
            MAX = Integer.max(score, MAX);
            return;
        }

        if (count == 4) {
            players[count] = 1;
            setOrder(count+1);
        } else {
            for (int i = 2; i < 10; i++) {
                if (!selected[i]) {
                    selected[i] = true;
                    players[count] = i;
                    setOrder(count+1);
                    selected[i] = false;
                }
            }
        }
    }



    static int play(int inning) { //1이닝, order == 0 -> 0번째 경기한다는 뜻
        int score = 0;
        int out = 0;
        while (out != 3) {
            int player = dq.pollFirst();
            dq.addLast(player);
            int hit = ability[inning][player];
            if (hit == 0) {
                out++;
                continue;
            }
            score += run(hit, player);
        }
        Arrays.fill(place, 0);
        return score;
    }

    static int run(int hit, int player) {
        int score = 0;
        for (int i = 2; i >= 0; i--) {
            if (place[i] != 0) {
                if (i + hit > 2){
                    place[i] = 0;
                    score++;
                } else {
                    place[i+hit] = place[i];
                    place[i] = 0;
                }
            }
        }
        if (hit-1 > 2) {
            score++;
        } else {
            place[hit-1] = player;
        }
        return score;
    }
}
