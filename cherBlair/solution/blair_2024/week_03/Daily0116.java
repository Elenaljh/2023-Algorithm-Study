package blair_2024.week_03;

import java.io.*;

public class Daily0116 {

    // 04-5 병합 정렬

    // 수 정렬하기 2
    // https://www.acmicpc.net/problem/2751

    public static int[] sortedArray, tempArray;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        sortedArray = new int[count + 1];
        tempArray = new int[count + 1];
        for (int i = 1; i <= count; i++) {
            sortedArray[i] = Integer.parseInt(br.readLine());
        }

        // 병합 정렬 수행
        mergeSort(1, count);
        for (int i = 1; i <= count; i++) {
            bw.write(sortedArray[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int middle = start + (end - start) / 2;

        // 재귀 함수 형태로 구현
        mergeSort(start, middle);
        mergeSort(middle + 1, end);
        for (int i = start; i <= end; i++) {
            tempArray[i] = sortedArray[i];
        }
        int k = start;
        int index1 = start;
        int index2 = middle + 1;

        // 두 그룹 병합
        while (index1 <= middle && index2 <= end) {
            if (tempArray[index1] > tempArray[index2]) {
                sortedArray[k] = tempArray[index2];
                k++;
                index2++;
            } else {
                sortedArray[k] = tempArray[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= middle) {
            sortedArray[k] = tempArray[index1];
            k++;
            index1++;
        }
        while (index2 <= end) {
            sortedArray[k] = tempArray[index2];
            k++;
            index2++;
        }
    }
}
