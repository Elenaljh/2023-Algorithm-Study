package 스터디;

import java.io.*;
import java.util.*;
public class B15686 {
    static int N, M, MAP[][], MIN = Integer.MAX_VALUE;
    static boolean[] isSelected;
    static List<Integer[]> households = new ArrayList<>();
    static List<Integer[]> chickens = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAP = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
                if (MAP[i][j] == 1) households.add(new Integer[]{i, j});
                if (MAP[i][j] == 2) chickens.add(new Integer[]{i, j});
            }
        }
        isSelected = new boolean[chickens.size()];
        select(0, 0);
        System.out.println(MIN);
    }

    static void select(int count, int start) {
        if (count == M) {
            MIN = Integer.min(MIN, calcShortest());
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            isSelected[i] = true;
            select(count+1, i+1);
            isSelected[i] = false;
        }
    }

    static int calcShortest() {
        int distance, min, sum = 0;
        for (Integer[] house : households) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (isSelected[i]) {
                    distance = Math.abs(house[0]-chickens.get(i)[0]) + Math.abs(house[1]-chickens.get(i)[1]);
                    min = Integer.min(min, distance);
                }
            }
            sum += min;
        }
        return sum;
    }
}
