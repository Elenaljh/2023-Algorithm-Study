import java.io.*;
import java.util.*;
public class B24416_피보나치수1 {
    static int[] arr;
    static int count1, count2;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n+1];
        arr[1] = 1; arr[2] = 1;
        count1 = 0; count2 = 0;
        fib(n);
        fibonacci(n);

        System.out.println(count1 + " " + count2);
    }

    //재귀
    static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    //dp
    static int fibonacci(int n) {
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            count2++;
        }
        return arr[n];
    }
}