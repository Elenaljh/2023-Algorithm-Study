import java.io.*;
import java.util.*;

public class B12873 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


    }

    public static void print(int n) {
        System.out.println("\"재귀함수가 뭔가요?\"");
        if (n == 0) {
            System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        }
        if (n > 0) {
            System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        }
    }
}
