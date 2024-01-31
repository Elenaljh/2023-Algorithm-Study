package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HanoiTower {
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        hanoi(count, 1, 2, 3);
        System.out.println(result);
    }

    static void hanoi(int count, int from, int tmp, int to) {
        if (count == 0) return; //기저조건
        hanoi(count-1, from, to, tmp); //위의 원판 n-1개를 남는 기둥에 옮긴다
        result.append(count + " : " + from + " -> " + to + "\n"); //맨 마지막 원판을 목적지에 보냄
        hanoi(count-1, tmp, from, to); //남는 기둥에 있는 원판 n-1개를 목적 기둥에 옮긴다.
    }


}
