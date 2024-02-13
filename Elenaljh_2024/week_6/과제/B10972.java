package 과제;
/*
https://www.acmicpc.net/problem/10972
다음순열
 */
import java.io.*;
import java.util.*;
public class B10972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        //오른쪽 -> 왼쪽: i < i+1 인 i 찾기 (피벗포인트)
        int pivot = -1;
        for (int i = n-2; i >= 0; i--) {
            if (numbers[i] < numbers[i+1]) {
                pivot = i;
                break;
            }
        }
        //종료조건
        if (pivot == -1) {
            System.out.println(-1);
            return;
        }
        //피번 포인트의 오른쪽 요소들 중 피벗 포인트보다 크고 가장 작은 값을 찾기
        int minIndex = -1;
        for (int i = pivot+1; i < n; i++) {
            if (numbers[pivot] < numbers[i]) {
                if (minIndex == -1) minIndex = i;
                if (numbers[i] < numbers[minIndex]) minIndex = i;
            }
        }
        //피벗포인트와 찾은 값 교환
        int tmp = numbers[pivot];
        numbers[pivot] = numbers[minIndex];
        numbers[minIndex] = tmp;
        //피벗포인트의 오른쪽 요소들을 뒤집어 오름차순으로 정렬
        int[] arr = new int[n-pivot-1];
        for (int i = pivot+1; i < n; i++) {
            arr[i-1-pivot] = numbers[i];
        }
        int a = n-pivot-2;
        for (int i = pivot+1; i < n; i++) {
            numbers[i] = arr[a];
            a--;
        }
        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(numbers[i]).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
