import java.io.*;

//브루트포스
public class B2231 {
    public static void main(String[] args) throws IOException {
        //입출력 버퍼 선언
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //입력받기, 변수선언
        String s = bf.readLine();
        int length = s.length();
        int n = Integer.parseInt(s);
        int result = 0;

        //로직 - 브루트포스
        //시작은 n - length*9부터 (가능한 가장 작은 생성자)
        for (int i = n - length*9; i < n; i++) {
            //각 자릿수 합
            int sum = i;
            int number = i;
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            //sum == n인지 검증
            if (sum == n) {
                result = i;
                break;
            }
        }

        //출력 후 마무리
        System.out.println(result); //for문 안에 result 넣으면 안됨
        //for문 벗어난 후 main함수 마지막에 반환값이 있어야 함..
        bf.close();
    }
}
