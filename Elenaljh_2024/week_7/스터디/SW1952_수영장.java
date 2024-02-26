package 스터디;

import java.util.*;
import java.io.*;
public class SW1952_수영장 {
    static int DAY, MONTH, THREEMONTH, YEAR, MIN;
    static int[] table;
    static int[] check; //0은 일일권, 1은 한달권, 3은 세달권, -1은 계산X (세달권: 3, -1, -1)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            DAY = Integer.parseInt(st.nextToken());
            MONTH = Integer.parseInt(st.nextToken());
            THREEMONTH = Integer.parseInt(st.nextToken());
            YEAR = Integer.parseInt(st.nextToken());
            MIN = YEAR;

            table = new int[14];
            check = new int[14];
            int days = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                table[i] = Integer.parseInt(st.nextToken());
                days += table[i];
            }
            Arrays.fill(check, 12, 14, -5);

            //1일권으로만 계산하기
            MIN = Integer.min(MIN, DAY * days);

            //1달권 도입: 1달권 사용이 이득인 달 찾아서 바꿔 계산하기
            int price = 0;
            for (int i = 0; i < 12; i++) {
                if (MONTH < table[i]*DAY) {
                    price += MONTH;
                    check[i] = 1;
                } else {
                    price += table[i]*DAY;
                }
            }
            MIN = Integer.min(MIN, price);

            //3달권 도입: 여러 경우의 수가 나온다..
            calThreeMonth(0);

            sb.append("#").append(testCase).append(" ").append(MIN).append("\n");
        }
        System.out.println(sb);
    }

    static void calThreeMonth(int start) {
        if (start == 12) {
            //계산
            int price = 0;
            for (int i = 0; i < 12; i++) {
                if (check[i]==0) price += table[i]*DAY;
                if (check[i]==1) price += MONTH;
                if (check[i]==3) price += THREEMONTH;
            }
            //MIN 업데이트
            MIN = Integer.min(price, MIN);
            return;
        }

        int check1 = check[start], check2 = check[start+1], check3 = check[start+2];
        if (check1!=-1 && check2!=-1 && check3!=-1) { //이미 3달 계산이 된 구간이면 pass
            int original = 0;
            for (int j = 0; j < 3; j++) {
                if (check[start+j]==0) original += table[start+j] * DAY; //일일권 계산
                if (check[start+j]==1) original += MONTH; //한달권 계산
            }
            if (original > THREEMONTH) { //세달권이 더 싸다면
                check[start] = 3; check[start+1] = -1; check[start+2] = -1; //체크 변경
            }
            calThreeMonth(start+1); //세달권 적용 후 재귀 진입
        }
        check[start] = check1; check[start+1] = check2; check[start+2] = check3; //원상복귀
        calThreeMonth(start+1); //세달권 적용 안하고 재귀 진입
    }

}


