package 숙제;

import java.util.*;
import java.io.*;
public class B6987_월드컵 {
    static int[][] table;
    static int[][] pairs = new int[][]{{0,1}, {0,2}, {0,3}, {0,4}, {0,5},
            {1,2}, {1,3}, {1,4}, {1,5},
            {2,3}, {2,4}, {2,5},
            {3,4}, {3,5},
            {4,5}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 4; t++) {
            st = new StringTokenizer(br.readLine());
            table = new int[6][3];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean validGame = numOfGames();
            boolean validScore = play(0);


            if (validScore && validGame) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    static boolean play(int count) {
        if (count == 15) {
            return true;
        }

        int first = pairs[count][0]; int second = pairs[count][1];

        //승, 패
        if (table[first][0] > 0 && table[second][2] > 0) {
            table[first][0]--; table[second][2]--;
            if (play(count+1)) return true;
            table[first][0]++; table[second][2]++;
        }
        //무, 무
        if (table[first][1] > 0 && table[second][1] > 0) {
            table[first][1]--; table[second][1]--;
            if (play(count+1)) return true;
            table[first][1]++; table[second][1]++;
        }

        //패, 승
        if (table[first][2] > 0 && table[second][0] > 0) {
            table[first][2]--; table[second][0]--;
            if (play(count+1)) return true;
            table[first][2]++; table[second][0]++;
        }
        return false;
    }

    static boolean numOfGames() {
        int count;
        for (int i = 0; i < 6; i++) {
            count = 0;
            for (int j = 0; j < 3; j++) {
                count += table[i][j];
            }
            if (count != 5) return false;
        }
        return true;
    }
}
