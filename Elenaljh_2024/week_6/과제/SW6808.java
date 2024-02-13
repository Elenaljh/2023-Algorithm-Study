package 과제;
/*
규영이와 인영이의 카드게임
 */
import java.io.*;
import java.util.*;

public class SW6808 {
    static List<Integer> cardsG, cardsI;
    static int win, lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            win = 0; lose = 0;
            cardsG = new ArrayList<>();
            cardsI = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                cardsG.add(Integer.parseInt(st.nextToken()));
            }
            for (int i = 1; i <= 18; i++) {
                if (!cardsG.contains(i)) cardsI.add(i);
            }
            makePermutation(0, new int[9], new boolean[9]);
            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);
    }

    static void makePermutation(int count, int[] selected, boolean[] visited) {
        if (count == 9) {
            int gyu = 0, inyoung = 0;
            for (int i = 0; i < 9; i++) {
                if (cardsG.get(i) > selected[i]) {
                    gyu += cardsG.get(i) + selected[i];
                } else {
                    inyoung += cardsG.get(i) + selected[i];
                }
            }
            if (gyu > inyoung) {
                win++;
            } else if (inyoung > gyu) {
                lose++;
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected[count] = cardsI.get(i);
                makePermutation(count+1, selected, visited);
                visited[i] = false;
            }
        }
    }
}
