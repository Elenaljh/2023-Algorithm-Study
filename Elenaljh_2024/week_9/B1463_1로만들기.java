import java.util.Scanner;

public class B1463_1로만들기 {
    static int[] dp; //메모이제이션 할 배열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n];

    }

    static int function(int n) {
        if (dp[n] == 0) { //탐색하지 않은 n일 경우
            if (n%6 == 0) {
                dp[n] = Math.min(function(n-1), Math.min(function(n/3), function(n/2))) + 1;
            } else if (n%3 == 0) {

            } else if (n%2 == 0) {

            } else {

            }

        }
        return dp[n];
    }
}
