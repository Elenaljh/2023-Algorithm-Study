import java.util.Scanner;

public class A1547 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-i-1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2*i+1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}