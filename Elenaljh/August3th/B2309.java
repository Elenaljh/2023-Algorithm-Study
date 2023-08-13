import java.util.*;

public class B2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        
        int last = sum - 100;
        boolean found = false;
        
        for (int i = 0; i < 8 && !found; i++) {
            for (int j = 1; j < 9 && !found; j++) {
                if (arr[i] + arr[j] == last) {
                    arr[i] = -1;
                    arr[j] = -1;
                    found = true;
                }
            }
        }
        Arrays.sort(arr);
        for (int i = 2; i < 9; i++) {
            System.out.println(arr[i]);
        }
    }
}