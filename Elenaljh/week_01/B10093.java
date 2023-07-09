import java.util.*;
public class B10093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        
        if (A > B) {
            long tmp = B;
            B = A;
            A = tmp;
        } else if (A == B) {
            System.out.println(0);
            return;
        }
        System.out.println(B-A-1);
        for (long i = A+1; i < B; i++) {
            System.out.print(i + " ");
        }
        
    }
}