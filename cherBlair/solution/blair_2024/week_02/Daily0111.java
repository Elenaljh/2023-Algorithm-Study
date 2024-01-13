package blair_2024.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Daily0111 {

    // 04-4 퀵 정렬

    // k번째 수 구하기
    // https://www.acmicpc.net/problem/11004

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int count = Integer.parseInt(st.nextToken());
        int numK = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());

        int[] savedArray = new int[count];
        for (int i = 0; i < count; i++) {
            savedArray[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(savedArray, 0, count - 1, numK - 1);
        System.out.println(savedArray[numK - 1]);
    }

    private static void quickSort(int[] A, int S, int E, int K) {
        if (S < E) {
            int pivot = partition(A, S, E);
            if (pivot == K) {
                return;
            } else if (K < pivot) {
                quickSort(A, S, pivot - 1, K);
            } else {
                quickSort(A, pivot + 1, E, K);
            }
        }
    }

    private static int partition(int[] A, int S, int E) {
        if (S + 1 == E) {
            if (A[S] > A[E]) {
                swap(A, S, E);
                return E;
            }
        }
        int M = (S + E) / 2;
        swap(A, S, M); // 중앙 값을 1번째 요소로 이동
        int pivot = A[S];
        int i = S + 1, j = E;
        while (i <= j) {
            while (j > S + 1 && pivot < A[j]) {
                j--;
            }
            while (i <= E && pivot > A[i]) {
                i++;
            }
            if (i <= j) {
                swap(A, i++, j--);
            }
        }
        // 피벗 데이터를 나눠진 두 그룹의 경계 index에 저장하기
        A[S] = A[j];
        A[j] = pivot;
        return j;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
