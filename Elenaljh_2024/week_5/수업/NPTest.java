package 수업;

import java.util.Arrays;
import java.util.Scanner;

//Next Permutation
public class NPTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        //step0 : 정렬(오름차순)
        Arrays.sort(input);

        //np이용
        do {
            //순열 이용한 처리 로직 쓰기..
            System.out.println(Arrays.toString(input));
        } while(np(input));
    }

    //순열의 뒤쪽부터 작은 변화를 준다.
    public static boolean np(int[] p) { //현순열의 사전순 다음 순열 생성(p:현순열)
        final int N = p.length;
        // step1: 교환위치 찾기 (뒤쪽부터 꼭대기를 찾으면 꼭대기 이전이 교환위치가 됨)
        int i = N-1;
        while(i>0 && p[i-1]>=p[i]) --i;
        if (i==0) return false; //현순열의 상태가 가장 큰 순열이므로 np 없음

        //step2: 교환위치(i-1)에 넣을 값 뒤쪽부터 찾기(큰 값 중 최소값)
        int j = N-1;
        while(p[i-1] >= p[j]) --j; //교환값을 찾지 못하는 경우가 없음

        //step3: 교환위치(i-1)값과 찾은 위치(j)값을 교환
        swap(p, i-1, j);

        //step4: 꼭대기(i)위치부터 맨 뒤까지 오름차순 정렬
        int k = N-1;
        while(i<k) swap(p, i++, k--);

        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
