package blair_2024.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Daily0125 {

    // 04-5 병합 정렬

    // 버블 소트 프로그램 2
    // https://www.acmicpc.net/problem/1517

    public static int[] sortArray, temp;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        sortArray = new int[count + 1];
        temp = new int[count + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= count; i++) {
            sortArray[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        mergeSort(1, count); // 병합 정렬 수행
        System.out.println(result);
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int middle = start + (end - start) / 2;

        // 재귀 함수 형태로 수현
        mergeSort(start, middle);
        mergeSort(middle + 1, end);
        for (int i = start; i <= end; i++) {
            temp[i] = sortArray[i];
        }
        int k = start;
        int idx1 = start;
        int idx2 = middle + 1;
        while (idx1 <= middle && idx2 <= end) { // 두 그룹 병합 로직
            if (temp[idx1] > temp[idx2]) {
                sortArray[k] = temp[idx2];
                result = result + idx2 - k; // 뒤쪽 데이터 값이 작은 경우 result 업데이트
                k++;
                idx2++;
            } else {
                sortArray[k] = temp[idx1];
                k++;
                idx1++;
            }
        }
        while (idx1 <= middle) {
            sortArray[k] = temp[idx1];
            k++;
            idx1++;
        }
        while (idx1 <= end) {
            sortArray[k] = temp[idx2];
            k++;
            idx2++;
        }
    }
}
