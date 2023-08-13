import java.util.*;
public class B2490 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int d = 0;
            for (int j = 0; j < 4; j++) {
                int input = sc.nextInt();
                if (input == 1) {d++;}
            }
            switch (d) {
                case 3: System.out.println('A');
                    break;
                case 2: System.out.println('B');
                    break;
                case 1: System.out.println('C');
                    break;
                case 0: System.out.println('D');
                    break;
                case 4: System.out.println('E');
                    break;
            }
        }
    }
}