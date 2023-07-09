import java.util.*;
public class B1267 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Y = 0;
        int M = 0;
        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            Y += (input/30 + 1) * 10;
            M += (input/60 + 1) * 15;
        }
       
        if (Y > M) { System.out.println("M " + M);}
        else if (M > Y) {System.out.println("Y " + Y);}
        else if (M == Y) {System.out.println("Y M " + Y);}
    }
}