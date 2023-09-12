import java.io.*;
import java.util.*;

//Hash Set을 이용한 풀이
public class B3273_Set {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //변수받기
        int length = Integer.parseInt(bf.readLine()); //배열길이
        int[] numbers = new int[length]; //배열 선언
        HashSet<Integer> set = new HashSet<>(); //Hash Set 선언

        //숫자 받아서 배열에 저장하기
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            set.add(numbers[i]); //set에도 저장
        }

        int x = Integer.parseInt(bf.readLine()); //x값

        //조건 만족하는 쌍의 개수 출력
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(set.contains(x - numbers[i])) count++;
        }

        System.out.println(count/2);
        bf.close();
    }
}
