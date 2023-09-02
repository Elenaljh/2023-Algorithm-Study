import java.io.*;
import java.util.*;

public class B2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //변수 받기 (m<n)
        int m = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        int min = -1;
        int sum = 0;
        
        //에라토스테네스의 체
        boolean[] prime = new boolean[n+1];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                for (int j = i*i; j <= n; j+=i) {
                    prime[j] = true;
                }
            }
        }
        
        //변수세팅
        for (int i = m; i <= n; i++) {
            if (!prime[i]) {
                if (min == -1) min = i; //for문 돌 때마다 검사는 미개한것같은데
                sum += i;
            }
        }
        
        if (min != -1) System.out.println(sum);
        System.out.println(min);
        bf.close();
    }
   
}