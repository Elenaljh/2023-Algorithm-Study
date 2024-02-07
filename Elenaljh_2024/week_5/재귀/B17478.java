package 재귀;
/*
https://www.acmicpc.net/problem/17478
재귀함수가뭔가요
 */
import java.util.*;

public class B17478 {
    static String a = "\"재귀함수가 뭔가요?\"";
    static String b1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String b2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String b3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    static String d = "라고 답변하였지.";
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        chatbot(n,0);
        System.out.println(sb);
    }
    static void chatbot(int n, int count) {
        if (count == n) {
            String deco = "____".repeat(count);
            sb.append(deco).append(a).append("\n");
            sb.append(deco).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
            sb.append(deco).append(d).append("\n");
            return;
        }
        String deco = "____".repeat(count);
        sb.append(deco).append(a).append("\n");
        sb.append(deco).append(b1).append("\n");
        sb.append(deco).append(b2).append("\n");
        sb.append(deco).append(b3).append("\n");
        chatbot(n, count+1);
        sb.append(deco).append(d).append("\n");
    }
}
