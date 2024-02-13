package 과제;

import java.io.*;
import java.util.*;

/*
이전 순열
https://www.acmicpc.net/problem/10973
 */
public class B10973 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] num = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        //i>i+1인 i 찾기 (pivot=i)
        int pivot = -1;
        for (int i = n-2; i >= 0; i--) {
            if (num[i] > num[i+1]) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1) {
            System.out.println(-1);
            return;
        }

        //pivot오른쪽 값 중 pivot보다 작은 수 중 가장 큰 수 찾기
        int maxIndex = -1;
        for (int i = pivot+1; i < n; i++) {
            if (num[pivot] > num[i]) {
                if (maxIndex == -1) maxIndex = i;
                if (num[i] > num[maxIndex]) maxIndex = i;
            }
        }

        //pivot과 maxIndex 스왑
        int tmp = num[pivot];
        num[pivot] = num[maxIndex];
        num[maxIndex] = tmp;

        //pivot 오른쪽 내림차순 정렬
        Arrays.sort(num, pivot+1, n, Collections.reverseOrder());

        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(num[i]).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
