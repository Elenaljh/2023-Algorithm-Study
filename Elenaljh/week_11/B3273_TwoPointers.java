import java.io.*;
import java.util.*;
public class B3273_TwoPointers {
    static int length, x, count;
    static int numbers[];
    public static void main(String[] args) throws IOException {
        //입력받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(bf.readLine());
        numbers = new int[length];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(bf.readLine());

        // 메인로직
        Arrays.sort(numbers); //배열 정렬
        int left = 0;
        int right = length-1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == x) {
                count++;
                left++;
                right--;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }

        //정답출력, 마무리
        System.out.println(count);
        bf.close();
    }
}
