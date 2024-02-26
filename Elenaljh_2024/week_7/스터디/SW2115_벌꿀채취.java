package 스터디;

import java.io.*;
import java.util.*;
public class SW2115_벌꿀채취 {
    static int N, M, C, honeycombs[][], ANSWER, MAX1, MAX2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //벌통 가로세로
            M = Integer.parseInt(st.nextToken()); //선택가능한 벌집 수
            C = Integer.parseInt(st.nextToken()); //꿀 채취 가능한 양
            honeycombs = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    honeycombs[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ANSWER = 0;
            selectRow(0, 0, new int[2]);

            sb.append("#").append(testCase).append(" ").append(ANSWER).append("\n");
        }
        System.out.println(sb);

    }

    //N개 행 중 2개 고르는 메서드
    static void selectRow(int count, int start, int[] selected) {
        if (count == 2) {
            //selected 배열에는 두 행이 저장됨. 각 행에 대해 작업하기(동시에 작업할 생각 ㄴㄴ..)
            MAX1 = 0; MAX2 = 0;
            selectHoneycombs(selected[0], 1);
            selectHoneycombs(selected[1], 2);
            ANSWER = Integer.max(ANSWER, MAX1+MAX2);
            return;
        }

        for (int i = start; i < N; i++) {
            selected[count] = i;
            selectRow(count+1, i+1, selected);
        }
    }

    //해당 행에서 연속된 숫자 고르는 메서드
    static void selectHoneycombs(int row, int number) { //number: MAX1, MAX2 저장 여부
        int[] targetRow = new int[M];
        for (int i = 0; i <= N-M; i++) {
            for (int j = 0; j < M; j++) {
                targetRow[j] = honeycombs[row][i+j];
            }
            //MAX_number에 수익 저장
            selectCombs(new boolean[M], number, 0, targetRow);
        }
    }

    //더해서 가장 큰 수 조합 구하는 메서드
    static void selectCombs(boolean[] selected, int number, int count, int[] selectedHoneyCombs) {
        if (count == M) {
            if (checkQuantity(selected, selectedHoneyCombs)) {
                int revenue = calcRevenue(selected, selectedHoneyCombs);
                if (number == 1) MAX1 = Integer.max(MAX1, revenue);
                else MAX2 = Integer.max(MAX2, revenue);
            }
            return;
        }

        selected[count] = true;
        selectCombs(selected, number, count+1, selectedHoneyCombs);
        selected[count] = false;
        selectCombs(selected, number, count+1, selectedHoneyCombs);
    }


    //수익 계산하는 메서드
    static int calcRevenue(boolean[] selected, int[] selectedHoneycomb) {
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (selected[i]) count += selectedHoneycomb[i] * selectedHoneycomb[i];
        }
        return count;
    }

    //더해서 C 넘기는지 확인
    static boolean checkQuantity(boolean[] selected, int[] selectedHoneycomb) {
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (selected[i]) count += selectedHoneycomb[i];
        }
        if (count <= C) return true;
        return false;
    }


}
