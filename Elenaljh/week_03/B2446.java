import java.util.Scanner;

public class B2446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = (N-i)*2 - 1; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < N-1; i++) {
            for (int j = N-2-i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = i*2+3; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}