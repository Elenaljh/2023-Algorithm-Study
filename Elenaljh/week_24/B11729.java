import java.io.*;
import java.util.*;

public class B11729 {

    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //옮긴 횟수 출력
        //Hanoi(n) = 2^n -1  -> Hanoi(n) = 2*Hanoi(n-1) + 1 일반항
        sb.append((int) Math.pow(2, n) - 1).append("\n");
        //Hanoi 함수 실행
        Hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    //n: 원판 개수
    //start: 출발지 ->A
    //mid: 옮기기 위해 이동하는 장소 ->B
    //to: 목적지 ->C
    public static void Hanoi(int n, int start, int mid, int to) {
        //원판 하나 옮길 때는 그냥 한번 옮기면 됨
        if (n == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        // 원판 n-1개를 A -> C 로 옮기는 경우
        //1. n-1개를 A(start) -> B(to)
        Hanoi(n-1, start, to, mid);
        //2. 1개를 A(start) -> C(to)
        sb.append(start + " " + to + "\n");
        //3. n-1개를 B(start) -> C(to)
        Hanoi(n-1, mid, start, to);
    }
}
