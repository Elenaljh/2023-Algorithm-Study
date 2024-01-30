/*
과제
https://www.acmicpc.net/problem/17478
 */
//과제

import java.io.*;
public class B17478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        int count = 0;
        recursion(n, count);
    }

    static void recursion(int n, int count) {
        String a = "\"재귀함수가 뭔가요?\"";
        String b = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
        String b2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
        String b3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
        String c = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
        String d = "라고 답변하였지.";

        printBars(count); System.out.println(a);
        if (count < n) {
            printBars(count); System.out.println(b);
            printBars(count); System.out.println(b2);
            printBars(count); System.out.println(b3);
            count++;
            recursion(n, count);
            printBars(count - 1); System.out.println(d);
        } else {
            printBars(count); System.out.println(c);
            printBars(count); System.out.println(d);
        }


    }

    static void printBars(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("____");
        }
    }
}
