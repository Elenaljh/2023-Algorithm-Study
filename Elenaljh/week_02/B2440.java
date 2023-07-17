import java.util.Scanner;
public class B2440 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}