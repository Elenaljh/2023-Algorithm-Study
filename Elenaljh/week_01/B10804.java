import java.util.*;
public class B10804 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[20];
        int[] arr1 = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = i+1;
            arr1[i] = i+1;
        }
        
        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt(); //5
            int b = sc.nextInt(); //10
            int reverse = b-1;
            for (int j = a-1; j < b; j++) {
                arr[j] = arr1[reverse];
                reverse--;
            }
            for (int j = 0; j < 20; j++) {
                arr1[j] = arr[j];
            }
        }
        
        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i] + " ");
        }
        
    }
}