import java.io.*;
import java.util.*;

class B13300 {
    public static void main(String[] args) throws IOException {
        //n, k 받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); //입력수
        int k = Integer.parseInt(st.nextToken()); //한 방 학생수

        //2차원 배열[여/남][학년-1]에 학생 수 저장
        int[][] std = new int[2][6];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            std[gender][grade-1]++;
        }

        //방 갯수
        int rooms = 0;

        //방 갯수 구하기
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if (std[i][j]%k==0) {
                    rooms += std[i][j]/k;
                } else {
                    rooms += std[i][j]/k+1;
                }
            }
        }

        System.out.println(rooms);
        bf.close();
    }
}