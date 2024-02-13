package 과제;
/*
동전 자판기(하)
https://jungol.co.kr/problem/1183?cursor=eyJwcm9ibGVtc2V0Ijo4LCJmaWVsZCI6MiwiaWR4Ijo2fQ%3D%3D
 */
import java.io.*;
import java.util.*;
public class J1183 {
    static int[] coins = new int[]{500, 100, 50, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        int[] input = new int[6];
        int[] minus = new int[6];
        int sum = 0, totCoins = 0, minusCoins = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            sum += input[i]*coins[i];
            totCoins += input[i];
        }
        w = sum - w;

        //동전 구하기
        for (int i = 0; i < 6; i++) {
            minus[i] = Math.min(input[i], w/coins[i]);
            w -= minus[i]*coins[i];
            minusCoins += minus[i];
        }

        //출력
        for (int i = 0; i < 6; i++) {
            sb.append(input[i]-minus[i]).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(totCoins-minusCoins);
        System.out.println(sb);
    }
}
