import java.util.*;

public class B2576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 100;
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            int input = sc.nextInt();
            if(input % 2 != 0) {
                if(min > input) {min = input;}
                sum += input;
            }
        }
        if (sum == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
    }
}