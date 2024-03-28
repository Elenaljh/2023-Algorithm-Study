import java.io.*;
import java.util.*;
public class B2239_스도쿠 {
    static Deque<Integer[]> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = str.charAt(j) - '0';
                if (map[i][j] == 0) {
                    dq.addLast(new Integer[]{i, j});
                }
            }
        }

        //문제풀기
        back(map); //끝

    }
    //백트래킹
    static boolean back(int[][] map) {
        //종료조건: 빈 칸이 없을 때
        if (dq.isEmpty()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            return true;
        }

        Integer[] cell = dq.pollFirst();
        int row = cell[0]; int col = cell[1];
        List<Integer> candidates = intersect(col, row, map);
        for (Integer c : candidates) {
            map[row][col] = c;
            if (back(map)) return true;
            map[row][col] = 0;
        }
        dq.addFirst(cell);
        return false;
    }

    //교집합
    static List<Integer> intersect(int col, int row, int[][] map) {
        Set<Integer> set1 = checkCol(col, map);
        Set<Integer> set2 = checkRow(row, map);
        Set<Integer> set3 = checkBlock(col, row, map);
        set1.retainAll(set2); set1.retainAll(set3); //set1: 모두의 교집합이 됨
        List<Integer> list = new ArrayList<>(set1);
        Collections.sort(list);
        return list;
    }

    //열 검사
    static Set<Integer> checkCol(int col, int[][] map) {
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 1; i <= 9; i++) resultSet.add(i);
        for (int r = 0; r < 9; r++) {
            resultSet.remove(map[r][col]);
        }
        return resultSet;
    }

    //행 검사
    static Set<Integer> checkRow(int row, int[][] map) {
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 1; i <= 9; i++) resultSet.add(i);
        for (int c = 0; c < 9; c++) {
            resultSet.remove(map[row][c]);
        }
        return resultSet;
    }

    //블록 검사
    static Set<Integer> checkBlock(int col, int row, int[][] map) {
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 1; i <= 9; i++) resultSet.add(i);
        for (int r = determine(row); r < determine(row)+3; r++) {
            for (int c = determine(col); c < determine(col)+3; c++) {
                resultSet.remove(map[r][c]);
            }
        }
        return resultSet;
    }

    //블록 위치 결정
    static int determine(int index) {
        if (index < 3) return 0;
        else if (index < 6) return 3;
        return 6;
    }

}
