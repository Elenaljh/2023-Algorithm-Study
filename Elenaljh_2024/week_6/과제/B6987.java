package 과제;
/*
월드컵
https://www.acmicpc.net/problem/6987
 */
import java.util.*;
import java.io.*;
public class B6987 {
    static int[][] scores = new int[6][3];
    static StringBuilder sb = new StringBuilder();
    static int[] home = new int[]{0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
    static int[] away = new int[]{1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int t = 0; t < 4; t++) { //테스트케이스 4가지
            st = new StringTokenizer(br.readLine());

            //표 입력
            int count = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    scores[i][j] = Integer.parseInt(st.nextToken());
                    count+=scores[i][j];
                }
            }

            //경기 횟수 검증 (총 30경기)
            if (count != 30) {
                sb.append(0).append(" ");
                continue;
            }

            //경기 결과 검증
            if (play(0)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
    static boolean play(int count) {
        if (count == 15) {
            return true;
        }

        //승리
        if (scores[home[count]][0] > 0 && scores[away[count]][2] > 0) {
            scores[home[count]][0]--; scores[away[count]][2]--;
            if (play(count+1)) return true;
            scores[home[count]][0]++; scores[away[count]][2]++;
        }

        //패배
        if (scores[home[count]][2] > 0 && scores[away[count]][0] > 0) {
            scores[home[count]][2]--; scores[away[count]][0]--;
            if (play(count+1)) return true;
            scores[home[count]][2]++; scores[away[count]][0]++;
        }

        //무승부
        if (scores[home[count]][1] > 0 && scores[away[count]][1] > 0) {
            scores[home[count]][1]--; scores[away[count]][1]--;
            if (play(count+1)) return true;
            scores[home[count]][1]++; scores[away[count]][1]++;
        }

        return false;
    }

}

